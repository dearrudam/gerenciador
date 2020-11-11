package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.driver.repository.IniciativaRepository;
import com.perifacode.gerenciador.entity.Iniciativa;
import com.perifacode.gerenciador.usecase.excecao.IniciativaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IniciativaService {

  @Autowired
  private IniciativaRepository iniciativaRepository;

  public Iniciativa incluir(Iniciativa iniciativa) {
    iniciativaRepository
            .findByTituloAndAtivo(iniciativa.getTitulo(), true)
            .ifPresent((x) -> {
                throw new IniciativaExistenteException("Iniciativa existente!");
            });
    return iniciativaRepository.save(iniciativa);
  }
}
