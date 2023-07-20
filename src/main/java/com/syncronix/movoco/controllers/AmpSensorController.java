package com.syncronix.movoco.controllers;

import com.syncronix.movoco.services.interfaces.IAmpSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ampsensor")
public class AmpSensorController {

    @Autowired
    private IAmpSensorService service;

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

    @GetMapping("amp")
    public ResponseEntity<String> findLastDataFromAmp(){

        String lasData = service.findLastDataFromAmp();

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
