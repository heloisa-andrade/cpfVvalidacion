package com.example.open_feing;

import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "phot-consumer",url = "https://viacep.com.br")
public interface PhotoConsumerFeign{

    @GetMapping(value = "/ws/{cep}/json")
    Photo getPhotos(@PathVariable("cep") String id);
}
