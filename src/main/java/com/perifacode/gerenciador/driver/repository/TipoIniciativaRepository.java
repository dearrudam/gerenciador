package com.perifacode.gerenciador.driver.repository;

import com.perifacode.gerenciador.entity.TipoIniciativa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIniciativaRepository extends JpaRepository<TipoIniciativa, Long> {

  Optional<TipoIniciativa> findByCodigo(String codigo);
}
