package com.objis.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.objis.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	@Query("select o from Operation o where o.compte.codeCompte=:x order by o.date desc")
	public Page<Operation> listeOperation(@Param("x")String codeCpte, Pageable pageable);

}
