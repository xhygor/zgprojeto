package br.com.oversight.zgProjeto.domainServer.entity.enumerable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumPapel implements GrantedAuthority {

	ADMIN("Administrador"),
	USUARIO("Usuário");

	private final String descricao;

	@Override
	public String getAuthority() {
		return name();
	}

	public static EnumPapel[] valuesVisivel() {
		List<EnumPapel> lista = new ArrayList<>();
		for (EnumPapel v : values()) {
			lista.add(v);
		}
		return lista.toArray(new EnumPapel[lista.size()]);
	}
}
