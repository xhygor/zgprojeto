package br.com.oversight.zgProjeto.domainClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainClient.entity.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

	Beneficiario findByMatricula(String matricula);
}
