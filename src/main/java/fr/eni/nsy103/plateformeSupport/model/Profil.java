package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Table Profil
 * 
 * @author tosmont2016
 *
 */
@Entity
@Table(name = "PROFILS")
public class Profil implements Serializable {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 9008611685057435478L;

	@Id
	@SequenceGenerator(name = "SEQ_PROFILS", sequenceName = "SEQ_PROFILS")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROFILS")
	private Integer id_profil;

	@Column(name = "USERSTATUS")
	private String userStatus;

	public Integer getId() {
		return id_profil;
	}

	public void setId(Integer id) {
		this.id_profil = id;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_profil == null) ? 0 : id_profil.hashCode());
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
		if (id_profil == null) {
			if (other.id_profil != null)
				return false;
		} else if (!id_profil.equals(other.id_profil))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profil [id_profil=" + id_profil + ", userStatus=" + userStatus
				+ "]";
	}	
}
