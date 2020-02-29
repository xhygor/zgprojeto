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
import br.com.oversight.zgProjeto.domainClient.dto.PrestadorDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Prestador;
import br.com.oversight.zgProjeto.domainClient.repository.PrestadorRepository;

@Service
public class PrestadorService {
	@Autowired
	private PrestadorRepository rep;

	public Page<PrestadorDTO> getPrestadores() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(PrestadorDTO::create).collect(Collectors.toList()),
				pageRequest, size);
	}

	public PrestadorDTO getPrestadorById(Long id) {
		Optional<Prestador> prestador = rep.findById(id);
		return prestador.map(PrestadorDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Prestador não encontrato"));
	}

}
