/**
 * 
 */
package com.objis.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author R. KOUANI
 *
 */
@Entity
@Data
@DiscriminatorValue("GER")
public class Gerant extends Personne {

	/**
	 * @Id
	 * @GeneratedValue private Long code; private String nom; private String email;
	 */
	@OneToMany(mappedBy = "gerant", fetch = FetchType.LAZY)
	private Collection<ConseillerClient> conseillers;
	@OneToMany(mappedBy = "gerant", fetch = FetchType.LAZY) // un client peut possèder plusieurs comptes
	private Collection<Agence> agence;

	/**
	 * 
	 */
	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param ville
	 * @param telephone
	 * @param email
	 */
	public Gerant(String code, String nom, String prenom, String ville, String telephone, String email) {
		super(code, nom, prenom, ville, telephone, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param ville
	 * @param telephone
	 * @param email
	 */
	public Gerant(String nom, String prenom, String ville, String telephone, String email) {
		super();
		// id, nom, prenom, ville, telephone, email);
		// TODO Auto-generated constructor stub
	}

}
