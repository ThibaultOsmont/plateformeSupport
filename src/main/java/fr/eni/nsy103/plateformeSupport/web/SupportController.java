package fr.eni.nsy103.plateformeSupport.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.nsy103.plateformeSupport.repository.PersonneRepository;

@Controller
public class SupportController {
	
	@Autowired
	private PersonneRepository rPersonne;

	@RequestMapping("/index")
	public String accueil(Model m) {
		m.addAttribute("personnes", rPersonne.findAll());
		System.out.println("Hello");
		return "/index";
	}

	// @RequestMapping("/error")
	// public void erreur() {
	// System.out.println("erreur");
	// }
}
