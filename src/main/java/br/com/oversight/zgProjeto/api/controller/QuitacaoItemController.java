package br.com.oversight.zgProjeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.QuitacaoItemDTO;
import br.com.oversight.zgProjeto.domainClient.service.QuitacaoItemService;

@RestController
@RequestMapping("/api/v1/quitacoesitem")
public class QuitacaoItemController {

	@Autowired
	private QuitacaoItemService service;

	@GetMapping()
	public ResponseEntity get() {
		Page<QuitacaoItemDTO> quitacoesItem = service.getQuitacoesItem();
		return ResponseEntity.ok(quitacoesItem);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		QuitacaoItemDTO quitacaoItem = service.getQuitacaoItemById(id);

		return ResponseEntity.ok(quitacaoItem);
	}
}
