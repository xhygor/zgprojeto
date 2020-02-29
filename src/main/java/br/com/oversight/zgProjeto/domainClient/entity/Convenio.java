package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;

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
public class Convenio implements Serializable {

	private static final long serialVersionUID = -3001107941549986649L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;

	@NotBlank(message = "Informe a ans.")
	@Length(min = 0, max = 255, message = "O limite do campo ans é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String ans;

	@NotBlank(message = "Informe o nome.")
	@Length(min = 0, max = 255, message = "O limite do campo nome é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String nome;

	public Convenio() {
		this.version = 1;
	}
}
