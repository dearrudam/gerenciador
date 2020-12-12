package com.perifacode.gerenciador.adapter.common;

import com.perifacode.gerenciador.adapter.presenters.TipoIniciativaDto;
import com.perifacode.gerenciador.entity.TipoIniciativa;
import org.springframework.stereotype.Component;

@Component
public class TipoIniciativaConverter extends Converter<TipoIniciativaDto, TipoIniciativa> {

  public TipoIniciativaConverter() {
    super(TipoIniciativaConverter::fromDto, TipoIniciativaConverter::fromEntity);
  }

  private static TipoIniciativaDto fromEntity(TipoIniciativa tipoIniciativa) {
    return new TipoIniciativaDto(tipoIniciativa.getId(), tipoIniciativa.getCodigo(),
        tipoIniciativa.getTitulo(), tipoIniciativa.getDescricao(), tipoIniciativa.getDataCadastro(),
        tipoIniciativa.getDataAtualizacao(),
        tipoIniciativa.isAtivo());
  }

  private static TipoIniciativa fromDto(TipoIniciativaDto tipoIniciativaDto) {
    return new TipoIniciativa(tipoIniciativaDto.getId(), tipoIniciativaDto.getCodigo(),
        tipoIniciativaDto.getTitulo(), tipoIniciativaDto.getDescricao(),
        tipoIniciativaDto.isAtivo());
  }

}
