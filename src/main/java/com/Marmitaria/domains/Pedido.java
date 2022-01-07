package com.Marmitaria.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Pedido {
	@Id
	private String id;
	private List<ProdutoPedido> produtos = new ArrayList<>();
	private List<Marmita> marmitas = new ArrayList<>();
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date momento = new Date();
	private double total = 0;
	
	public Pedido() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ProdutoPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoPedido> produtos) {
		this.produtos = produtos;
	}

	public List<Marmita> getMarmitas() {
		return marmitas;
	}

	public void setMarmitas(List<Marmita> marmitas) {
		this.marmitas = marmitas;
	}
	
	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void valorTotal() {
		for (Marmita marmita : marmitas) {
			total += marmita.getPreco();
		}
		for (ProdutoPedido produtoPedido : produtos) {
			total += produtoPedido.getProduto().getPreco() * produtoPedido.getQuantidade();
		}
	}
	
}
