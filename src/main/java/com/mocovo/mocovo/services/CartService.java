package com.mocovo.mocovo.demo.services;

import com.mocovo.mocovo.controllers.dto.requests.CartRequest;
import com.mocovo.mocovo.controllers.dto.responses.BaseResponse;
import com.mocovo.mocovo.controllers.dto.responses.CartResponse;
import com.mocovo.mocovo.controllers.dto.responses.UserResponse;
import com.mocovo.mocovo.entities.User;
import com.mocovo.mocovo.entities.Cart;
import com.mocovo.mocovo.repositories.ICartRepository;
import com.mocovo.mocovo.repositories.IUserRepository;
import com.mocovo.mocovo.services.interfaces.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private IUserRepository userRepository;


    @Override
    public BaseResponse list(Long userId) {
        List<Cart> carts = cartRepository.findAllByUserId(userId);

        return BaseResponse.builder()
                .data(carts)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }


    private List<CartResponse> from(List<Cart> carts) {

        List<CartResponse> responses = new ArrayList<>();

        for (Cart cart : carts) {
            CartResponse cartResponse = new CartResponse();
            ProductResponse productResponse = new ProductResponse();
            UserResponse userResponse = new UserResponse();

            productResponse.setName(cart.getProduct().getName());
            productResponse.setStock(cart.getProduct().getStock());
            productResponse.setPrice(cart.getProduct().getPrice());
            productResponse.setId(cart.getProduct().getId());
            productResponse.setCategoryId(cart.getProduct().getCategory().getId());

            double totalPrice = cart.getProduct().getPrice() * cart.getQuantity();
            userResponse.setEmail(cart.getUser().getEmail());
            userResponse.setId(cart.getUser().getId());
            userResponse.setRolId(cart.getUser().getRole().getId());

            cartResponse.setId(cart.getId());
            cartResponse.setProductResponse(productResponse);
            cartResponse.setUserResponse(userResponse);
            cartResponse.setQuantity(cart.getQuantity());
            cartResponse.setTotalPrice(totalPrice);
            responses.add(cartResponse);
        }
        return responses;
    }

    @Override
    public BaseResponse delete(Long id) {
        cartRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public BaseResponse create(CartRequest cartRequest) {
        Cart cart;
        User user = userRepository.findById(cartRequest.getUserId()).get();
        Product product = productRepository.findById(cartRequest.getProductId()).get();

        Optional<Cart> optionalCart = cartRepository.findByProduct_Id(cartRequest.getProductId());

        if (optionalCart.isEmpty()) {
            cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setQuantity(cartRequest.getQuantity());
        } else {
            cart = optionalCart.get();
            Integer newQuantity = cart.getQuantity() + cartRequest.getQuantity();
            cart.setQuantity(newQuantity);
        }

        Cart cartSaved = cartRepository.save(cart);

        return BaseResponse.builder()
                .data(cartSaved)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(Long cartId, CartRequest cartRequest) {
        Cart cart = cartRepository.findById(cartId).get();
        Product product = productRepository.findById(cartRequest.getProductId()).get();
        if (!cartRepository.existsById(cartId))
            throw new RuntimeException("El carrito no existe");

        cart.setProduct(product);
        cart.setQuantity(cartRequest.getQuantity());
        Cart cartSaved = cartRepository.save(cart);

        return BaseResponse.builder()
                .data(cartSaved)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }
    /*
    public CartResponse update(Long id, CartRequest request){
        Cart cart = repository.findById(id).orElseThrow(() -> new RuntimeException("El carrito no existe"));
        cart = update(cart, request);
        return from(cart);
    }*/

    private Cart update(Cart carProduct, CartRequest request) {
        carProduct.setQuantity(request.getQuantity());
        return carProduct;
    }

    private CartResponse from(Cart cart, Product product, User user) {
        CartResponse cartResponse = new CartResponse();
        ProductResponse productResponse = new ProductResponse();
        UserResponse userResponse = new UserResponse();

        cartResponse.setId(cart.getId());

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setStock(product.getStock());
        productResponse.setPrice(product.getPrice());
        productResponse.setCategoryId(product.getCategory().getId());

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        //userResponse.setPassword(user.getPassword());
        userResponse.setRolId(user.getRole().getId());


        cartResponse.setProductResponse(productResponse);
        cartResponse.setUserResponse(userResponse);
        cartResponse.setTotalPrice(cart.getQuantity() * cart.getProduct().getPrice());
        cartResponse.setQuantity(cart.getQuantity());

        return cartResponse;
    }

}
