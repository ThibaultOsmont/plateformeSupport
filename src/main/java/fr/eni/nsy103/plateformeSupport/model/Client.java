package fr.eni.nsy103.plateformeSupport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id_client;
	
	@OneToOne(mappedBy = "client")
	@JoinColumn(name = "ID_CLIENT")
	private Personne personne;

	public String getId_client() {
		return id_client;
	}

	public void setId_client(String id_client) {
		this.id_client = id_client;
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
				+ ((id_client == null) ? 0 : id_client.hashCode());
		result = prime * result
				+ ((personne == null) ? 0 : personne.hashCode());
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
		Client other = (Client) obj;
		if (id_client == null) {
			if (other.id_client != null)
				return false;
		} else if (!id_client.equals(other.id_client))
			return false;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", personne=" + personne
				+ "]";
	}
}
