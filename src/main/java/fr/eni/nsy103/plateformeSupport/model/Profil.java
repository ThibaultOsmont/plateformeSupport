package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.eni.nsy103.plateformeSupport.enumerations.UserStatus;

@Entity
public class Profil implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 3)
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
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
}
