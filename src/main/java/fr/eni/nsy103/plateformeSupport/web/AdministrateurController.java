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
	 * 		Le mod�le de la page HTML
	 * 
	 * @param session
	 * 		La session du serveur
	 * 
	 * @param rAttributes
	 * 		Pour ajouter et r�cup�rer des atrributs pass�s pour la redirection.
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
		 * R�cup�ration des donn�es pour l'administrateur
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
	 * Cr��r un nouveau client.
	 * 
	 * @param request
	 * 		Les donn�es du nouveau client
	 * 
	 * @param m
	 * 		Le mod�le de la page HTML
	 * 
	 * @return
	 * 		Le template HTML
	 */
	@PostMapping(value = "/nouveauClient")
	public String creerNouveauClient(HttpServletRequest request, Model m) {
		/**
		 * Cr�ation des entit�as
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
	 * 		Les donn�es mises � jour du client
	 * 
	 * @return
	 * 		Le template HTML
	 */
	@PatchMapping(value = "/modifierClient")
	private String modifierUtilisateur(HttpServletRequest request) {
		/**
		 * R�cup�ration du client
		 */
		Client cli = rClient.findOne(Long.valueOf(request.getParameter("id-client")));
		
		/*
		 * Modification des donn�es
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

	@PostMapping(value = "/nouveauAccueil")
	public String creerNouvelAccueil(HttpServletRequest request,Model m){
		Personne p = new Personne();
		Salarie s = new Salarie();
		
		p.setNom(request.getParameter("nomAcc"));
		p.setPrenom(request.getParameter("prenomAcc"));
		p.setMail(request.getParameter("mailAcc"));
		p.setTelephone(request.getParameter("telephoneAcc"));
		
		rPersonne.save(p);
		
		s = generateLoginPwd(p, s);
		s.setJour(Short.parseShort(request.getParameter("jourAcc")));
		
		rSalarie.save(s);
		
		return "redirect:/adm";
	}
	
	public Salarie generateLoginPwd(Personne p,Salarie s){
		String pwd = "1234";
		String login = null;
		if(p.getNom().length() > 8)
			login = p.getPrenom().substring(0,1).toLowerCase() + p.getNom().substring(0,8).toLowerCase();
		else
			login = p.getPrenom().substring(0,1).toLowerCase() + p.getNom().toLowerCase();
		s.setLogin(login);
		s.setPassword(pwd);			
		return s;
	}
}
