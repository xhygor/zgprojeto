package br.com.oversight.zgProjeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.ConvenioDTO;
import br.com.oversight.zgProjeto.domainClient.service.ConvenioService;

@RestController
@RequestMapping("/api/v1/convenios")
public class ConvenioController {

	@Autowired
	private ConvenioService service;

	@GetMapping()
	public ResponseEntity get() {
		List<ConvenioDTO> convenios = null;
		return ResponseEntity.ok(convenios);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		ConvenioDTO convenios = service.getConvenioById(id);
		return ResponseEntity.ok(convenios);
	}
}
