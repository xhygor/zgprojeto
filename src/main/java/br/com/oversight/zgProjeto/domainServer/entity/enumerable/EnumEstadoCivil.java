package br.com.oversight.zgProjeto.domainServer.entity.enumerable;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumEstadoCivil {

	SOLTEIRO("Solteiro(a)"),
	CASADO("Casado(a)"),
	VIUVO("Viúvo(a)"),
	SEPARADO("Separado(a) judicialmente"),
	DIVORCIADO("Divorciado(a)");

	private final String descricao;
	
    public static EnumEstadoCivil[] valuesVisivel() {
        List<EnumEstadoCivil> lista = new ArrayList<>();
        for (EnumEstadoCivil v : values()) {
                lista.add(v);
        }
        return lista.toArray(new EnumEstadoCivil[lista.size()]);
    }
}
