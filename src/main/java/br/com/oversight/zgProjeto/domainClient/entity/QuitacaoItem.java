package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
public class QuitacaoItem implements Serializable{
	
	private static final long serialVersionUID = 8941454321411149289L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;

	@NotBlank(message = "Informe o motivo da glosa.")
	@Length(min = 0, max = 255, message = "O limite do campo motivoGlosa é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String motivoGlosaDescricao;

	@NotBlank(message = "Informe o codigo do motivo da glosa.")
	@Length(min = 0, max = 255, message = "O limite do campo motivoGlosaCodigo é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String motivoGlosaCodigo;

	@NotNull(message = "Informe o valor.")
	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@OneToOne
    @NotNull(message = "Informe o item guia.")
	private ItemGuia itemGuia;

	public QuitacaoItem() {
		this.version = 1;
	}
}
