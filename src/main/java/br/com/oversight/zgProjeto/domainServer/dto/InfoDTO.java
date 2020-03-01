package br.com.oversight.zgProjeto.domainServer.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.oversight.zgProjeto.domainServer.entity.PagementoServico;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoDTO {

	private List<PagementoServico> row = new ArrayList<>();

}
