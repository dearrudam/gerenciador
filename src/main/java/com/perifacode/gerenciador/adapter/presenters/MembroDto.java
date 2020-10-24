package com.perifacode.gerenciador.adapter.presenters;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MembroDto {

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String usuario;

  private boolean aceitePolitica;

  public String getEmail() {
    return email;
  }

  public String getUsuario() {
    return usuario;
  }

  public boolean isAceitePolitica() {
    return aceitePolitica;
  }

  public MembroDto(
      @Email @NotBlank String email, @NotBlank String usuario, boolean aceitePolitica) {
    this.email = email;
    this.usuario = usuario;
    this.aceitePolitica = aceitePolitica;
  }
}
