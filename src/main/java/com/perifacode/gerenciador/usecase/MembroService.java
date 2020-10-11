package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.driver.Repository.MembroRepository;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.excecao.MembroExistenteException;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

  @Autowired
  MembroRepository membroRepository;

  public Membro incluir(Membro membro) {
    membroRepository
        .findByEmail()
        .ifPresent((x) -> {
          throw new MembroExistenteException();
        });

    return membroRepository.save(membro);
  }
}
