package com.example.excepiont_handeles.api;

import com.example.excepiont_handeles.dto.FinaceiroDTO;
import com.example.excepiont_handeles.service.FinaceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class FinaceiroApi {
    @Autowired
    private FinaceiroService finaceiroService;
    @PostMapping
    public FinaceiroDTO salvar(@RequestBody  FinaceiroDTO finaceiroDTO){
        return finaceiroService.salvar(finaceiroDTO);
    }
}
