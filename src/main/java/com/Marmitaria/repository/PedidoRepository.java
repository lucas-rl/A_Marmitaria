package com.Marmitaria.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Marmitaria.domains.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>{

	@Query("{'momento':{$gt:?0}}")                 
	public List<Pedido> getObjectByDate(Date from, Date to); 
	
}
