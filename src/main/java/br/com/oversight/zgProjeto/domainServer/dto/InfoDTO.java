package br.com.oversight.zgProjeto.domainServer.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoDTO {

	private List<PagementoDTO> row = new ArrayList<>();

}
