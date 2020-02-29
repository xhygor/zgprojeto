package br.com.oversight.zgProjeto.domainClient.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class QuitacaoGuia implements Serializable {

	private static final long serialVersionUID = -497051458758756792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe o version.")
	@Column(precision = 19, scale = 0, nullable = false)
	private Integer version;
	
    @OneToOne
    @NotNull(message = "Informe a Guia.")
    private Guia guia;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;

	@NotNull(message = "Informe o valor pago.")
	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal valorPago;

	public QuitacaoGuia() {
		this.version = 1;
	}
}
