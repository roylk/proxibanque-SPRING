package com.objis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objis.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, String> {

}
