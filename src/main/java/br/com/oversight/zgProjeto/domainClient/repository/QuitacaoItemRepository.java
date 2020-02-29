package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoItem;

public interface QuitacaoItemRepository extends JpaRepository<QuitacaoItem, Long> {

	QuitacaoItem findByItemGuia(int id);
}
