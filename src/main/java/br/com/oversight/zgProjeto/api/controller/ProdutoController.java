package br.com.oversight.zgProjeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.ProdutoDTO;
import br.com.oversight.zgProjeto.domainClient.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping()
	public ResponseEntity get() {
		Page<ProdutoDTO> produtos = service.getProdutos();
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		ProdutoDTO produto = service.getProdutoById(id);

		return ResponseEntity.ok(produto);
	}
}
