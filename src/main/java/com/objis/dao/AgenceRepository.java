package com.objis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objis.entities.Agence;

public interface AgenceRepository extends JpaRepository<Agence, String> {

}
