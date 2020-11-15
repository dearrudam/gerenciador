package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.driver.repository.MembroRepository;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.excecao.MembroExistenteException;
import com.perifacode.gerenciador.usecase.excecao.MembroInexistenteException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

  public MembroDto buscarMembroId(long id) {
    Optional<Membro> membroOptional = membroRepository.findById(id);
    if (membroOptional.isPresent()) {
      return membroConverter.convertFromEntity(membroOptional.get());
    } else {
      throw new MembroInexistenteException(String.format("Membro com id %s não existe", id));
    }
  }

  public List<Membro> buscarTodos(boolean filtroVoluntario) {
    List<Membro> membros = membroRepository.findAll();
    if (filtroVoluntario) {
      return membros.stream().filter(membro -> !membro.getIniciativas().isEmpty()).collect(
          Collectors.toList());
    }

    return membros;
  }
}
