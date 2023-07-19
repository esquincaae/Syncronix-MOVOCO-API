package com.syncronix.movoco.services;

import com.syncronix.movoco.MQTT.dtos.VoltSensorDataBodyRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.entities.VoltSensor;
import com.syncronix.movoco.repositories.IVoltSensorRepository;
import com.syncronix.movoco.services.interfaces.IVoltSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoltSensorServiceImpl implements IVoltSensorService {
    @Autowired
    private IVoltSensorRepository repository;

    @Override
    public void create(VoltSensorDataBodyRequest request) {

        repository.save(from(request));
    }

    @Override
    public BaseResponse list() {
        List<VoltSensor> data = repository.findAll();

        List<Float> dataColumn =data.stream()
                .map(VoltSensor::getMedia)
                .toList();


        return BaseResponse.builder()
                .data(dataColumn)
                .message("Data found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private VoltSensor from(VoltSensorDataBodyRequest request){
        VoltSensor voltSensor = new VoltSensor();
        voltSensor.setVolt(request.getVolt());
        voltSensor.setMedia(request.getMedia());
        voltSensor.setVariance(request.getVariance());
        voltSensor.setStandardDeviation(request.getStandardDeviation());
        voltSensor.setMeanDeviation(request.getMeanDeviation());

        return voltSensor;

    }
}
