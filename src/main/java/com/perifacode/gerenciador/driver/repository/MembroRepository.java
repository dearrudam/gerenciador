package com.perifacode.gerenciador.driver.repository;

import com.perifacode.gerenciador.entity.Membro;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

  Optional<Membro> findByEmailAndAtivo(String email, boolean ativo);

  Optional<Membro> findByIdAndAtivo(Long membroId, boolean ativo);

  Page<Membro> findByIniciativasIsNotNull(Pageable pageable);

  Page<Membro> findByIniciativasIsNull(Pageable pageable);

  Page<Membro> findByIniciativasIsNullAndDataCadastroBetween(LocalDateTime dataCadastroIni,
                                         LocalDateTime dataCadastroFim,
                                         Pageable pageable);

  Page<Membro> findByIniciativasIsNotNullAndDataCadastroBetween(LocalDateTime dataCadastroIni,
                                                                LocalDateTime dataCadastroFim,
                                                                Pageable pageable);


}
