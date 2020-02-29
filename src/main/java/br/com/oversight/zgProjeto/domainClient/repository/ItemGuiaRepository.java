package br.com.oversight.zgProjeto.domainClient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.ItemGuia;

public interface ItemGuiaRepository extends JpaRepository<ItemGuia, Long> {

	List<ItemGuia> findByGuia(int id);
}
