package com.Marmitaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Marmitaria.domains.Marmita;

@Repository
public interface MarmitaRepository extends MongoRepository<Marmita, String>{

}
