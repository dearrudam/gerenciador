package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.MembroService;
import java.awt.print.Pageable;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.coyote.Response;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
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

  @GetMapping(path = "{email}")
  public MembroDto buscar(@PathVariable("email") String email) {
    Membro membro = membroService.buscar(email);
    return membroConverter.convertFromEntity(membro);
  }


  @GetMapping(path = "/")
  public ResponseEntity<String> buscarByDataInclusao(
      @Valid
        @RequestParam(name = "dataInclusao.range", required = false)
          @Size(max = 2, min = 2)
          List<@Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}") String> dataInclusaoRange,
      @Valid @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
        @RequestParam(name = "dataInclusao", required = false) String dataInclusao,
      @Valid @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
        @RequestParam(name = "dataInclusao.ge", required = false) String dataInclusaoGe,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size) {


    if(dataInclusao != null){

    }
    if(dataInclusaoGe != null){
        // busca todos maiores que determinada data
    }
    return ResponseEntity.ok( "ok");
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
