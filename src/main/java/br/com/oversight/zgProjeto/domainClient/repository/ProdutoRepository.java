package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findByCodigo(String codigo);
}
