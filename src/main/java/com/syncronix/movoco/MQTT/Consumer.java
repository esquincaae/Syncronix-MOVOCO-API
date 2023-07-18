package com.example.intellifishbackend.MQTT;

import com.example.intellifishbackend.MQTT.dtos.PhSensorDataBodyRequest;
import com.example.intellifishbackend.MQTT.dtos.WaterFlowSensorDataBodyRequest;
import com.example.intellifishbackend.MQTT.dtos.WaterTemperatureSensorDataBodyRequest;
import com.example.intellifishbackend.services.interfaces.IPhSensorService;
import com.example.intellifishbackend.services.interfaces.IWaterFlowSensorService;
import com.example.intellifishbackend.services.interfaces.IWaterTemperatureService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    IPhSensorService phSensorService;

    @Autowired
    IWaterTemperatureService waterTemperatureService;

    @Autowired
    IWaterFlowSensorService waterFlowSensorService;


    @RabbitListener(queues = {"${exchange.queue.phSensor.name}"})
    public void phSensor(PhSensorDataBodyRequest request){

        phSensorService.create(request);


    }

    @RabbitListener(queues = {"${exchange.queue.waterTemperatureSensor.name}"})
    public void waterTemperatureSensor(WaterTemperatureSensorDataBodyRequest request){

        waterTemperatureService.create(request);
    }

    @RabbitListener(queues = {"${exchange.queue.waterFlowSensor.name}"})
    public void waterFlowSensor(WaterFlowSensorDataBodyRequest request){

        waterFlowSensorService.create(request);
    }

}
