package com.Marmitaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Marmitaria.domains.Cardapio;
import com.Marmitaria.repository.CardapioRepository;

@RestController
@RequestMapping(value="cardapio")
public class CardapioController {
	@Autowired
	CardapioRepository cardapioRepository;
	
	@PostMapping
	public ResponseEntity<Cardapio> alterarCardapio(@RequestBody Cardapio cardapio){
		cardapioRepository.deleteAll();
		return ResponseEntity.ok(cardapioRepository.save(cardapio));
	}
	
}
