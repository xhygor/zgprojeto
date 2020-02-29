package br.com.oversight.zgProjeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.ItemGuiaDTO;
import br.com.oversight.zgProjeto.domainClient.service.ItemGuiaService;

@RestController
@RequestMapping("/api/v1/itensGuia")
public class ItemGuiaController {

	@Autowired
	private ItemGuiaService service;

	@GetMapping()
	public ResponseEntity get() {
		Page<ItemGuiaDTO> itensGuia = service.getItensGuia();
		return ResponseEntity.ok(itensGuia);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		ItemGuiaDTO itemGuia = service.getItemGuiaById(id);

		return ResponseEntity.ok(itemGuia);
	}
}
