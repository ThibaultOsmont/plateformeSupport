package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.eni.nsy103.plateformeSupport.enumerations.Jours;

@Entity
@Table(name = "SALARIES")
public class Salarie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_SALARIE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "LOG_IN", nullable = false, unique = true,length = 30)
	private String login;
	
	@Column(name = "PWD", nullable = false,length = 15)
	private String pwd;
	
	@Column(name = "PRESENCE", nullable = false)
	private boolean presence;
	
	@Enumerated(EnumType.ORDINAL)
	private Jours jour;
	
	@ManyToOne
	private Personne salarie;
	
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
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}
	
	public Personne getSalarie() {
		return salarie;
	}

	public void setSalarie(Personne salarie) {
		this.salarie = salarie;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + (presence ? 1231 : 1237);
		result = prime * result + ((salarie == null) ? 0 : salarie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salarie other = (Salarie) obj;
		if (id != other.id)
			return false;
		if (jour != other.jour)
			return false;
		if (presence != other.presence)
			return false;
		if (salarie == null) {
			if (other.salarie != null)
				return false;
		} else if (!salarie.equals(other.salarie))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return salarie.getPrenom() + " " + salarie.getNom();
	}
}
