package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.controllers.dtos.requests.CreatePlantRequest;
import com.syncronix.movoco.controllers.dtos.requests.UpdatePlantRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.entities.Plant;
import org.springframework.stereotype.Service;


public interface IPlantService {

    BaseResponse get (Long id);

    BaseResponse create (CreatePlantRequest request);

    BaseResponse update (Long id, UpdatePlantRequest request);

    BaseResponse delete (Long id);

    BaseResponse list (Long userId);

    Plant findOneAndEnsureExistById(Long id);
}
