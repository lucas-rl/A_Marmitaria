package com.Marmitaria.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		return ResponseEntity.ok(pedidoService.findAll());
	} 
	
	@GetMapping(value="/{from}/{to}")
	public ResponseEntity<List<Pedido>> findByDate(@PathVariable String from, @PathVariable String to){
	System.out.println(from+"   "+to);
		return ResponseEntity.ok(pedidoService.findByDate(from, to));
	}
}
