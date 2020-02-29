package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.BeneficiarioDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Beneficiario;
import br.com.oversight.zgProjeto.domainClient.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	@Autowired
	private BeneficiarioRepository rep;

	public List<BeneficiarioDTO> getBeneficiarios() {
		List<BeneficiarioDTO> list = rep.findAll().stream().map(BeneficiarioDTO::create).collect(Collectors.toList());
		return list;
	}

	public BeneficiarioDTO getBeneficiarioById(Long id) {
		Optional<Beneficiario> beneficiario = rep.findById(id);
		return beneficiario.map(BeneficiarioDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Beneficiario não encontrato"));
	}

}
