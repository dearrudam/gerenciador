package com.perifacode.gerenciador.entity;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
abstract class BaseEntity {

  private LocalDateTime dataCadastro;

  private LocalDateTime dataAtualizacao;

  public LocalDateTime getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(LocalDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public LocalDateTime getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  @PrePersist
  protected void onCreate() {
    this.dataCadastro = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.dataAtualizacao = LocalDateTime.now();
  }

}
