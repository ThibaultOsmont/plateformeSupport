package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.eni.nsy103.plateformeSupport.enumerations.Jours;

@Entity
public class Salarie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false,unique = true,length = 30)
	private String login;
	
	@Column(nullable = false,length = 15)
	private String password;
	
	@Column(nullable = false)
	private boolean presence;
	
	@Enumerated(EnumType.ORDINAL)
	private Jours jour;
	
	private Personne personne;
	
	public Salarie(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public Jours getJour() {
		return jour;
	}

	public void setJour(Jours jour) {
		this.jour = jour;
	}

	@Override
	public String toString(){
		return personne.getPrenom() + " " + personne.getNom();
	}
}
