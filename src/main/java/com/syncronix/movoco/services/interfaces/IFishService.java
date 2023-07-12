package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.controllers.dtos.requests.CreateFishRequest;
import com.syncronix.movoco.controllers.dtos.requests.UpdateFishRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.entities.Fish;

public interface IFishService {

    BaseResponse get (Long id);

    BaseResponse create (CreateFishRequest request);

    BaseResponse update (Long id, UpdateFishRequest request);

    BaseResponse delete (Long id);

    BaseResponse list (Long userId);

    Fish findOneAndEnsureExistById(Long id);
}
