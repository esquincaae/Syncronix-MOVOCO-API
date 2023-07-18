package com.syncronix.movoco.services;

import com.syncronix.movoco.MQTT.dtos.AmpSensorDataBodyRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.controllers.exceptions.ObjectNotFoundException;
import com.syncronix.movoco.entities.AmpSensor;
import com.syncronix.movoco.repositories.IAmpSensorRepository;
import com.syncronix.movoco.services.interfaces.IAmpSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmpSensorServiceImpl implements IAmpSensorService {
    @Autowired
    private IAmpSensorRepository repository;

    @Override
    public void create(AmpSensorDataBodyRequest request) {

        repository.save(from(request));
    }

    @Override
    public BaseResponse list() {
        List<AmpSensor> data = repository.findAll();

        List<Float> dataColumn =data.stream()
                .map(AmpSensor::getMedia)
                .toList();


        return BaseResponse.builder()
                .data(dataColumn)
                .message("Data found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }




    private AmpSensor from(AmpSensorDataBodyRequest request){
        AmpSensor ampSensor = new AmpSensor();
        ampSensor.setAmp(request.getAmp());
        ampSensor.setMedia(request.getMedia());
        ampSensor.setMediana(request.getMediana());
        ampSensor.setModa(request.getModa());
        ampSensor.setVariance(request.getVariance());
        ampSensor.setStandardDeviation(request.getStandardDeviation());
        ampSensor.setMeanDeviation(request.getMeanDeviation());

        return ampSensor;

    }
}
