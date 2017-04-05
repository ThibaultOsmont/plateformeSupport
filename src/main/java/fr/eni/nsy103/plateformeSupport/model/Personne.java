package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Personne")
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 40,nullable = true)
	private String nom;
	
	@Column(length = 40,nullable = true)
	private String prenom;
	
	public Personne(){
	}
	
	public Personne(String prenom,String nom){
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public String toString(){
		return prenom + " " + nom;		
	}
}
