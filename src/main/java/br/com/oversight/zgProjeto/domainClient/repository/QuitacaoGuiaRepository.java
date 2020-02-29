package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoGuia;

public interface QuitacaoGuiaRepository extends JpaRepository<QuitacaoGuia, Long> {

	QuitacaoGuia findByGuia(int id);
}
