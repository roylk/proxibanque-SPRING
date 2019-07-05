/**
 * 
 */
package com.objis.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objis.dao.AgenceRepository;
import com.objis.dao.CarteVisaRepository;
import com.objis.dao.ClientRepository;
import com.objis.dao.CompteRepository;
import com.objis.dao.OperationRepository;
import com.objis.dao.PersonneRepository;
import com.objis.entities.Compte;
import com.objis.entities.CompteCourant;
import com.objis.entities.Operation;
import com.objis.entities.Retrait;
import com.objis.entities.Versement;

/**
 * @author R. KOUANI
 *
 */
@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private PersonneRepository personneRepository;

	@Autowired
	private AgenceRepository agenceRepository;

	@Autowired
	private CarteVisaRepository carteVisaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.objis.service.IBanqueService#consulterCompte(java.lang.String)
	 */
	@Override
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		Compte cp = compteRepository.findByCodeCompte(codeCpte);
		if (cp == null)
			throw new RuntimeException("compte introuvable");
		return cp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.objis.service.IBanqueService#verser(java.lang.String, double)
	 */
	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);// creation d'un nouveau versement
		operationRepository.save(v);// enregistrement de l'opération
		cp.setSolde(cp.getSolde() + montant);// mise à jour du solde
		compteRepository.save(cp); // enregistrement du compte à jour

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.objis.service.IBanqueService#retirer(java.lang.String, double)
	 */
	@Override
	public void retirer(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp = consulterCompte(codeCpte);
		double etatCaisse = 0;
		if (cp instanceof CompteCourant)// check solde
			etatCaisse = ((CompteCourant) cp).getDecouvert();
		if (etatCaisse + cp.getSolde() < montant)
			throw new RuntimeException("solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);// creation d'un nouveau retrait
		operationRepository.save(r);// enregistrement de l'opération
		cp.setSolde(cp.getSolde() - montant);// mise à jour du solde
		compteRepository.save(cp); // enregistrement du compte à jour
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.objis.service.IBanqueService#virer(java.lang.String,
	 * java.lang.String, double)
	 */
	@Override
	public void virer(String codeCpte1, String codeCpte2, double montant) {
		// TODO Auto-generated method stub
		if (codeCpte1.equals(codeCpte2))
			throw new RuntimeException("impossible de virer d'un compte vers lui-meme");
		verser(codeCpte2, montant);
		retirer(codeCpte1, montant);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.objis.service.IBanqueService#listeOperation(java.lang.String, int,
	 * int)
	 */
	@Override
	public Page<Operation> listeOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.listeOperation(codeCpte, new PageRequest(page, size));
	}

	@Override
	public Page<Operation> listeOperation(String codeCpte, Pageable pageable) {
		// TODO Auto-generated method stub
		return operationRepository.listeOperation(codeCpte, pageable);
	}

}
