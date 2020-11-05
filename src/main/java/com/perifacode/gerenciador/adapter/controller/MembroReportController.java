package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.adapter.presenters.MembroFiltro;
import com.perifacode.gerenciador.adapter.presenters.ReportMembros;
import com.perifacode.gerenciador.entity.Membro;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/report-membros")
public class MembroReportController {

  @PostMapping
  public ResponseEntity<ReportMembros> relatorioDeMembros(@RequestBody @Valid MembroFiltro filtro) {
    return ResponseEntity.ok(new ReportMembros());
  }

}
