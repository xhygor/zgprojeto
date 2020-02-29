package br.com.oversight.zgProjeto.domainClient.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.ItemGuia;
import br.com.oversight.zgProjeto.domainClient.entity.QuitacaoItem;
import lombok.Data;

@Data
public class QuitacaoItemDTO {
	private Long id;
	private String motivoGlosaDescricao;
	private String motivoGlosaCodigo;
	private BigDecimal valor;
	private ItemGuia itemGuia;

    public static QuitacaoItemDTO create(QuitacaoItem guia) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(guia, QuitacaoItemDTO.class);
    }
}