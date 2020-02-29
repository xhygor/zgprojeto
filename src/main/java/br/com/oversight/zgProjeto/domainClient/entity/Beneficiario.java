package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;
import java.util.UUID;

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
public class Beneficiario implements Serializable {

	private static final long serialVersionUID = 8801423541629796788L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;

	@NotBlank(message = "Informe a matricula.")
	@Length(min = 0, max = 255, message = "O limite do campo matricula é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String matricula;

	@NotBlank(message = "Informe o nome.")
	@Length(min = 0, max = 255, message = "O limite do campo nome é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String nome;

	public Beneficiario() {
		this.version = 1;
		this.matricula = UUID.randomUUID().toString();
	}
}
