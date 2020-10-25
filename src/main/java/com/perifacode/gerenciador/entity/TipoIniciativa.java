package com.perifacode.gerenciador.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TipoIniciativa {

  public TipoIniciativa(){}

  public TipoIniciativa(long id, @NotBlank String codigo,
                        @NotBlank String titulo,
                        @NotBlank String descricao,
                        @NotBlank LocalDateTime dataCadastro,
                        @NotBlank LocalDateTime dataAtualizacao, boolean ativo) {
    this.id = id;
    this.codigo = codigo;
    this.titulo = titulo;
    this.descricao = descricao;
    this.dataCadastro = dataCadastro;
    this.dataAtualizacao = dataAtualizacao;
    this.ativo = ativo;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  private String codigo;

  @NotBlank
  private String titulo;

  @NotBlank
  private String descricao;

  @NotBlank
  private LocalDateTime dataCadastro;

  @NotBlank
  private LocalDateTime dataAtualizacao;

  private boolean ativo;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

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

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }
}
