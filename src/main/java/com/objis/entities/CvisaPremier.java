/**
 * 
 */
package com.objis.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

/**
 * @author R. KOUANI
 *
 */
@Entity
@Data
// @NoArgsConstructor
@DiscriminatorValue("VPRE")
public class CvisaPremier extends CarteVisa {

	/**
	 * 
	 */
	public CvisaPremier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCarte
	 * @param compte
	 */
	public CvisaPremier(Long numCarte, Compte compte) {
		super(numCarte, compte);
		// TODO Auto-generated constructor stub
	}

}
