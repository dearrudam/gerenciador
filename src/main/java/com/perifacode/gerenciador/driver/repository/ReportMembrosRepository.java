package com.perifacode.gerenciador.driver.repository;

import com.perifacode.gerenciador.adapter.presenters.MembroFiltro;
import com.perifacode.gerenciador.entity.Membro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ReportMembrosRepository {

  EntityManager em;

  public void createReport(MembroFiltro filtro){
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Membro> criteriaQuery = criteriaBuilder.createQuery(Membro.class);
    Root<Membro> root = criteriaQuery.from(Membro.class);

    List<Predicate> predicates = new ArrayList<Predicate>();
    ParameterExpression<LocalDate> param = criteriaBuilder.parameter(LocalDate.class, filtro.getDataCriacaoInicio().toString());
    predicates.add( criteriaBuilder.greaterThan(root.get("dataCadastro"), param)  );
    
  }

}
