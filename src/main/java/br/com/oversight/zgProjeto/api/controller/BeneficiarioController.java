package br.com.oversight.zgProjeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oversight.zgProjeto.domainClient.dto.BeneficiarioDTO;
import br.com.oversight.zgProjeto.domainClient.service.BeneficiarioService;

@RestController
@RequestMapping("/api/v1/beneficiarios")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService service;

	@GetMapping()
	public ResponseEntity get() {
		Page<BeneficiarioDTO> beneficiarios = service.getBeneficiarios();
		return ResponseEntity.ok(beneficiarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		BeneficiarioDTO beneficiario = service.getBeneficiarioById(id);

		return ResponseEntity.ok(beneficiario);
	}
}
