package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {

	Convenio findByAns(String ans);
}
