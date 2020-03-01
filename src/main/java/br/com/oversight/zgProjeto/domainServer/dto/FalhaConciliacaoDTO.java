package br.com.oversight.zgProjeto.domainServer.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.oversight.zgProjeto.domainServer.entity.FalhaConciliacao;
import br.com.oversight.zgProjeto.domainServer.service.PagamentoServicoService;
import lombok.Data;

@Data
public class FalhaConciliacaoDTO {

	@Autowired
	private static PagamentoServicoService pagamentoServicoService;

	private Long id;
	@SuppressWarnings("unused")
	private static PagamentoServicoDTO pagamentoServico;

	public static FalhaConciliacaoDTO create(FalhaConciliacao falhaConciliacao) {
		ModelMapper modelMapper = new ModelMapper();
		pagamentoServico = pagamentoServicoService
				.getPagamentoServicoByNgPrest(falhaConciliacao.getPagamento().getNg_prest());
		return modelMapper.map(falhaConciliacao, FalhaConciliacaoDTO.class);
	}
}