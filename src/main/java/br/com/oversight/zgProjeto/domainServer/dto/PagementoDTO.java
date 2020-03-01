package br.com.oversight.zgProjeto.domainServer.dto;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("row")
public class PagementoDTO {

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
	private String valor_apresentado;
	private String valor_pago;
	private String valor_glosa;
	private String descricao_motivo;
	private String codigo_motivo;

}
