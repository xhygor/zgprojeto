package br.com.oversight.zgProjeto.domainServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainServer.entity.ConvenioServico;

public interface ConvenioServicoRepository extends JpaRepository<ConvenioServico, Long> {

	ConvenioServico findByIdConvenio(Integer integer);
}
