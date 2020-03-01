package br.com.oversight.zgProjeto.domainServer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("row")
@Entity
public class PagementoServico implements Serializable {

	private static final long serialVersionUID = -1822399381797727105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valor_apresentado;

	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valor_pago;

	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valor_glosa;

	private String descricao_motivo;

	private String codigo_motivo;

}
