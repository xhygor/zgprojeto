package br.com.oversight.zgProjeto.domainServer.entity.enumerable;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumSexo {

	M("Masculino", true),
	F("Feminino", true);

	private final String descricao;
	private final boolean visivel;

	public static EnumSexo[] valuesVisivel() {
		List<EnumSexo> lista = new ArrayList<>();
		for (EnumSexo v : values()) {
			if (v.isVisivel()) {
				lista.add(v);
			}
		}
		return lista.toArray(new EnumSexo[lista.size()]);
	}
}
