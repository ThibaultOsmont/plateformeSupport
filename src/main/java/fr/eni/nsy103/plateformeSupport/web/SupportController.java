package fr.eni.nsy103.plateformeSupport.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupportController {

	@RequestMapping("/index")
	public String accueil(Model m) {
		m.addAttribute("name", "baptou fragile");
		System.out.println("Hello");
		return "/index";
	}

	// @RequestMapping("/error")
	// public void erreur() {
	// System.out.println("erreur");
	// }
}
