package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.presenters.TipoIniciativaDto;
import com.perifacode.gerenciador.usecase.TipoIniciativaService;
import com.perifacode.gerenciador.usecase.excecao.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo-iniciativa")
public class TipoIniciativaController {

  @Autowired
  private TipoIniciativaService tipoIniciativaService;

  @PostMapping
  public ResponseEntity<TipoIniciativaDto> inserir(@RequestBody TipoIniciativaDto tipoIniciativa) {
    return ResponseEntity.ok(tipoIniciativaService.novaIniciativa(tipoIniciativa));
  }

  @GetMapping("/{codTipoIniciativa}")
  public ResponseEntity<TipoIniciativaDto> buscar(
      @PathVariable("codTipoIniciativa") String codTipoIniciativa) {
    Resultado<TipoIniciativaDto, RuntimeException> tipoIniciativa =
        tipoIniciativaService.findByCodigo(
            codTipoIniciativa);
    if (tipoIniciativa.isSucess()) {
      return ResponseEntity.ok(
          tipoIniciativa.getResult());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
