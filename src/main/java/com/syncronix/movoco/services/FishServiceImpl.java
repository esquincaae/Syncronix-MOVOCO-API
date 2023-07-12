package com.syncronix.movoco.services;

import com.syncronix.movoco.controllers.dtos.requests.CreateFishRequest;
import com.syncronix.movoco.controllers.dtos.requests.UpdateFishRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.controllers.exceptions.ObjectNotFoundException;
import com.syncronix.movoco.entities.Fish;
import com.syncronix.movoco.repositories.IFishRepository;
import com.syncronix.movoco.services.interfaces.IFishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FishServiceImpl implements IFishService {

    @Autowired
    private IFishRepository repository;


    @Override
    public BaseResponse get(Long id) {

        Fish fish = findOneAndEnsureExistById(id);

        return BaseResponse.builder()
                .data(fish)
                .message("Fish found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateFishRequest request) {

        Fish fish = repository.save(from(request));

        return BaseResponse.builder()
                .data(fish)
                .message("Fish added correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateFishRequest request) {

        Fish fishes = findOneAndEnsureExistById(id);

        fishes = update(fishes, request);

        return BaseResponse.builder()
                .data(fishes)
                .message("Fish data update correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }


    @Override
    public BaseResponse delete(Long id) {

        repository.deleteById(id);
        return BaseResponse.builder()
                .data(Collections.EMPTY_LIST)
                .message("Fish deleted correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
    }

    @Override
    public BaseResponse list(Long userId) {
        List<Fish> fishes = new ArrayList<>();

        if (userId != null){
            fishes = repository.findAllByUserId(userId);

        }else {
            fishes = repository.findAll();
        }

        return BaseResponse.builder()
                .data(fishes)
                .message("Fishes found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Fish findOneAndEnsureExistById(Long id) {
        return  repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("The fish does not exist"));
    }

    private Fish from(CreateFishRequest request ){
        Fish fish = new Fish();
        fish.setName(request.getName());
        fish.setSpices(request.getSpices());
        fish.setImageUrl(request.getImageUrl());
        return fish;
    }

  private Fish update(Fish fishes, UpdateFishRequest request){
        fishes.setName(request.getName());
        fishes.setSpices(request.getSpices());
        fishes.setImageUrl(request.getImageUrl());
        repository.save(fishes);
        return fishes;
  }



}
