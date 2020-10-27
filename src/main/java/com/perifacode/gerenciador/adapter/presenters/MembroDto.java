package com.perifacode.gerenciador.adapter.presenters;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

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

  private LocalDateTime dataInclusao;

  private LocalDateTime dataAlteracao;

  private List<String> interesses;

  private boolean ativo;

}
