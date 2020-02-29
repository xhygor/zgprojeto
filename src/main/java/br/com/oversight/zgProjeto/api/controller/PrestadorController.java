package br.com.oversight.zgProjeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.PrestadorDTO;
import br.com.oversight.zgProjeto.domainClient.dto.QuitacaoItemDTO;
import br.com.oversight.zgProjeto.domainClient.service.PrestadorService;

@RestController
@RequestMapping("/api/v1/prestadores")
public class PrestadorController {

	@Autowired
	private PrestadorService service;

	@GetMapping()
	public ResponseEntity get() {
		Page<PrestadorDTO> prestadores = service.getPrestadores();
		return ResponseEntity.ok(prestadores);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		PrestadorDTO prestador = service.getPrestadorById(id);

		return ResponseEntity.ok(prestador);
	}
}
