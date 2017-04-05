package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.eni.nsy103.plateformeSupport.enumerations.UserStatus;

@Entity(name = "PROFILS")
@Table(name = "PROFILS")
public class Profil implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 3)
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
	@OneToOne
	private Salarie salarie;
	
	public Profil(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Salarie getSalarie() {
		return salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((salarie == null) ? 0 : salarie.hashCode());
		result = prime * result
				+ ((userStatus == null) ? 0 : userStatus.hashCode());
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
		Profil other = (Profil) obj;
		if (id != other.id)
			return false;
		if (salarie == null) {
			if (other.salarie != null)
				return false;
		} else if (!salarie.equals(other.salarie))
			return false;
		if (userStatus != other.userStatus)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return salarie.getSalarie().getPrenom() + " " + salarie.getSalarie().getNom() + " statut : " + userStatus.name(); 
	}
}
