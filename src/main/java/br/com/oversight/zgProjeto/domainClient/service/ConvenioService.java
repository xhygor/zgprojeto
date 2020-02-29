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
import br.com.oversight.zgProjeto.domainClient.dto.ConvenioDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Convenio;
import br.com.oversight.zgProjeto.domainClient.repository.ConvenioRepository;

@Service
public class ConvenioService {
	@Autowired
	private ConvenioRepository rep;

	public Page<ConvenioDTO> getConvenios() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(ConvenioDTO::create).collect(Collectors.toList()), pageRequest,
				size);
	}

	public ConvenioDTO getConvenioById(Long id) {
		Optional<Convenio> beneficiario = rep.findById(id);
		return beneficiario.map(ConvenioDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Convenio não encontrato"));
	}

}
