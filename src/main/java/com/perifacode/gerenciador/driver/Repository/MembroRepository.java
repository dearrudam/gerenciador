package com.perifacode.gerenciador.driver.Repository;

import com.perifacode.gerenciador.entity.Membro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, String> {
  Optional<Membro> findByEmail(String email);
}
