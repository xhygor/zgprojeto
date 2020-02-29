package br.com.oversight.zgProjeto.domainClient.dto;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Convenio;
import lombok.Data;

@Data
public class ConvenioDTO {
    private Long id;
    private String nome;
	private String matricula;
	private String ans;

    public static ConvenioDTO create(Convenio convenio) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(convenio, ConvenioDTO.class);
    }
}