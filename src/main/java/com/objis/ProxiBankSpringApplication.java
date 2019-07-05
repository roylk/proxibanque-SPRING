package com.objis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.objis.dao.AgenceRepository;
import com.objis.dao.CarteVisaRepository;
import com.objis.dao.ClientRepository;
import com.objis.dao.CompteRepository;
import com.objis.dao.OperationRepository;
import com.objis.dao.PersonneRepository;
import com.objis.entities.Agence;
import com.objis.entities.CarteVisa;
import com.objis.entities.Client;
import com.objis.entities.Compte;
import com.objis.entities.CompteCourant;
import com.objis.entities.CompteEpargne;
import com.objis.entities.ConseillerClient;
import com.objis.entities.CvisaElectron;
import com.objis.entities.CvisaPremier;
import com.objis.entities.Gerant;
import com.objis.entities.Personne;
import com.objis.service.IBanqueService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProxiBankSpringApplication implements CommandLineRunner {

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

	@Autowired
	private IBanqueService banqueService;

	public static void main(String[] args) {
		SpringApplication.run(ProxiBankSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Gerant g1 = personneRepository
				.save(new Gerant("g1", "kamga", "gabriel", "paradis", "25451855222", "gparadis@email.pa"));

		Personne cc1 = personneRepository
				.save(new ConseillerClient("cc1", "Monso", "David", "Yaounde", "68855554", "dmonso@mail.cm", g1));

		Personne c1 = personneRepository.save(
				new Client("c1", "kouani", "roger", "Yaounde", "56854558", "kouani@k.fr", (ConseillerClient) cc1));

		Personne c2 = personneRepository.save(
				new Client("c2", "tiani", "clotilde", "Yaounde", "56784558", "tianii@k.fr", (ConseillerClient) cc1));

		Agence Ag1 = agenceRepository.save(new Agence("Ag1", new Date(), g1));

		Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(), 90000, (Client) c1, Ag1, 5000));

		Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(), 70000, (Client) c2, Ag1, 6));

		/*
		 * operationRepository.save(new Versement(new Date(), 5000, cp1));
		 * operationRepository.save(new Retrait(new Date(), 12500, cp1));
		 * operationRepository.save(new Versement(new Date(), 7000, cp2));
		 * operationRepository.save(new Versement(new Date(), 25000, cp2));
		 * operationRepository.save(new Versement(new Date(), 61000, cp2));
		 * operationRepository.save(new Retrait(new Date(), 14500, cp2));
		 * banqueService.verser("c1", 11001);
		 */

		CarteVisa carte1 = carteVisaRepository.save(new CvisaPremier((long) 102458853, cp1));
		CarteVisa carte2 = carteVisaRepository.save(new CvisaElectron((long) 102458858, cp2));

		/*
		 * Compte cp4= compteRepository.save(new CompteCourant("c1", new Date(), 90000,
		 * c1, 6000)); Compte cp2= compteRepository.save(new CompteEpargne("c2", new
		 * Date(),25000,c2,5)); operationRepository.save(new Versement(new Date(), 5000,
		 * cp1)); operationRepository.save(new Versement(new Date(), 23000, cp1));
		 * operationRepository.save(new Versement(new Date(), 60000, cp1));
		 * operationRepository.save(new Retrait(new Date(), 12500, cp1));
		 * 
		 * operationRepository.save(new Versement(new Date(), 7000, cp2));
		 * operationRepository.save(new Versement(new Date(), 25000, cp2));
		 * operationRepository.save(new Versement(new Date(), 61000, cp2));
		 * operationRepository.save(new Retrait(new Date(), 14500, cp2));
		 * 
		 * banqueService.verser("c1", 11001);
		 */

	}

}
