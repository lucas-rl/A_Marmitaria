package com.Marmitaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Marmitaria.domains.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{

}
