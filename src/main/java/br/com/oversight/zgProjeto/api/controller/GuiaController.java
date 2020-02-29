package br.com.oversight.zgProjeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.GuiaDTO;
import br.com.oversight.zgProjeto.domainClient.service.GuiaService;

@RestController
@RequestMapping("/api/v1/guias")
public class GuiaController {

	@Autowired
	private GuiaService service;

	@GetMapping()
	public ResponseEntity get() {
		Page<GuiaDTO> guias = service.getGuias();
		return ResponseEntity.ok(guias);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		GuiaDTO guia = service.getGuiaById(id);

		return ResponseEntity.ok(guia);
	}
}
