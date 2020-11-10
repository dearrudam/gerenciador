package com.perifacode.gerenciador.adapter.presenters;

import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.entity.TipoIniciativa;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class IniciativaDto {

    private long id;

    @NotBlank
    private String titulo;

    @NotNull
    private TipoIniciativa tipoIniciativa;

    @NotNull
    private List<Membro> responsaveis;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAlteracao;

    private boolean ativo;

}
