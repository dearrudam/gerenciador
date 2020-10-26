package com.perifacode.gerenciador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TipoIniciativa extends BaseEntity {

  public TipoIniciativa(){}

  public TipoIniciativa(long id, @NotBlank String codigo,
                        @NotBlank String titulo,
                        @NotBlank String descricao, boolean ativo) {
    this.id = id;
    this.codigo = codigo;
    this.titulo = titulo;
    this.descricao = descricao;
    this.ativo = ativo;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  @Column(unique = true)
  private String codigo;

  @NotBlank
  @Column(unique = true)
  private String titulo;

  @NotBlank
  private String descricao;

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

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }
}
