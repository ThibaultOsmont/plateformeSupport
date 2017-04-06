package fr.eni.nsy103.plateformeSupport.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.nsy103.plateformeSupport.model.Profil;
import fr.eni.nsy103.plateformeSupport.model.Salarie;
import fr.eni.nsy103.plateformeSupport.repository.ClientRepository;
import fr.eni.nsy103.plateformeSupport.repository.PersonneRepository;
import fr.eni.nsy103.plateformeSupport.repository.ProfilRepository;
import fr.eni.nsy103.plateformeSupport.repository.SalarieRepository;

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

	/**
	 * Page d'accueil.
	 * @param m
	 * 		Le modèle de laa page (permet le passage d'objets à la page WEB)
	 * @return
	 * 		Le chemin du template html
	 */
	@RequestMapping("/index")
	public String accueil(Model m) {
		m.addAttribute("personnes", rPersonne.findAll());
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
			@RequestParam("pwd1") String password, HttpSession session) {
		Salarie sal = rSalarie.findByLoginPassword(login, password);
		
		/**
		 * Authentification réussie
		 */
		if(null != sal) {
			session.setAttribute("salarieAuth", sal);
			Profil userProfile = rProfil.findById(sal.getId());
			/**
			 * Redirection selon le profil du salarié
			 */
			return "/" + userProfile.getUserStatus().toLowerCase();
		} else {
			return "/index";
		}
	}
}
