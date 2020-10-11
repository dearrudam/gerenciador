package com.perifacode.gerenciador.adapter.common;

import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.entity.Membro;

public class MembroConverter {

  public static Membro membroDtoToMembro(MembroDto memberDto){
    return Membro.construirMembro(memberDto.getEmail(),
        memberDto.getUsuario(), memberDto.isAceitePolitica());
  }

  public static MembroDto membroToMembroDto(Membro membro) {
    return new MembroDto(membro.getEmail(), membro.getUsuario(), membro.isAceitePolitica());
  }
}
