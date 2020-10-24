package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.driver.repository.MembroRepository;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.excecao.MembroExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

  @Autowired
  MembroRepository membroRepository;

  public Membro incluir(Membro membro) {
    membroRepository
        .findByEmail(membro.getEmail())
        .ifPresent((x) -> {
          throw new MembroExistenteException();
        });

    return membroRepository.save(membro);
  }

  public Membro buscar(String email) {
      return membroRepository
            .findByEmail(email)
            .orElseThrow(MembroExistenteException::new);
  }
}
