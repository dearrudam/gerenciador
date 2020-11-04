package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.driver.repository.MembroRepository;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.excecao.MembroExistenteException;
import com.perifacode.gerenciador.usecase.excecao.MembroInexistenteException;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

  @Autowired
  private MembroRepository membroRepository;

  @Autowired
  private MembroConverter membroConverter;

  public Membro incluir(Membro membro) {
    membroRepository
        .findByEmailAndAtivo(membro.getEmail(), true)
        .ifPresent((x) -> {
          throw new MembroExistenteException("Não pode inserir Membro, email duplicado", "email");
        });
    return membroRepository.save(membro);
  }

  public Membro buscar(String email) {
    Optional<Membro> byEmailAndAtivo = membroRepository
        .findByEmailAndAtivo(email, true);
    if (byEmailAndAtivo.isPresent()) {
      return byEmailAndAtivo.get();
    } else {
      throw new MembroInexistenteException(String.format("membro email %s não encontrado", email));
    }
  }

  public MembroDto atualizar(Long membroId, MembroDto membro) {
    Optional<Membro> optionalMembro = membroRepository.findByIdAndAtivo(membroId, true);
    if (optionalMembro.isEmpty()) {
      throw new MembroInexistenteException(String.format("membro id %s não encontrado", membroId));
    } else {
      Membro target = optionalMembro.get();
      if (target.getId() != membro.getId()) {
        throw new DataIntegrityViolationException("Id de referencia modelo invalida.");
      }
      BeanUtils.copyProperties(membro, target);
      target = membroRepository.save(target);
      return membroConverter.convertFromEntity(target);
    }
  }

  public Boolean inativaMembro(Long membroId) {
    Optional<Membro> optionalMembro = membroRepository.findByIdAndAtivo(membroId, true);
    if (optionalMembro.isEmpty()) {
      throw new MembroInexistenteException(String.format("membro id %s não encontrado", membroId));
    } else {
      Membro target = optionalMembro.get();
      target.setAtivo(false);
      membroRepository.save(target);
      return true;
    }
  }

}
