package br.com.oversight.zgProjeto.domainClient.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {
	private Long id;
	private String nome;
	private String codigo;
	private BigDecimal valorUnitario;

	public static ProdutoDTO create(Produto produto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(produto, ProdutoDTO.class);
	}
}