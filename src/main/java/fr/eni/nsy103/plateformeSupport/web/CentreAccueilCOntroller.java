package fr.eni.nsy103.plateformeSupport.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.nsy103.plateformeSupport.model.Salarie;
import fr.eni.nsy103.plateformeSupport.util.constantes.Constantes;

/**
 * Controleur du centre d'accueil
 * 
 * @author tosmont2016
 *
 */
@Controller
@RequestMapping("/acc")
public class CentreAccueilCOntroller {
	@RequestMapping
	public String accueilCentreAccueil(Model m, RedirectAttributes rAttr, HttpSession session) {
		if(null == session.getAttribute("salarieAuth")) {
			rAttr.addAttribute(Constantes.REDIRECT_ERROR_MESSAGE, "Vous devez vous authentifier !");
			return "redirect:/index";
		}
		
		m.addAttribute("profil", session.getAttribute("profil"));
		m.addAttribute("salarie", ((Salarie) session.getAttribute(Constantes.SALARIE_AUTHENTIFIE)).getPersonne());

		return "/acc";
	}
}
