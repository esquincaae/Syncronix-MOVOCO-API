package com.syncronix.movoco.services.interfaces;


import com.syncronix.movoco.MQTT.dtos.AmpSensorDataBodyRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;

import java.util.List;

public interface IAmpSensorService {

    void create(AmpSensorDataBodyRequest request);

    BaseResponse list();

    String findLastDataFromMedia();

    String findLastDataFromMeanDeviation();

    String findLastDataFromAmp();

    String findLastDataFromStandardDeviation();

    String findLastDataFromVariance();


}
