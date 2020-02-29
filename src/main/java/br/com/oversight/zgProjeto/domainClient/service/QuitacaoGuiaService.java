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
import br.com.oversight.zgProjeto.domainClient.dto.QuitacaoGuiaDTO;
import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoGuia;
import br.com.oversight.zgProjeto.domainClient.repository.QuitacaoGuiaRepository;

@Service
public class QuitacaoGuiaService {
	@Autowired
	private QuitacaoGuiaRepository rep;
	
	public Page<QuitacaoGuiaDTO> getQuitacoesGuia() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(QuitacaoGuiaDTO::create).collect(Collectors.toList()), pageRequest,
				size);
	}

	public QuitacaoGuiaDTO getQuitacaoGuiaById(Long id) {
		Optional<QuitacaoGuia> quitacao = rep.findById(id);
		return quitacao.map(QuitacaoGuiaDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("QuitacaoGuia não encontrata"));
	}

}
