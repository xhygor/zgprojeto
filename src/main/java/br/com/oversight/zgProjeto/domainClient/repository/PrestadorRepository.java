package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.Prestador;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

	Prestador findByCnpj(String cnpj);
}
