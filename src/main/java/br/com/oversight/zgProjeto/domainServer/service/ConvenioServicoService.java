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
import br.com.oversight.zgProjeto.domainServer.dto.ConvenioServicoDTO;
import br.com.oversight.zgProjeto.domainServer.entity.ConvenioServico;
import br.com.oversight.zgProjeto.domainServer.repository.ConvenioServicoRepository;

@Service
public class ConvenioServicoService {
	@Autowired
	private ConvenioServicoRepository rep;

	public Page<ConvenioServicoDTO> getConveniosServico() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
		return new PageImpl<>(rep.findAll().stream().map(ConvenioServicoDTO::create).collect(Collectors.toList()),
				pageRequest, size);
	}

	public ConvenioServicoDTO getConveniosServicoById(Long id) {
		Optional<ConvenioServico> convenioServico = rep.findById(id);
		return convenioServico.map(ConvenioServicoDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Beneficiario não encontrato"));
	}

}
