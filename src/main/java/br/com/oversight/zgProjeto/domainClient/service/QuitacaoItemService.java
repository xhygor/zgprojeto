package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.QuitacaoItemDTO;
import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoItem;
import br.com.oversight.zgProjeto.domainClient.repository.QuitacaoItemRepository;

@Service
public class QuitacaoItemService {
	@Autowired
	private QuitacaoItemRepository rep;

	public List<QuitacaoItemDTO> getQuitacoesItem() {
		List<QuitacaoItemDTO> list = rep.findAll().stream().map(QuitacaoItemDTO::create).collect(Collectors.toList());
		return list;
	}

	public QuitacaoItemDTO getQuitacaoItemById(Long id) {
		Optional<QuitacaoItem> quitacaoGuia = rep.findById(id);
		return quitacaoGuia.map(QuitacaoItemDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("QuitacaoItem não encontrata"));
	}

}
