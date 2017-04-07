package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SALARIES")
public class Salarie implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -8136362879717650721L;

	@Id
	@SequenceGenerator(name = "SEQ_SALARIES", sequenceName = "SEQ_SALARIES")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SALARIES")
	private Integer id_salarie;
	
	@Column(name = "LOG_IN")
	private String login;
	
	@Column(name = "PWD")
	private String pwd;
	
	@Column(name = "PRESENCE" , nullable = false, columnDefinition = "bit default 0")
	private boolean presence;
	
	@Column(name = "JOUR")
	private Short jour;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personneId")
	private Personne personne;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profilId")
	private Profil profil;
	
	public Salarie(){
		presence = false;
	}

	public Integer getId() {
		return id_salarie;
	}

	public void setId(Integer id) {
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

	public boolean getPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
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
		result = prime * result
				+ ((id_salarie == null) ? 0 : id_salarie.hashCode());
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((personne == null) ? 0 : personne.hashCode());
		result = prime * result + (presence ? 1231 : 1237);
		result = prime * result + ((profil == null) ? 0 : profil.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		if (jour == null) {
			if (other.jour != null)
				return false;
		} else if (!jour.equals(other.jour))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		if (presence != other.presence)
			return false;
		if (profil == null) {
			if (other.profil != null)
				return false;
		} else if (!profil.equals(other.profil))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salarie [id=" + id_salarie + ", login=" + login + ", password="
				+ pwd + ", presence=" + presence + ", jour=" + jour + "]";
	}
}
