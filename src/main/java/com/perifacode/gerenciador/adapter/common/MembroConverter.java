package com.perifacode.gerenciador.adapter.common;

import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;

public class MembroConverter {

  public static Membro membroDtoToMembro(MembroDto memberDto) {
    return Membro.construirNovoMembro(memberDto.getEmail(),
        memberDto.getUsuario(), memberDto.isAceitePolitica(), memberDto.getInteresses());
  }

  public static MembroDto membroToMembroDto(Membro membro) {
    return new MembroDto(membro.getId(), membro.getEmail(), membro.getUsuario(),
        membro.isAceitePolitica(),
        membro.getDataInclusao(), membro.getDataAlteracao(), membro.getInteresses(),
        membro.isAtivo());
  }
}
