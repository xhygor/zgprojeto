package br.com.oversight.zgProjeto.domainClient.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.BeneficiarioDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Beneficiario;
import br.com.oversight.zgProjeto.domainClient.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	@Autowired
	private BeneficiarioRepository rep;

	public Page<BeneficiarioDTO> getBeneficiarios() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(BeneficiarioDTO::create).collect(Collectors.toList()),
				pageRequest, size);
	}

	public BeneficiarioDTO getBeneficiarioById(Long id) {
		Optional<Beneficiario> beneficiario = rep.findById(id);
		return beneficiario.map(BeneficiarioDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Beneficiario não encontrato"));
	}

}
