package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALARIES")
public class Salarie implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -8136362879717650721L;

	@Id
	private String id_salarie;
	
	@Column(name = "LOG_IN")
	private String login;
	
	@Column(name = "PWD")
	private String pwd;
	
	@Column(name = "PRESENCE")
	private Short presence;
	
	@Column(name = "JOUR")
	private Short jour;

	@OneToOne(mappedBy = "salarie")
	@JoinColumn(name = "ID_SALARIE")
	private Personne personne;
	
	@OneToOne(mappedBy = "salarie")
	@JoinColumn(name = "ID_SALARIE")
	private Profil profil;

	public String getId() {
		return id_salarie;
	}

	public void setId(String id) {
		this.id_salarie = id;
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

	public short getPresence() {
		return presence;
	}

	public void setPresence(short presence) {
		this.presence = presence;
	}

	public short getJour() {
		return jour;
	}

	public void setJour(short jour) {
		this.jour = jour;
	}
	
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_salarie == null) ? 0 : id_salarie.hashCode());
		result = prime * result + jour;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + presence;
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
		if (id_salarie == null) {
			if (other.id_salarie != null)
				return false;
		} else if (!id_salarie.equals(other.id_salarie))
			return false;
		if (jour != other.jour)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (presence != other.presence)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salarie [id=" + id_salarie + ", login=" + login + ", password="
				+ pwd + ", presence=" + presence + ", jour=" + jour + "]";
	}
}
