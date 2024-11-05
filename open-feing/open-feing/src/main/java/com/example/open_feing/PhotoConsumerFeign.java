package com.example.open_feing;

import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "phot-consumer",url = "https://jsonplaceholder.typicode.com/")
public interface PhotoConsumerFeign {

    @GetMapping(value = "/photos")
    List<Photo> getPhotos();

    @GetMapping(value = "/photos/{id}")
    Photo getPhotos(@PathVariable("id") Long id);
}
