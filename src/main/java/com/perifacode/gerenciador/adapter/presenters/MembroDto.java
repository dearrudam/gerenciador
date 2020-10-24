package com.perifacode.gerenciador.adapter.presenters;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MembroDto {

  private long id;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String usuario;

  private boolean aceitePolitica;

  private String getEmail() {
    return email;
  }

  private String getUsuario() {
    return usuario;
  }

  private boolean isAceitePolitica() {
    return aceitePolitica;
  }

  private LocalDate dataInclusao;

  private LocalDate dataAlteracao;

  private List<String> interesses;

  private boolean ativo;

}
