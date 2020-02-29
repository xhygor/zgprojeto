package br.com.oversight.zgProjeto.domainClient.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Guia;
import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoGuia;
import lombok.Data;

@Data
public class QuitacaoGuiaDTO {
	private Long id;
	private Date dataPagamento;
	private BigDecimal valorPago;
	private Guia guia;

	public static QuitacaoGuiaDTO create(QuitacaoGuia quitacaoGuia) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(quitacaoGuia, QuitacaoGuiaDTO.class);
	}
}