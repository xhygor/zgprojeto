package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
public class Guia implements Serializable {

	private static final long serialVersionUID = -3894097418161574280L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;

	@NotBlank(message = "Informe o numero.")
	@Length(min = 0, max = 255, message = "O limite do campo numero é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String numero;

	@NotNull(message = "Informe o valor total.")
	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valorTotal;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	private Prestador prestador;
	
	@ManyToOne
	private Convenio convenio;
	
	@ManyToOne
	private Beneficiario beneficiario;
}
