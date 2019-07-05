/**
 * 
 */
package com.objis.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
public class Agence implements Serializable {
	@Id
	private String codeAgence;
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name = "CODE_GER")
	private Gerant gerant;
	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	/**
	 * 
	 */
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codeAgence
	 * @param dateCreation
	 * @param gerant
	 * @param comptes
	 */
	public Agence(String codeAgence, Date dateCreation, Gerant gerant) {
		super();
		this.codeAgence = codeAgence;
		this.dateCreation = dateCreation;
		this.gerant = gerant;

	}

}
