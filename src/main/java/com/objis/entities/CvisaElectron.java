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
@DiscriminatorValue("VELE")
public class CvisaElectron extends CarteVisa {

	/**
	 * 
	 */
	public CvisaElectron() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCarte
	 * @param compte
	 */
	public CvisaElectron(Long numCarte, Compte compte) {
		super(numCarte, compte);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCarte,
	 *            le numero de carte
	 * @param numCompte,
	 *            le numero de compte
	 */

}
