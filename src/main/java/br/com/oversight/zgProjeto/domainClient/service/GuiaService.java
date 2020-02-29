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
import br.com.oversight.zgProjeto.domainClient.dto.GuiaDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Guia;
import br.com.oversight.zgProjeto.domainClient.repository.GuiaRepository;

@Service
public class GuiaService {
	@Autowired
	private GuiaRepository rep;

	public Page<GuiaDTO> getGuias() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(GuiaDTO::create).collect(Collectors.toList()), pageRequest,
				size);
	}

	public GuiaDTO getGuiaById(Long id) {
		Optional<Guia> guia = rep.findById(id);
		return guia.map(GuiaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Guia não encontrato"));
	}

}
