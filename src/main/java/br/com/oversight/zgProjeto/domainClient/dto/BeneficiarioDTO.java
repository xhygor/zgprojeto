package br.com.oversight.zgProjeto.domainClient.dto;

import org.modelmapper.ModelMapper;

import br.com.oversight.zgProjeto.domainClient.entity.Beneficiario;
import lombok.Data;

@Data
public class BeneficiarioDTO {
    private Long id;
    private String nome;
	private String matricula;

    public static BeneficiarioDTO create(Beneficiario beneficiario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(beneficiario, BeneficiarioDTO.class);
    }
}