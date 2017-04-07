package fr.eni.nsy103.plateformeSupport.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.nsy103.plateformeSupport.model.Profil;
import fr.eni.nsy103.plateformeSupport.model.Salarie;
import fr.eni.nsy103.plateformeSupport.repository.ClientRepository;
import fr.eni.nsy103.plateformeSupport.repository.PersonneRepository;
import fr.eni.nsy103.plateformeSupport.repository.ProfilRepository;
import fr.eni.nsy103.plateformeSupport.repository.SalarieRepository;
import fr.eni.nsy103.plateformeSupport.util.constantes.Constantes;

@Controller
public class SupportController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SupportController.class);
	
	@Autowired
	private PersonneRepository rPersonne;
	
	@Autowired
	private ClientRepository rClient;
	
	@Autowired
	private SalarieRepository rSalarie;
	
	@Autowired
	private ProfilRepository rProfil;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	/**
	 * Page d'accueil.
	 * @param m
	 * 		Le modèle de laa page (permet le passage d'objets à la page WEB)
	 * @return
	 * 		Le chemin du template html
	 */
	@RequestMapping(value = "/index")//, method = {RequestMethod.GET, RequestMethod.POST}
	public String accueil(Model m, @ModelAttribute(Constantes.REDIRECT_ERROR_MESSAGE) String errorMsg) {
		m.addAttribute("personnes", rPersonne.findAll());
		/**
		 * Passage à la page des éventuels messages d'erreur
		 */
		System.out.println(errorMsg + "<<<<<<<<<<");
		if(null != errorMsg) {
			m.addAttribute(Constantes.REDIRECT_ERROR_MESSAGE, errorMsg);
		}
		
		System.out.println("Hello");
		return "/index";
	}
	
	/**
	 * Authentification
	 * 
	 * @param login
	 * 		Login saisi par l'utilisateur
	 * @param password
	 * 		Mot de passe saisi
	 * @param session
	 * 		Session Http
	 * 
	 * @return
	 * 		Le chemin du template html
	 */
	@PostMapping(value = "/login", consumes="application/x-www-form-urlencoded;charset=UTF-8")
	public String login(@RequestParam("log_in") String login, 
			@RequestParam("pwd1") String password, HttpSession session, RedirectAttributes rAttributes) {
		Salarie sal = rSalarie.findByLoginPassword(login, password);
		
		/**
		 * Authentification réussie
		 */
		if(null != sal) {
			Profil userProfile = rProfil.findById(sal.getId());
			session.setAttribute(Constantes.SALARIE_AUTHENTIFIE, sal);
			session.setAttribute("profil", userProfile.getUserStatus());
			
			/**
			 * Redirection selon le profil du salarié
			 */
			return "redirect:/" + userProfile.getUserStatus().toLowerCase();
		} else {
			/**
			 * Échec authentification
			 */
			rAttributes.addAttribute(Constantes.REDIRECT_ERROR_MESSAGE, "Échec de l'authentification");
			return "redirect:/index";
		}
	}
}
