/**
 * 
 */
package com.objis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author R. KOUANI
 *
 */

@Entity
@Data @NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING, length=1)
public abstract  class Operation implements Serializable {
	@Id @GeneratedValue
	private Long numero;
	private Date date;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	public Operation(Date date, double montant, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.compte = compte;
	}
	
	
	
	

}
