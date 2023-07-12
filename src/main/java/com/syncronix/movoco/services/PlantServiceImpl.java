package com.syncronix.movoco.services;

import com.syncronix.movoco.controllers.dtos.requests.CreatePlantRequest;
import com.syncronix.movoco.controllers.dtos.requests.UpdatePlantRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.controllers.exceptions.ObjectNotFoundException;
import com.syncronix.movoco.entities.Plant;
import com.syncronix.movoco.repositories.IPlantRepository;
import com.syncronix.movoco.services.interfaces.IPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class PlantServiceImpl implements IPlantService {

    @Autowired
    private IPlantRepository repository;
    @Override
    public BaseResponse get(Long id) {

        Plant plant= findOneAndEnsureExistById(id);

        return BaseResponse.builder()
                .data(plant)
                .message("Plant found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreatePlantRequest request) {

        Plant plant = repository.save(from(request));



        return BaseResponse.builder()
                .data(plant)
                .message("Plant created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdatePlantRequest request) {

        Plant plant = findOneAndEnsureExistById(id);

        plant = update(plant, request);

        return BaseResponse.builder()
                .data(plant)
                .message("Plant update correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {

        repository.deleteById(id);



        return BaseResponse.builder()
                .data(Collections.EMPTY_LIST)
                .message("Plant deleted correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
    }

    @Override
    public BaseResponse list(Long userId) {

        List<Plant> plants = new ArrayList<>();

        if (userId != null){
            plants = repository.findAllByUserId(userId);
        }else {
            plants = repository.findAll();
        }

        return BaseResponse.builder()
                .data(plants)
                .message("Plants found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Plant findOneAndEnsureExistById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("The plant does not exist"));
    }

    private Plant from(CreatePlantRequest request){
        Plant plant = new Plant();

        plant.setSpecies(request.getSpices());
        plant.setImageUrl(request.getImageUrl());

        return plant;
    }

    private Plant update(Plant plant, UpdatePlantRequest request){

        plant.setSpecies(request.getSpices());
        plant.setImageUrl(request.getImageUrl());
        repository.save(plant);

        return plant;
    }
}
