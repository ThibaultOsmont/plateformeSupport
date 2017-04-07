package fr.eni.nsy103.plateformeSupport.model.pk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import fr.eni.nsy103.plateformeSupport.model.Client;
import fr.eni.nsy103.plateformeSupport.model.Salarie;

@Embeddable
public class RendezVousPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "clientId")
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "salarieId")
	private Salarie salarie;
	
	public RendezVousPK(){		
	}
	
	public RendezVousPK(Client client,Salarie salarie){
		this.client = client;
		this.salarie = salarie;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		result = prime * result + ((client == null) ? 0 : client.hashCode());
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
		RendezVousPK other = (RendezVousPK) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (salarie == null) {
			if (other.salarie != null)
				return false;
		} else if (!salarie.equals(other.salarie))
			return false;
		return true;
	}	
}
