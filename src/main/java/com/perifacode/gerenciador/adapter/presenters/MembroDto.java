package com.perifacode.gerenciador.adapter.presenters;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class MembroDto {

  private long id;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String usuario;

  private boolean aceitePolitica;

  private LocalDate dataInclusao;

  private LocalDate dataAlteracao;

  private List<String> interesses;

  private boolean ativo;

}
