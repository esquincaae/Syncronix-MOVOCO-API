package com.mocovo.mocovo.repositories;

import com.mocovo.mocovo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long userId);

    Optional<Cart> findByProduct_Id(Long productId);
}
