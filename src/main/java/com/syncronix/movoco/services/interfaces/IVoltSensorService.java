package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.MQTT.dtos.VoltSensorDataBodyRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;

public interface IVoltSensorService {
    void create(VoltSensorDataBodyRequest request);

    String findLastDataFromVolt();

    String findLastDataFromMeanDeviation();

    String findLastDataFromMedia();

    String findLastDataFromStandardDeviation();

    String findLastDataFromVariance();
    BaseResponse list();



}

