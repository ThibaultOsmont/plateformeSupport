package fr.eni.nsy103.plateformeSupport.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
