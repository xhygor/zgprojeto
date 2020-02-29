package br.com.oversight.zgProjeto.domainClient.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Beneficiario;
import br.com.oversight.zgProjeto.domainClient.entity.Convenio;
import br.com.oversight.zgProjeto.domainClient.entity.Guia;
import br.com.oversight.zgProjeto.domainClient.entity.Prestador;
import lombok.Data;

@Data
public class GuiaDTO {
    private Long id;
	private String numero;
	private BigDecimal valorTotal;
	private Date data;
	private Prestador prestador;
	private Convenio convenio;
	private Beneficiario beneficiario;
	
    public static GuiaDTO create(Guia guia) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(guia, GuiaDTO.class);
    }
}