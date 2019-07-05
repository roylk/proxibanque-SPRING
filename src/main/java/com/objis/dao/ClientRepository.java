package com.objis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objis.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	

}
