package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.MembroService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
public class MembroController {

  @Autowired
  MembroService membroService;

  @PostMapping
  public MembroDto incluir(@RequestBody @Valid MembroDto membroDto){
      Membro membro = MembroConverter.membroDtoToMembro(membroDto);

      membro = membroService.incluir(membro);

      return MembroConverter.membroToMembroDto(membro);
  }

}
