package com.Marmitaria.domains;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cardapio {
	@Id
	private String id;
	private List<String> proteinas;
	private List<String> acompanhamentos;
	
	public Cardapio() {}
	
	public Cardapio(List<String> proteinas, List<String> acompanhamentos) {
		this.proteinas = proteinas;
		this.acompanhamentos = acompanhamentos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getProteinas() {
		return proteinas;
	}

	public void setProteinas(List<String> proteinas) {
		this.proteinas = proteinas;
	}

	public List<String> getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(List<String> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	
}
