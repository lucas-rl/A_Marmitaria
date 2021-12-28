package com.Marmitaria.domains;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Marmita extends Produto{
	private String tamanho;
	private Cardapio ingredientes;
	
	public Marmita() {}
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public Cardapio getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Cardapio ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
