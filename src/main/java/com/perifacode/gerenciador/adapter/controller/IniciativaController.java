package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.IniciativaConverter;
import com.perifacode.gerenciador.adapter.presenters.IniciativaDto;
import com.perifacode.gerenciador.entity.Iniciativa;
import com.perifacode.gerenciador.usecase.IniciativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/iniciativas")
public class IniciativaController {

    @Autowired
    private IniciativaService iniciativaService;

    @Autowired
    private IniciativaConverter iniciativaConverter;

    @PostMapping
    public IniciativaDto incluir(@RequestBody @Valid IniciativaDto iniciativaDto) {
        Iniciativa iniciativa = IniciativaConverter.iniciativaDtoToIniciativa(iniciativaDto);
        iniciativa = iniciativaService.incluir(iniciativa);
        return iniciativaConverter.convertFromEntity(iniciativa);
    }

}
