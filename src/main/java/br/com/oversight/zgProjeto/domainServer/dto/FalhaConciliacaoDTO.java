package br.com.oversight.zgProjeto.domainServer.dto;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainServer.entity.FalhaConciliacao;
import lombok.Data;

@Data
public class FalhaConciliacaoDTO {

	private Long id;

	public static FalhaConciliacaoDTO create(FalhaConciliacao falhaConciliacao) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(falhaConciliacao, FalhaConciliacaoDTO.class);
	}
}