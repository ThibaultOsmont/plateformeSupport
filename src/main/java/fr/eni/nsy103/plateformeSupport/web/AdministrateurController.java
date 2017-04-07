package fr.eni.nsy103.plateformeSupport.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.nsy103.plateformeSupport.model.Client;
import fr.eni.nsy103.plateformeSupport.model.Personne;
import fr.eni.nsy103.plateformeSupport.model.Salarie;
import fr.eni.nsy103.plateformeSupport.repository.ClientRepository;
import fr.eni.nsy103.plateformeSupport.repository.PersonneRepository;
import fr.eni.nsy103.plateformeSupport.repository.RendezVousRepository;
import fr.eni.nsy103.plateformeSupport.repository.SalarieRepository;
import fr.eni.nsy103.plateformeSupport.util.constantes.Constantes;

/**
 * Controleur de la page des administrateurs
 * .
 * @author tosmont2016
 *
 */
@Controller
@RequestMapping("/adm")
public class AdministrateurController {
	
	@Autowired
	private PersonneRepository rPersonne;
	
	@Autowired
	private ClientRepository rClient;
	
	@Autowired
	private SalarieRepository rSalarie;
	
	@Autowired
	private RendezVousRepository rRdv;
	
	/**
	 * Page d'accueil de l'administrateur
	 * 
	 * @param m
	 * 		Le modèle de la page HTML
	 * 
	 * @param session
	 * 		La session du serveur
	 * 
	 * @param rAttributes
	 * 		Pour ajouter et récupérer des atrributs passés pour la redirection.
	 * 
	 * @return
	 * 		Le template HTML
	 */
	@GetMapping
	public String adminAccueil(Model m, HttpSession session, RedirectAttributes rAttributes) {
		if(null == session.getAttribute("salarieAuth")) {
			rAttributes.addAttribute(Constantes.REDIRECT_ERROR_MESSAGE, "Vous devez vous authentifier !");
			return "redirect:/index";
		}
		
		/**
		 * Récupération des données pour l'administrateur
		 */
		m.addAttribute("profil", session.getAttribute("profil"));
		m.addAttribute("salarie", ((Salarie) session.getAttribute(Constantes.SALARIE_AUTHENTIFIE)).getPersonne());
		
		m.addAttribute(Constantes.CLIENTS_ADMIN, rClient.findAll());
		m.addAttribute(Constantes.CONSEILLERS_ADMIN, rSalarie.findAllConseiller());
		m.addAttribute(Constantes.CENTRE_ACC_ADMIN, rSalarie.findAllCentreAccueil());
		m.addAttribute(Constantes.ADMIN, rSalarie.findAllAdmin());
		m.addAttribute(Constantes.RDV_ADMIN, rRdv.findAll());
		
		return "/adm";
	}
	
	/**
	 * Créér un nouveau client.
	 * 
	 * @param request
	 * 		Les données du nouveau client
	 * 
	 * @param m
	 * 		Le modèle de la page HTML
	 * 
	 * @return
	 * 		Le template HTML
	 */
	@PostMapping(value = "/nouveauClient")
	public String creerNouveauClient(HttpServletRequest request, Model m) {
		/**
		 * Création des entitéas
		 */
		Client cli = new Client();
		Personne pers = new Personne();
		pers.setNom(request.getParameter("nomCli"));
		pers.setPrenom(request.getParameter("prenomCli"));
		pers.setMail(request.getParameter("mailCli"));
		pers.setTelephone(request.getParameter("telephoneCli"));
		
		/**
		 * Sauvegarde en base
		 */
		rPersonne.save(pers);
		System.out.println("id client " + pers.getId());
		cli.setPersonne(pers);
		rClient.save(cli);
		
		return "redirect:/adm";
	}
	
	/**
	 * Modifier les informations d'un client existant.
	 * 
	 * @param request
	 * 		Les données mises à jour du client
	 * 
	 * @return
	 * 		Le template HTML
	 */
	@PatchMapping(value = "/modifierClient")
	private String modifierUtilisateur(HttpServletRequest request) {
		/**
		 * Récupération du client
		 */
		Client cli = rClient.findOne(Long.valueOf(request.getParameter("id-client")));
		
		/*
		 * Modification des données
		 */
		Personne pers = cli.getPersonne();
		pers.setNom(request.getParameter("modNomCli"));
		pers.setPrenom(request.getParameter("modPrenomCli"));
		pers.setMail(request.getParameter("modMailCli"));
		pers.setTelephone(request.getParameter("modTelephoneCli"));
		
		/*
		 * Sauvegarde en base
		 */
		rPersonne.save(pers);
		
		return "redirect:/adm";
	}
}
