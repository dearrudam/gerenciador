package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.adapter.common.MembroConverter;
import com.perifacode.gerenciador.adapter.presenters.MembroDto;
import com.perifacode.gerenciador.driver.repository.MembroRepository;
import com.perifacode.gerenciador.entity.Membro;
import com.perifacode.gerenciador.usecase.excecao.MembroExistenteException;
import com.perifacode.gerenciador.usecase.excecao.MembroInexistenteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

  @Autowired
  private MembroRepository membroRepository;

  @Autowired
  private MembroConverter membroConverter;

  public MembroDto incluir(MembroDto membroDto) {
    Membro membro = membroConverter.convertFromDto(membroDto);
    membroRepository
        .findByEmailAndAtivo(membro.getEmail(), true)
        .ifPresent((x) -> {
          throw new MembroExistenteException("Não pode inserir Membro, email duplicado", "email");
        });
    return membroConverter.convertFromEntity(membroRepository.save(membro));
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

  public Page<MembroDto> buscarCriadosDepoisDe(LocalDate data, boolean isVoluntario,
                                               Pageable page) {
    if (isVoluntario) {
      return membroConverter.createPageFromEntities(membroRepository
          .findByIniciativasIsNotNullAndDataCadastroBetween(data.atStartOfDay(),
              LocalDateTime.now(), page));
    } else {
      return membroConverter.createPageFromEntities(membroRepository
          .findByIniciativasIsNullAndDataCadastroBetween(data.atStartOfDay(),
              LocalDateTime.now(),
              page));
    }
  }

  public Page<MembroDto> buscarCriadosEntre(LocalDate dataIni, LocalDate dataFim,
                                            boolean isVoluntario, Pageable page) {
    if (isVoluntario) {
      return membroConverter.createPageFromEntities(membroRepository
          .findByIniciativasIsNotNullAndDataCadastroBetween(dataIni.atStartOfDay(),
              dataFim.atTime(23, 59, 59), page));
    } else {
      return membroConverter.createPageFromEntities(membroRepository
          .findByIniciativasIsNullAndDataCadastroBetween(dataIni.atStartOfDay(),
              dataFim.atTime(23, 59, 59), page));
    }
  }

  public Page<MembroDto> buscarTodos(boolean isVoluntario, Pageable page) {
    if (isVoluntario) {
      return membroConverter
          .createPageFromEntities(membroRepository.findByIniciativasIsNotNull(page));
    } else {
      return membroConverter.createPageFromEntities(membroRepository.findByIniciativasIsNull(page));
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


}
