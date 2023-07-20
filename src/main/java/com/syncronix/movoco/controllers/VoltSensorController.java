package com.syncronix.movoco.controllers;

import com.syncronix.movoco.services.interfaces.IVoltSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class VoltSensorController {

    @Autowired
    private IVoltSensorService service;

    @GetMapping("media")
    public ResponseEntity<String> findLastDataFromMedia(){

        String lastData = service.findLastDataFromMedia();

        return ResponseEntity.ok(lastData);

    }

    @GetMapping("meanDeviation")
    public ResponseEntity<String> findLastDataFromMeanDeviation(){

        String lasData = service.findLastDataFromMeanDeviation();

        return ResponseEntity.ok(lasData);
    }

    @GetMapping("volt")
    public ResponseEntity<String> findLastDataFromVolt(){

        String lasData = service.findLastDataFromVolt();

        return ResponseEntity.ok(lasData);

    }

    @GetMapping("standardDeviation")
    public ResponseEntity<String> findLastDataFromStandardDeviation(){

        String lasData = service.findLastDataFromStandardDeviation();

        return ResponseEntity.ok(lasData);
    }

    @GetMapping("variance")
    public ResponseEntity<String> findLastDataFromVariance(){

        String lasData = service.findLastDataFromVariance();

        return ResponseEntity.ok(lasData);
    }
}
