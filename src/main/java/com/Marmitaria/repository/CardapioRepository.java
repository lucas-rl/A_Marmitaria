package com.Marmitaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Marmitaria.domains.Cardapio;

@Repository
public interface CardapioRepository extends MongoRepository<Cardapio, String>{

}
