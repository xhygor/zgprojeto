package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.GuiaDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Guia;
import br.com.oversight.zgProjeto.domainClient.repository.GuiaRepository;

@Service
public class GuiaService {
	@Autowired
	private GuiaRepository rep;

	public List<GuiaDTO> getGuias() {
		List<GuiaDTO> list = rep.findAll().stream().map(GuiaDTO::create).collect(Collectors.toList());
		return list;
	}

	public GuiaDTO getGuiaById(Long id) {
		Optional<Guia> guia = rep.findById(id);
		return guia.map(GuiaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Guia não encontrato"));
	}

}
