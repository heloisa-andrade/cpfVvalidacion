package com.example.open_feing.controller;

import com.example.open_feing.PhotoConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private  PhotoConsumerFeign photoConsumerFeign;

    @GetMapping("/teste")
    public ResponseEntity<String> teste (){
        String aaaaa = photoConsumerFeign.getPhotos("04913000").toString();
        return ResponseEntity.status(HttpStatus.OK).body(aaaaa);
    }
}
