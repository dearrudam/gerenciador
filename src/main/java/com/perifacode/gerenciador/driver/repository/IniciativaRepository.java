package com.perifacode.gerenciador.driver.repository;

import com.perifacode.gerenciador.entity.Iniciativa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;



@Repository
public interface IniciativaRepository extends JpaRepository<Iniciativa, Long> {

  Optional<Iniciativa> findByTituloAndAtivo(String titulo, boolean ativo);

  Optional<Iniciativa> findByIdAndAtivo(Long id, boolean ativo);
}
