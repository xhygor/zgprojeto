package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.QuitacaoGuiaDTO;
import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoGuia;
import br.com.oversight.zgProjeto.domainClient.repository.QuitacaoGuiaRepository;

@Service
public class QuitacaoGuiaService {
	@Autowired
	private QuitacaoGuiaRepository rep;

	public List<QuitacaoGuiaDTO> getQuitacoesGuia() {
		List<QuitacaoGuiaDTO> list = rep.findAll().stream().map(QuitacaoGuiaDTO::create).collect(Collectors.toList());
		return list;
	}

	public QuitacaoGuiaDTO getQuitacaoGuiaById(Long id) {
		Optional<QuitacaoGuia> quitacao = rep.findById(id);
		return quitacao.map(QuitacaoGuiaDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("QuitacaoGuia não encontrata"));
	}

}
