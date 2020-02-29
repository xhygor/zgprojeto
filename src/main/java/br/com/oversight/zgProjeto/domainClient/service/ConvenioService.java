package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.ConvenioDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Convenio;
import br.com.oversight.zgProjeto.domainClient.repository.ConvenioRepository;

@Service
public class ConvenioService {
	@Autowired
	private ConvenioRepository rep;

	public List<ConvenioDTO> getConvenios() {
		List<ConvenioDTO> list = rep.findAll().stream().map(ConvenioDTO::create).collect(Collectors.toList());
		return list;
	}

	public ConvenioDTO getConvenioById(Long id) {
		Optional<Convenio> beneficiario = rep.findById(id);
		return beneficiario.map(ConvenioDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Convenio não encontrato"));
	}

}
