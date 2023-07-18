package com.syncronix.movoco.MQTT;

import com.syncronix.movoco.MQTT.dtos.VoltSensorDataBodyRequest;
import com.syncronix.movoco.MQTT.dtos.AmpSensorDataBodyRequest;
import com.syncronix.movoco.services.interfaces.IAmpSensorService;
import com.syncronix.movoco.services.interfaces.IVoltSensorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    IAmpSensorService ampSensorService;
    @Autowired
    IVoltSensorService voltSensorService;

    @RabbitListener(queues = {"${exchange.queue.ampSensor.name}"})
    public void ampSensor(AmpSensorDataBodyRequest request){

        ampSensorService.create(request);
    }
    @RabbitListener(queues = {"${exchange.queue.voltSensor.name}"})
    public void voltSensor(VoltSensorDataBodyRequest request){

        voltSensorService.create(request);
    }

}
