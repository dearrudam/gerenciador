package com.perifacode.gerenciador.adapter.presenters;

import com.perifacode.gerenciador.entity.MEMBRO_TYPE;
import java.time.LocalDate;
import java.util.List;

public class MembroFiltro {

  private LocalDate dataCriacaoInicio;
  private LocalDate dataCriacaoFim;
  private LocalDate dataAtaulizacaoInicio;
  private LocalDate dataAtaulizacaoFim;

  private MEMBRO_TYPE tipo;
  private List<TipoIniciativaDto> participandoDe;

  public MembroFiltro() {
  }

  public MembroFiltro(LocalDate dataCriacaoInicio, LocalDate dataCriacaoFim,
                      LocalDate dataAtaulizacaoInicio, LocalDate dataAtaulizacaoFim,
                      MEMBRO_TYPE tipo,
                      List<TipoIniciativaDto> participandoDe) {
    this.dataCriacaoInicio = dataCriacaoInicio;
    this.dataCriacaoFim = dataCriacaoFim;
    this.dataAtaulizacaoInicio = dataAtaulizacaoInicio;
    this.dataAtaulizacaoFim = dataAtaulizacaoFim;
    this.tipo = tipo;
    this.participandoDe = participandoDe;
  }

  public LocalDate getDataCriacaoInicio() {
    return dataCriacaoInicio;
  }

  public void setDataCriacaoInicio(LocalDate dataCriacaoInicio) {
    this.dataCriacaoInicio = dataCriacaoInicio;
  }

  public LocalDate getDataCriacaoFim() {
    return dataCriacaoFim;
  }

  public void setDataCriacaoFim(LocalDate dataCriacaoFim) {
    this.dataCriacaoFim = dataCriacaoFim;
  }

  public LocalDate getDataAtaulizacaoInicio() {
    return dataAtaulizacaoInicio;
  }

  public void setDataAtaulizacaoInicio(LocalDate dataAtaulizacaoInicio) {
    this.dataAtaulizacaoInicio = dataAtaulizacaoInicio;
  }

  public LocalDate getDataAtaulizacaoFim() {
    return dataAtaulizacaoFim;
  }

  public void setDataAtaulizacaoFim(LocalDate dataAtaulizacaoFim) {
    this.dataAtaulizacaoFim = dataAtaulizacaoFim;
  }

  public MEMBRO_TYPE getTipo() {
    return tipo;
  }

  public void setTipo(MEMBRO_TYPE tipo) {
    this.tipo = tipo;
  }

  public List<TipoIniciativaDto> getParticipandoDe() {
    return participandoDe;
  }

  public void setParticipandoDe(
      List<TipoIniciativaDto> participandoDe) {
    this.participandoDe = participandoDe;
  }
}
