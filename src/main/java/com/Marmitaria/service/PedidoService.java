package com.Marmitaria.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Marmitaria.domains.Marmita;
import com.Marmitaria.domains.Pedido;
import com.Marmitaria.domains.Produto;
import com.Marmitaria.repository.MarmitaRepository;
import com.Marmitaria.repository.PedidoRepository;
import com.Marmitaria.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private MarmitaRepository marmitaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public List<Pedido> findByDate(String from, String to){
		
		String[] dataInicial = from.split("-");
		Calendar inicio = new GregorianCalendar(Integer.parseInt(dataInicial[2]),
											Integer.parseInt(dataInicial[1])-1,
											Integer.parseInt(dataInicial[0]));
		inicio.add(Calendar.HOUR_OF_DAY, 3);
		
		String[] dataFinal = from.split("-");
		Calendar fim = new GregorianCalendar(Integer.parseInt(dataFinal[2]),
											Integer.parseInt(dataFinal[1])-1,
											Integer.parseInt(dataFinal[0]));
		fim.add(Calendar.HOUR_OF_DAY, 21);
		
		return pedidoRepository.getObjectByDate(inicio.getTime(), fim.getTime());
		
	}
	
	public Pedido addPedido(Pedido pedido){
		for (int i = 0; i < pedido.getMarmitas().size(); i++) {
			List<Marmita> marmitas = marmitaRepository.findAll();
			for (Marmita marmita : marmitas) {
				if (pedido.getMarmitas().get(i).getDescricao().equals(marmita.getDescricao()) && 
					pedido.getMarmitas().get(i).getTamanho().equals(marmita.getTamanho())) {
					pedido.getMarmitas().get(i).setPreco(marmita.getPreco());
					break;
				}
			}
		}
		for (int i = 0 ; i < pedido.getProdutos().size(); i++) {
			List<Produto> produtos = produtoRepository.findAll();
			for (Produto produto : produtos) {
				if(pedido.getProdutos().get(i).getProduto().getDescricao().equals(produto.getDescricao())) {
					pedido.getProdutos().get(i).getProduto().setPreco(produto.getPreco());
					break;
				}
			}
		}
		pedido.valorTotal();
		return pedidoRepository.save(pedido);
	}
	
}
