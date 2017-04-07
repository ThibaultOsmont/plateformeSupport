package fr.eni.nsy103.plateformeSupport.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@SequenceGenerator(name = "SEQ_CLIENTS", sequenceName = "SEQ_CLIENTS")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CLIENTS")
	private Integer id_client;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id",unique = true,nullable = false)
	private Personne client;	

	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public Personne getPersonne() {
		return client;
	}

	public void setPersonne(Personne personne) {
		this.client = personne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_client == null) ? 0 : id_client.hashCode());
		result = prime * result
				+ ((client == null) ? 0 : client.hashCode());
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
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", personne=" + client
				+ "]";
	}
}
