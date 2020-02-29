package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.PrestadorDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Prestador;
import br.com.oversight.zgProjeto.domainClient.repository.PrestadorRepository;

@Service
public class PrestadorService {
	@Autowired
	private PrestadorRepository rep;

	public List<PrestadorDTO> getPrestadores() {
		List<PrestadorDTO> list = rep.findAll().stream().map(PrestadorDTO::create).collect(Collectors.toList());
		return list;
	}

	public PrestadorDTO getPrestadorById(Long id) {
		Optional<Prestador> prestador = rep.findById(id);
		return prestador.map(PrestadorDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Prestador não encontrato"));
	}

}
