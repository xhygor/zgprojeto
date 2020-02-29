package br.com.oversight.zgProjeto.domainServer.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.oversight.zgProjeto.domainServer.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
	private String login;
	private String nome;
	private String email;
	private String token;
	private List<String> roles;

	public static UsuarioDTO create(Usuario usuario) {
		ModelMapper modelMapper = new ModelMapper();
		UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
		dto.roles = usuario.getPapeisUsuario().stream().map(p -> p.getPapel().getAuthority()).collect(Collectors.toList());
		return dto;
	}

	public static UsuarioDTO create(Usuario user, String token) {
		UsuarioDTO dto = create(user);
		dto.token = token;
		return dto;
	}

	public String toJson() throws JsonProcessingException {
		ObjectMapper m = new ObjectMapper();
		return m.writeValueAsString(this);
	}
}