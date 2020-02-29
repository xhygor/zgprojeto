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
import br.com.oversight.zgProjeto.domainClient.dto.QuitacaoItemDTO;
import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoItem;
import br.com.oversight.zgProjeto.domainClient.repository.QuitacaoItemRepository;

@Service
public class QuitacaoItemService {
	@Autowired
	private QuitacaoItemRepository rep;

	public Page<QuitacaoItemDTO> getQuitacoesItem() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(QuitacaoItemDTO::create).collect(Collectors.toList()),
				pageRequest, size);
	}

	public QuitacaoItemDTO getQuitacaoItemById(Long id) {
		Optional<QuitacaoItem> quitacaoGuia = rep.findById(id);
		return quitacaoGuia.map(QuitacaoItemDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("QuitacaoItem não encontrata"));
	}

}
