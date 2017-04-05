package fr.eni.nsy103.plateformeSupport.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.eni.nsy103.plateformeSupport.model.Client;
import fr.eni.nsy103.plateformeSupport.model.Salarie;

@Embeddable
public class RendezVousPK implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	private int salarieId;
	private int clientId;
	
	public RendezVousPK(){		
	}
	
	public RendezVousPK(int salarieId,int clientId){
		this.salarieId = salarieId;
		this.clientId = clientId;
	}

	public int getSalarieId() {
		return salarieId;
	}

	public void setSalarieId(int salarieId) {
		this.salarieId = salarieId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clientId;
		result = prime * result + salarieId;
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
		if (clientId != other.clientId)
			return false;
		if (salarieId != other.salarieId)
			return false;
		return true;
	}	
}
