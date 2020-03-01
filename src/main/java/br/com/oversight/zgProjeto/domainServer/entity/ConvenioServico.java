package br.com.oversight.zgProjeto.domainServer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
public class ConvenioServico implements Serializable {

	private static final long serialVersionUID = -3001107941549986649L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o idConvenio.")
	@Column(precision = 10, scale = 0, nullable = false)
	private Integer idConvenio;

	@NotBlank(message = "Informe a url.")
	@Length(min = 0, max = 255, message = "O limite do campo url é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String url;

	@NotNull(message = "Informe a periodicidade")
	@ManyToOne
	private Periodicidade periodicidade;

	public ConvenioServico() {
		this.periodicidade = new Periodicidade();
	}
}
