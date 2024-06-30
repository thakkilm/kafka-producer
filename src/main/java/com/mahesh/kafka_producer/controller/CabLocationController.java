package com.mahesh.kafka_producer.controller;

import com.mahesh.kafka_producer.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;


    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {

        int i=0;
        while (i<100){
            cabLocationService.updateLocation(Math.random()+" , "+Math.random());
            Thread.sleep(1000);
            i++;
        }
        return  new ResponseEntity<>(Map.of("message","Location Update"), HttpStatus.OK);
    }
}
