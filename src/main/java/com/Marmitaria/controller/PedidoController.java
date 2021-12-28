package com.Marmitaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Marmitaria.domains.Pedido;
import com.Marmitaria.service.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedido){
		return ResponseEntity.ok(pedidoService.addPedido(pedido));
	}
}
