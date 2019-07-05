/**
 * 
 */
package com.objis.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author R. KOUANI
 *
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CVISA", discriminatorType = DiscriminatorType.STRING, length = 4)
public abstract class CarteVisa implements Serializable {

	@Id
	private Long numCarte;
	@ManyToOne
	@JoinColumn(name = "CODE_CPTE")
	private Compte compte;

	/**
	 * 
	 */
	public CarteVisa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCarte,
	 *            le numero de la carte
	 * @param numCompte,
	 *            le numero du compte
	 */
	public CarteVisa(Long numCarte, Compte compte) {
		super();
		this.numCarte = numCarte;
		this.compte = compte;
	}

	/**
	 * @return the numCarte
	 */
	public Long getNumCarte() {
		return numCarte;
	}

	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param numCarte
	 *            the numCarte to set
	 */
	public void setNumCarte(Long numCarte) {
		this.numCarte = numCarte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
