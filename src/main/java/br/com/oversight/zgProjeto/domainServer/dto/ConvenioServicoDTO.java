package br.com.oversight.zgProjeto.domainServer.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.oversight.zgProjeto.domainClient.dto.ConvenioDTO;
import br.com.oversight.zgProjeto.domainClient.service.ConvenioService;
import br.com.oversight.zgProjeto.domainServer.entity.ConvenioServico;
import br.com.oversight.zgProjeto.domainServer.entity.Periodicidade;
import lombok.Data;

@Data
public class ConvenioServicoDTO {
	@Autowired
	private static ConvenioService convenioService;

	private Long id;
	private String url;
	private Periodicidade periodicidade;
	@SuppressWarnings("unused")
	private static ConvenioDTO convenio;

	public static ConvenioServicoDTO create(ConvenioServico convenioServico) {
		ModelMapper modelMapper = new ModelMapper();
		convenio = convenioService.getConvenioById(convenioServico.getIdConvenio());
		return modelMapper.map(convenioServico, ConvenioServicoDTO.class);
	}
}