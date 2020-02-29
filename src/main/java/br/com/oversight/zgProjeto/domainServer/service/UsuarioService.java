package br.com.oversight.zgProjeto.domainServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.domainServer.dto.UsuarioDTO;
import br.com.oversight.zgProjeto.domainServer.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;

	public List<UsuarioDTO> getUsers() {
		return rep.findAll().stream().map(UsuarioDTO::create).collect(Collectors.toList());
	}
}
