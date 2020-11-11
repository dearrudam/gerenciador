package com.perifacode.gerenciador.adapter.common;

import com.perifacode.gerenciador.adapter.presenters.IniciativaDto;
import com.perifacode.gerenciador.entity.Iniciativa;
import org.springframework.stereotype.Component;

@Component
public class IniciativaConverter extends Converter<IniciativaDto, Iniciativa> {

  public IniciativaConverter() {
    super(IniciativaConverter::iniciativaDtoToIniciativa,
            IniciativaConverter::iniciativaToIniciativaDto);
  }

  public static Iniciativa iniciativaDtoToIniciativa(IniciativaDto iniciativaDto) {
    return Iniciativa.construirNovaIniciativa(iniciativaDto.getTitulo(),
        iniciativaDto.getTipoIniciativa(), iniciativaDto.getResponsaveis());
  }

  public static IniciativaDto iniciativaToIniciativaDto(Iniciativa iniciativa) {
    return new IniciativaDto(iniciativa.getId(), iniciativa.getTitulo(),
        iniciativa.getTipoIniciativa(), iniciativa.getResponsaveis(),
        iniciativa.getDataCadastro(), iniciativa.getDataAtualizacao(),
        iniciativa.isAtivo());
  }
}
