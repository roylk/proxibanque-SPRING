/**
 * 
 */
package com.objis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.objis.entities.Compte;
import com.objis.entities.Operation;
import com.objis.service.IBanqueService;

/**
 * @author R. KOUANI
 *
 */
@Controller
public class BanqueController {

	@Autowired
	private IBanqueService banqueService;

	@RequestMapping("/") // pour avoir une vue en tapant l'url http://localhost/operations
	public String index() {
		return "template1";// necessité de créer une page comptes.html
	}

	@RequestMapping("/operations") // pour avoir une vue en tapant l'url http://localhost/operations
	public String rechOp() {
		return "comptes";// necessité de créer une page comptes.html
	}

	@RequestMapping("/consulterCompte") // pour avoir une vue en tapant l'url http://localhost/consulterCompte
	public String consulterCompte(Model model, String codeCompte,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s) {
		model.addAttribute("codeCompte", codeCompte); // ajout du code compte à la vue
		try {
			Compte cp = banqueService.consulterCompte(codeCompte);
			// Page<Operation> pageOperations = banqueService.listeOperation(codeCompte, 0,
			// 4);// initialisation
			Page<Operation> pageOperations = banqueService.listeOperation(codeCompte, new PageRequest(p, s));// initialisation
			model.addAttribute("compte", cp);// ajout du compte à la vue
			model.addAttribute("listeOperations", pageOperations.getContent());// ajout de la liste au model
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("size", s);// ajout de la taille(nombre d'éléments) dans le model
			model.addAttribute("pageCourante", p);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}

		return "comptes";// necessité de créer une page comptes.html
	}

	@RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
	public String saveOperation(Model model, String typeOperation, String codeCompte, double montant,
			String codeCompte2) {

		try {
			if (typeOperation.equals("VERS")) {
				banqueService.verser(codeCompte, montant);
			} else if (typeOperation.equals("RETR")) {
				banqueService.retirer(codeCompte, montant);
			} else {
				banqueService.virer(codeCompte, codeCompte2, montant);
			}

		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?codeCompte=" + codeCompte + "&error=" + e.getMessage();

		}

		return "redirect:/consulterCompte?codeCompte=" + codeCompte;

	}

}
