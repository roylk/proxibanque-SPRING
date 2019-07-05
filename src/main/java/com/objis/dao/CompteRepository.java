package com.objis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.objis.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
	
	@Query("select c from Compte c where c.codeCompte = ?1")
	  Compte findByCodeCompte(String codeCompte);
	
	
	
	
	

}
