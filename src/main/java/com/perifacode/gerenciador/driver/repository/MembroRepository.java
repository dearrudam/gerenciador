package com.perifacode.gerenciador.driver.repository;

import com.perifacode.gerenciador.entity.Membro;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

  Optional<Membro> findByEmailAndAtivo(String email,boolean ativo);

  Optional<Membro> findByIdAndAtivo(Long membroId,boolean ativo);


}
