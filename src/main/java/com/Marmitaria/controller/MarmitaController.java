package com.Marmitaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Marmitaria.domains.Marmita;
import com.Marmitaria.repository.MarmitaRepository;

@RestController
@RequestMapping(value="marmita")
public class MarmitaController {

	@Autowired
	private MarmitaRepository marmitaRepository;
	
	@PostMapping
	public ResponseEntity<Marmita> addMarmita(@RequestBody Marmita marmita){
		return ResponseEntity.ok(marmitaRepository.save(marmita));
	}
	
	@GetMapping
	public ResponseEntity<List<Marmita>> findAll(){
		return ResponseEntity.ok(marmitaRepository.findAll());
	}
	
}
