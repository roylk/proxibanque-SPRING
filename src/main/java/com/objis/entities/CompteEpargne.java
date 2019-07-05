/**
 * 
 */
package com.objis.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author R. KOUANI
 *
 */
@Entity
// @Data
// @NoArgsConstructor
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private double taux;

	public CompteEpargne() {
		super();
		// this.taux = taux;
	}

	public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, Agence agence,
			double taux) {
		super(codeCompte, dateCreation, solde, client, agence);
		this.taux = taux;
		// TODO Auto-generated constructor stub
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
