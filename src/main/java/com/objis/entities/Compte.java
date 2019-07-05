/**
 * 
 */
package com.objis.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
// @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Compte implements Serializable {
	@Id
	private String codeCompte;

	private Date dateCreation;

	private double solde;

	@ManyToOne
	@JoinColumn(name = "CODE_CLI")
	private Client client;

	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private Collection<Operation> operations;

	@ManyToOne
	@JoinColumn(name = "CODE_AGC")
	private Agence agence;
	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private Collection<CarteVisa> cartes;

	public Compte() {
		super();

	}

	public Compte(String codeCompte, Date dateCreation, double solde, Client client, Agence agence) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		this.agence = agence;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

}
