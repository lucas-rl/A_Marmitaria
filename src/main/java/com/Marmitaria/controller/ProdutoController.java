package com.Marmitaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Marmitaria.domains.Produto;
import com.Marmitaria.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	@PostMapping
	public ResponseEntity<Produto> addProduto(@RequestBody Produto produto){
		return ResponseEntity.ok(produtoRepository.save(produto)); 
	}
}
