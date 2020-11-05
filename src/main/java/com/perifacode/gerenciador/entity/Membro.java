package com.perifacode.gerenciador.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membro extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String email;

  private String usuario;

  private boolean aceitePolitica;

  private MEMBRO_TYPE membroType;

  @ElementCollection
  private List<String> interesses;

  private boolean ativo;

  public Membro() {
  }

  public Membro(String email, String usuario, boolean aceitePolitica,
                List<String> interesses, boolean ativo) {
    this.email = email;
    this.usuario = usuario;
    this.aceitePolitica = aceitePolitica;
    this.interesses = interesses;
    this.ativo = ativo;
  }

  public static Membro construirNovoMembro(String email, String usuario,
                                           boolean aceitePolitica, List<String> interesses) {
    return new Membro(email, usuario, aceitePolitica, interesses, true);
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
    return this.id;
  }

  public List<String> getInteresses() {
    return interesses;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public void setAceitePolitica(boolean aceitePolitica) {
    this.aceitePolitica = aceitePolitica;
  }

  public void setInteresses(List<String> interesses) {
    this.interesses = interesses;
  }

}
