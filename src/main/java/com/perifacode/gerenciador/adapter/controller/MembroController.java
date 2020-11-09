package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.MembroService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
public class MembroController {

  @Autowired
  private MembroService membroService;

  @Autowired
  private MembroConverter membroConverter;

  @PostMapping
  public MembroDto incluir(@RequestBody @Valid MembroDto membroDto) {
    Membro membro = MembroConverter.membroDtoToMembro(membroDto);
    membro = membroService.incluir(membro);
    return membroConverter.convertFromEntity(membro);
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<MembroDto> buscarMembroId(@PathVariable("id") long id) {
    try {
      return new ResponseEntity<>(membroService.buscarMembroId(id), HttpStatus.FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(value = "/{membro_id}")
  public ResponseEntity<MembroDto> updateMembro(@PathVariable("membro_id") Long membroId,
                                                @RequestBody MembroDto membro) {
    return ResponseEntity.ok(membroService.atualizar(membroId, membro));
  }

  @DeleteMapping(value = "/{membro_id}")
  public ResponseEntity<Boolean> deleteMembro(@PathVariable("membro_id") Long membroId) {
    return new ResponseEntity(membroService.inativaMembro(membroId), HttpStatus.ACCEPTED);
  }

}
