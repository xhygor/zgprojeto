package br.com.oversight.zgProjeto.domainClient.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.oversight.zgProjeto.api.exception.ObjectNotFoundException;
import br.com.oversight.zgProjeto.domainClient.dto.ItemGuiaDTO;
import br.com.oversight.zgProjeto.domainClient.entity.ItemGuia;
import br.com.oversight.zgProjeto.domainClient.repository.ItemGuiaRepository;

@Service
public class ItemGuiaService {
	@Autowired
	private ItemGuiaRepository rep;
	
	public Page<ItemGuiaDTO> getItensGuia() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "matricula");
		return new PageImpl<>(rep.findAll().stream().map(ItemGuiaDTO::create).collect(Collectors.toList()), pageRequest,
				size);
	}

	public ItemGuiaDTO getItemGuiaById(Long id) {
		Optional<ItemGuia> beneficiario = rep.findById(id);
		return beneficiario.map(ItemGuiaDTO::create)
				.orElseThrow(() -> new ObjectNotFoundException("Item Guia não encontrato"));
	}

}
