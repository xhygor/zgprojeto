package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.Guia;

public interface GuiaRepository extends JpaRepository<Guia, Long> {

	Guia findByNumero(String numero);
}
