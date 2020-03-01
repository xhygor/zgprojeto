package br.com.oversight.zgProjeto.domainServer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainServer.entity.PagementoServico;

public interface PagamentoServicoRepository extends JpaRepository<PagementoServico, Long> {

}
