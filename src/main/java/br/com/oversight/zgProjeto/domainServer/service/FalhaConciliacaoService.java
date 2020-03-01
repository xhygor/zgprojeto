package br.com.oversight.zgProjeto.domainServer.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainServer.dto.FalhaConciliacaoDTO;
import br.com.oversight.zgProjeto.domainServer.entity.FalhaConciliacao;
import br.com.oversight.zgProjeto.domainServer.repository.FalhaConcilicaoRepository;

@Service
public class FalhaConciliacaoService {
	@Autowired
	private FalhaConcilicaoRepository rep;

	public Page<FalhaConciliacaoDTO> getFalhaConciliacao() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
		return new PageImpl<>(rep.findAll().stream().map(FalhaConciliacaoDTO::create).collect(Collectors.toList()),
				pageRequest, size);
	}

	public FalhaConciliacaoDTO getFalhaConciliacaoById(Long id) {
		Optional<FalhaConciliacao> falhaConciliacao = rep.findById(id);
		return falhaConciliacao.map(FalhaConciliacaoDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("FalhaConciliação não encontrato"));
	}
}
