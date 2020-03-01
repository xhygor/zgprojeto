package br.com.oversight.zgProjeto.domainServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainServer.entity.Periodicidade;

public interface PeriodicidadeRepository extends JpaRepository<Periodicidade, Long> {

}
