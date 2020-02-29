package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {

	private static final long serialVersionUID = 2331595781750620731L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;

	@NotBlank(message = "Informe o codigo.")
	@Length(min = 0, max = 255, message = "O limite do campo codigo é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String codigo;

	@NotBlank(message = "Informe o nome.")
	@Length(min = 0, max = 255, message = "O limite do campo nome é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String nome;

	@NotNull(message = "Informe o valor unitario.")
	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valorUnitario;

	public Produto() {
		this.version = 1;
	}
}
