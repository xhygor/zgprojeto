package br.com.oversight.zgProjeto.domainClient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.ItemGuiaDTO;
import br.com.oversight.zgProjeto.domainClient.entity.ItemGuia;
import br.com.oversight.zgProjeto.domainClient.repository.ItemGuiaRepository;

@Service
public class ItemGuiaService {
	@Autowired
	private ItemGuiaRepository rep;

	public List<ItemGuiaDTO> getItensGuia() {
		List<ItemGuiaDTO> list = rep.findAll().stream().map(ItemGuiaDTO::create).collect(Collectors.toList());
		return list;
	}

	public ItemGuiaDTO getItemGuiaById(Long id) {
		Optional<ItemGuia> beneficiario = rep.findById(id);
		return beneficiario.map(ItemGuiaDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Item Guia não encontrato"));
	}

}
