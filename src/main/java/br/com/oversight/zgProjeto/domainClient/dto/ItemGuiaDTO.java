package br.com.oversight.zgProjeto.domainClient.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Guia;
import br.com.oversight.zgProjeto.domainClient.entity.ItemGuia;
import br.com.oversight.zgProjeto.domainClient.entity.Produto;
import lombok.Data;

@Data
public class ItemGuiaDTO {
	private Long id;
	private Integer quantidade;
	private String numero;
	private BigDecimal valorTotal;
	private Guia guia;
	private Produto produto;

	public static ItemGuiaDTO create(ItemGuia itemGuia) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(itemGuia, ItemGuiaDTO.class);
	}
}