package com.syncronix.movoco.MQTT.dtos;

import lombok.Getter;

@Getter
public class VoltSensorDataBodyRequest {

    private Float media;
    private Float variance;
    private Float standardDeviation;
    private Float meanDeviation;
    private Float volt;
}
