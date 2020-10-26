package com.perifacode.gerenciador.adapter.common;

import com.perifacode.gerenciador.adapter.presenters.TipoIniciativaDto;
import com.perifacode.gerenciador.entity.TipoIniciativa;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TipoIniciativaConverter extends Converter<TipoIniciativa, TipoIniciativaDto> {

  public TipoIniciativaConverter() {
    super(TipoIniciativaConverter::convertToDto, TipoIniciativaConverter::convertToEntity);
  }

  private static TipoIniciativaDto convertToDto(TipoIniciativa tipoIniciativa) {
    return new TipoIniciativaDto(tipoIniciativa.getId(), tipoIniciativa.getCodigo(),
        tipoIniciativa.getTitulo(), tipoIniciativa.getDescricao(), tipoIniciativa.getDataCadastro(),
        tipoIniciativa.getDataAtualizacao(),
        tipoIniciativa.isAtivo());
  }

  private static TipoIniciativa convertToEntity(TipoIniciativaDto tipoIniciativaDto) {
    return new TipoIniciativa(tipoIniciativaDto.getId(), tipoIniciativaDto.getCodigo(),
        tipoIniciativaDto.getTitulo(), tipoIniciativaDto.getDescricao(),
        tipoIniciativaDto.isAtivo());
  }

}
