package br.com.oversight.zgProjeto.domainServer.dto;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainServer.entity.ConvenioServico;
import br.com.oversight.zgProjeto.domainServer.entity.Periodicidade;
import lombok.Data;

@Data
public class ConvenioServicoDTO {

	private Long id;
	private String url;
	private Periodicidade periodicidade;
	
	public static ConvenioServicoDTO create(ConvenioServico convenioServico) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(convenioServico, ConvenioServicoDTO.class);
	}
}