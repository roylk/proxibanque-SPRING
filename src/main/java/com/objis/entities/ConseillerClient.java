/**
 * 
 */
package com.objis.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author R. KOUANI
 *
 */
@Entity
@Data

@DiscriminatorValue("CSL")
public class ConseillerClient extends Personne {
	/**
	 * @Id
	 * @GeneratedValue private Long code; private String nom; private String email;
	 */
	@OneToMany(mappedBy = "conseillerClient", fetch = FetchType.LAZY)
	private Collection<Client> clients;
	@ManyToOne
	@JoinColumn(name = "CODE_GER")
	private Gerant gerant;

	/**
	 * 
	 */
	public ConseillerClient() {
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
	public ConseillerClient(String code, String nom, String prenom, String ville, String telephone, String email,
			Gerant gerant) {
		super(code, nom, prenom, ville, telephone, email);
		// TODO Auto-generated constructor stub
		this.gerant = gerant;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param ville
	 * @param telephone
	 * @param email
	 */
	public ConseillerClient(String nom, String prenom, String ville, String telephone, String email, Gerant gerant) {
		super();// id, nom, prenom, ville, telephone, email);
		// TODO Auto-generated constructor stub
		this.gerant = gerant;
	}

}
