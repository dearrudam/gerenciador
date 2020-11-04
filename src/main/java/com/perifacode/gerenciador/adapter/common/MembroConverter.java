package com.perifacode.gerenciador.adapter.common;

import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class MembroConverter extends Converter<MembroDto, Membro> {

  public MembroConverter() {
    super(MembroConverter::membroDtoToMembro, MembroConverter::membroToMembroDto);
  }

  public static Membro membroDtoToMembro(MembroDto memberDto) {
    return Membro.construirNovoMembro(memberDto.getEmail(),
        memberDto.getUsuario(), memberDto.isAceitePolitica(), memberDto.getInteresses());
  }

  public static MembroDto membroToMembroDto(Membro membro) {
    return new MembroDto(membro.getId(), membro.getEmail(), membro.getUsuario(),
        membro.isAceitePolitica(),
        membro.getDataCadastro(), membro.getDataAtualizacao(), membro.getInteresses(),
        membro.isAtivo());
  }
}
