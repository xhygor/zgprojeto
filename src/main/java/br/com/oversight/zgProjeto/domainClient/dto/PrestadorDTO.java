package br.com.oversight.zgProjeto.domainClient.dto;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Prestador;
import lombok.Data;

@Data
public class PrestadorDTO {
    private Long id;
    private String nome;
	private String cnpj;

	public static PrestadorDTO create(Prestador prestador) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(prestador, PrestadorDTO.class);
    }
}