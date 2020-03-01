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
import br.com.oversight.zgProjeto.domainServer.dto.PagamentoServicoDTO;
import br.com.oversight.zgProjeto.domainServer.entity.PagementoServico;
import br.com.oversight.zgProjeto.domainServer.repository.PagamentoServicoRepository;

@Service
public class PagamentoServicoService {
	@Autowired
	private PagamentoServicoRepository rep;

	public Page<PagamentoServicoDTO> getPagamentoServico() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
		return new PageImpl<>(rep.findAll().stream().map(PagamentoServicoDTO::create).collect(Collectors.toList()),
				pageRequest, size);
	}

	public PagamentoServicoDTO getPagamentoServicoById(Long id) {
		Optional<PagementoServico> pagamentoServico = rep.findById(id);
		return pagamentoServico.map(PagamentoServicoDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Pagamento Servico não encontrato"));
	}

	public PagamentoServicoDTO getPagamentoServicoByNgPrest(String ngPrest) {
		Optional<PagementoServico> pagamentoServico = rep.findByNg_prest(ngPrest);
		return pagamentoServico.map(PagamentoServicoDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Pagamento Servico não encontrato"));
	}

}
