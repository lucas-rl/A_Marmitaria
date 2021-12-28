package com.Marmitaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Marmitaria.domains.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>{

}
