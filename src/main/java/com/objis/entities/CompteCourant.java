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
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, Agence agence,
			double decouvert) {
		super(codeCompte, dateCreation, solde, client, agence);
		this.decouvert = decouvert;
		// TODO Auto-generated constructor stub
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
