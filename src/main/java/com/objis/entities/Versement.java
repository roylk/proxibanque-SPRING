/**
 * 
 */
package com.objis.entities;

import java.util.Date;
import java.util.Optional;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author R. KOUANI
 *
 */
@Entity @Data @NoArgsConstructor
@DiscriminatorValue("V")
public class Versement extends Operation {
	public Versement(Date date, double montant, Compte cp) {
		super(date, montant, cp);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
