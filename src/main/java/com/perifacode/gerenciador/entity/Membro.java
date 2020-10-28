package com.perifacode.gerenciador.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membro {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String email;

  private String usuario;

  private boolean aceitePolitica;

  private LocalDate dataInclusao;

  private LocalDate dataAlteracao;

  private List<String> interesses;

  private boolean ativo;

  public Membro() {
  }

  public Membro(String email, String usuario, boolean aceitePolitica,
                LocalDate dataInclusao, LocalDate dataAlteracao,
                List<String> interesses, boolean ativo) {
    this.email = email;
    this.usuario = usuario;
    this.aceitePolitica = aceitePolitica;
    this.dataInclusao = dataInclusao;
    this.dataAlteracao = dataAlteracao;
    this.interesses = interesses;
    this.ativo = ativo;
  }

  public static Membro construirNovoMembro(String email, String usuario,
                                           boolean aceitePolitica, List<String> interesses) {
    return new Membro(email, usuario, aceitePolitica,
        LocalDate.now(), LocalDate.now(), interesses, true);
  }

  public String getEmail() {
    return email;
  }

  public String getUsuario() {
    return usuario;
  }

  public boolean isAceitePolitica() {
    return aceitePolitica;
  }

  public long getId() {
    return id;
  }

  public LocalDate getDataInclusao() {
    return dataInclusao;
  }

  public LocalDate getDataAlteracao() {
    return dataAlteracao;
  }

  public List<String> getInteresses() {
    return interesses;
  }

  public boolean isAtivo() {
    return ativo;
  }
}
