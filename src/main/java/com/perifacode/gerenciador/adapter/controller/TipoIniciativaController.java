package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.Converter;
import com.perifacode.gerenciador.adapter.common.TipoIniciativaConverter;
import com.perifacode.gerenciador.adapter.presenters.TipoIniciativaDto;
import com.perifacode.gerenciador.driver.repository.TipoIniciativaRepository;
import com.perifacode.gerenciador.entity.TipoIniciativa;
import java.util.Optional;
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
  private TipoIniciativaRepository tipoIniciativaRepository;

  @Autowired
  private TipoIniciativaConverter converter;

  @PostMapping
  public ResponseEntity<TipoIniciativaDto> inserir(@RequestBody TipoIniciativaDto tipoIniciativa) {
    return ResponseEntity.ok(
        converter.convertFromDto(
            tipoIniciativaRepository.save(
                converter.convertFromEntity(tipoIniciativa))));
  }

  @GetMapping("/{codTipoIniciativa}")
  public ResponseEntity<TipoIniciativaDto> buscar(
      @PathVariable("codTipoIniciativa") String codTipoIniciativa) {
    Optional<TipoIniciativa> optionalTipoIniciativa = tipoIniciativaRepository.findByCodigo(
        codTipoIniciativa);
    if (optionalTipoIniciativa.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(
          converter.convertFromDto(
              optionalTipoIniciativa.get()));
    }
  }

}
