package com.perifacode.gerenciador.usecase;

import com.perifacode.gerenciador.adapter.common.TipoIniciativaConverter;
import com.perifacode.gerenciador.adapter.presenters.TipoIniciativaDto;
import com.perifacode.gerenciador.driver.repository.TipoIniciativaRepository;
import com.perifacode.gerenciador.entity.TipoIniciativa;
import com.perifacode.gerenciador.usecase.excecao.Resultado;
import com.perifacode.gerenciador.usecase.excecao.TipoIniciativaException;
import java.util.Optional;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TipoIniciativaService {

  @Autowired
  private TipoIniciativaRepository tipoIniciativaRepository;

  @Autowired
  private TipoIniciativaConverter converter;

  public TipoIniciativaDto novaIniciativa(TipoIniciativaDto tipoIniciativa) {
    return converter.convertFromEntity(
        tipoIniciativaRepository.save(
            converter.convertFromDto(tipoIniciativa)));
  }

  public Resultado<TipoIniciativaDto,RuntimeException> findByCodigo(String codTipoIniciativa) {
    Optional<TipoIniciativa> byCodigo = tipoIniciativaRepository.findByCodigo(codTipoIniciativa);
    if (byCodigo.isPresent()) {
      return   new Resultado().sucesso(converter.convertFromEntity(byCodigo.get()));
    } else {
      return  new Resultado().falha(new TipoIniciativaException("Não encontrado"));
    }
  }

  public Resultado<Page<TipoIniciativaDto>, RuntimeException> findAll(Pageable pageable) {
    Page<TipoIniciativa> pagina = tipoIniciativaRepository.findAll(pageable);
    if (!pagina.isEmpty()) {
      return new Resultado().sucesso(converter.createPageFromEntities(pagina));
    } else {
      return new Resultado().falha(new TipoIniciativaException("Não encontrado"));
    }
  }
}
