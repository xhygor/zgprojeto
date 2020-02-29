package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class ItemGuia implements Serializable {

	private static final long serialVersionUID = 5806007151069324456L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;

	@NotNull(message = "Informe a quantidade.")
	@Column(precision = 10, scale = 0, nullable = false)
	private Integer quantidade;

	@NotBlank(message = "Informe o numero.")
	@Length(min = 0, max = 255, message = "O limite do campo numero é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String numero;

	@NotNull(message = "Informe o valor total.")
	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valorTotal;

	@ManyToOne
	private Guia guia;

	@ManyToOne
	private Produto produto;
}
