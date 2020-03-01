package br.com.oversight.zgProjeto.domainServer.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainServer.entity.PagementoServico;
import lombok.Data;

@Data
public class PagamentoServicoDTO {
	private Long id;
	private String convenio;
	private Date data_pagamento;
	private String numero_protocolo;
	private String matricula;
	private String nome;
	private String numero_guia;
	private String ng_prest;
	private String senha_guia;
	private String codigo_produto;
	private String descricao_produto;
	private BigDecimal valor_apresentado;
	private BigDecimal valor_pago;
	private BigDecimal valor_glosa;
	private String descricao_motivo;

	private String codigo_motivo;

	public static PagamentoServicoDTO create(PagementoServico pagamentoServico) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(pagamentoServico, PagamentoServicoDTO.class);
	}
}