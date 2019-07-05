/**
 * 
 */
package com.objis.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
// public class Client implements Serializable {
@DiscriminatorValue("CLT")
public class Client extends Personne {
	/**
	 * @Id
	 * @GeneratedValue private Long code; private String nom; private String email;
	 */
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY) // un client peut possèder plusieurs comptes
	private Collection<Compte> comptes;
	@ManyToOne
	@JoinColumn(name = "CODE_CSLR")
	private ConseillerClient conseillerClient;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param ville
	 * @param telephone
	 * @param email
	 */
	/**
	 * public Client(Long id, String code, String nom, String prenom, String ville,
	 * String telephone, String email, ConseillerClient conseillerClient) {
	 * super(id, code, nom, prenom, ville, telephone, email); // TODO Auto-generated
	 * constructor stub this.conseillerClient = conseillerClient; }
	 */

	public Client(String code, String nom, String prenom, String ville, String telephone, String email,
			ConseillerClient conseillerClient) {
		super(code, nom, prenom, ville, telephone, email);
		// TODO Auto-generated constructor stub
		this.conseillerClient = conseillerClient;
	}

	public ConseillerClient getConseillerClient() {
		return conseillerClient;
	}

	public void setConseillerClient(ConseillerClient conseillerClient) {
		this.conseillerClient = conseillerClient;
	}

}
