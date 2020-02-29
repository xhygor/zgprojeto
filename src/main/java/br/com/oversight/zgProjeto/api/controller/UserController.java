package br.com.oversight.zgProjeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainServer.dto.UsuarioDTO;
import br.com.oversight.zgProjeto.domainServer.entity.Usuario;
import br.com.oversight.zgProjeto.domainServer.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UsuarioService service;

	@GetMapping()
	public ResponseEntity get() {
		List<UsuarioDTO> list = service.getUsers();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/info")
	public UsuarioDTO userInfo(@AuthenticationPrincipal Usuario user) {
		return UsuarioDTO.create(user);
	}
}