package com.perifacode.gerenciador.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Membro {

  @Id
  private String email;

  private String usuario;

  private boolean aceitePolitica;

  public Membro() {
  }

  private Membro(@Email @NotBlank String email,
                 @NotBlank String usuario,
                 boolean aceitePolitica) {
    this.email = email;
    this.usuario = usuario;
    this.aceitePolitica = aceitePolitica;
  }

  public static Membro construirMembro(String email,
                                       String usuario,
                                       boolean aceitePolitica) {
    return new Membro(email, usuario, aceitePolitica);
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
}
