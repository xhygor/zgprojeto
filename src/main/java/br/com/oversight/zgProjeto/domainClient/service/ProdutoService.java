package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.ProdutoDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Produto;
import br.com.oversight.zgProjeto.domainClient.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository rep;

	public List<ProdutoDTO> getProduto() {
		List<ProdutoDTO> list = rep.findAll().stream().map(ProdutoDTO::create).collect(Collectors.toList());
		return list;
	}

	public ProdutoDTO getProdutoById(Long id) {
		Optional<Produto> produto = rep.findById(id);
		return produto.map(ProdutoDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrato"));
	}

}
