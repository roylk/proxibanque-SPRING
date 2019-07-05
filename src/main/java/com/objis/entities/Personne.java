/**
 * 
 */
package com.objis.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

/**
 * @author R. KOUANI
 *
 */

@Entity
@Data
// @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERS", discriminatorType = DiscriminatorType.STRING, length = 3)
public abstract class Personne {

	// 1. Section Propri�t�s

	// @GeneratedValue
	// private Long id;
	@Id
	private String code;
	private String nom;
	private String prenom;
	private String ville;
	private String telephone;
	private String email;

	/**
	 * 
	 */
	public Personne() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 *            le nom
	 * @param prenom
	 *            le pr�nom
	 * @param ville
	 *            la ville
	 * @param telephone
	 *            le numero de t�l�phone
	 * @param email
	 *            l'adresse e-mail
	 */
	public Personne(String code, String nom, String prenom, String ville, String telephone, String email) {
		super();
		// this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
		this.code = code;
	}

	/**
	 * @return the id
	 */
	/*
	 * public Long getId() { return id; }
	 */

	/**
	 * @param id
	 *            the id to set
	 */
	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

}
