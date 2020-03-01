package br.com.oversight.zgProjeto.domainServer.entity;

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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Periodicidade implements Serializable {

	private static final long serialVersionUID = 8801423541629796788L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Informe a descricao.")
	@Length(min = 0, max = 255, message = "O limite do campo descricao é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String descricao;
}
