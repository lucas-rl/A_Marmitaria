package com.Marmitaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Marmitaria.domains.Pedido;
import com.Marmitaria.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	/*
	public ResponseEntity<List<Pedido>> findByDay(){
		return ResponseEntity.ok(pedidoRepository.);
	}
	*/
	
	public Pedido addPedido(Pedido pedido){
		
		return pedidoRepository.save(pedido);
	}
	
}
