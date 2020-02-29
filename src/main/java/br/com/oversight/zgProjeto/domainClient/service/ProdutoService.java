package br.com.oversight.zgProjeto.domainClient.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.ProdutoDTO;
import br.com.oversight.zgProjeto.domainClient.entity.Produto;
import br.com.oversight.zgProjeto.domainClient.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository rep;
	
	public Page<ProdutoDTO> getProdutos() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(ProdutoDTO::create).collect(Collectors.toList()), pageRequest,
				size);
	}

	public ProdutoDTO getProdutoById(Long id) {
		Optional<Produto> produto = rep.findById(id);
		return produto.map(ProdutoDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrato"));
	}

}
