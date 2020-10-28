package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.MembroService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
public class MembroController {

  @Autowired
  private MembroService membroService;

  @PostMapping
  public MembroDto incluir(@RequestBody @Valid MembroDto membroDto) {
    Membro membro = MembroConverter.membroDtoToMembro(membroDto);

    membro = membroService.incluir(membro);

    return MembroConverter.membroToMembroDto(membro);
  }

  @GetMapping(path = "{email}")
  public MembroDto buscar(@PathVariable("email") String email) {

    Membro membro = membroService.buscar(email);

    return MembroConverter.membroToMembroDto(membro);

  }

}
