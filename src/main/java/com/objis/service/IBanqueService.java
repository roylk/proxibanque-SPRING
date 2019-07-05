package com.objis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.objis.entities.Compte;
import com.objis.entities.Operation;

public interface IBanqueService {
	public Compte consulterCompte(String codeCpte);

	public void verser(String codeCpte, double montant);

	public void retirer(String codeCpte, double montant);

	public void virer(String codeCpte1, String codeCpte2, double montant);

	public Page<Operation> listeOperation(String codeCpte, int page, int size);

	public Page<Operation> listeOperation(String codeCpte, Pageable pageable);

}
