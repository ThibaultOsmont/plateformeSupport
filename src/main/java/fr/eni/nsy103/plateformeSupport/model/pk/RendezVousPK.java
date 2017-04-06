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
	
	private String salarieId;
	private String clientId;
	
	public RendezVousPK(){		
	}
	
	public RendezVousPK(String salarieId,String clientId){
		this.salarieId = salarieId;
		this.clientId = clientId;
	}

	public String getSalarieId() {
		return salarieId;
	}

	public void setSalarieId(String salarieId) {
		this.salarieId = salarieId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result
				+ ((salarieId == null) ? 0 : salarieId.hashCode());
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
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (salarieId == null) {
			if (other.salarieId != null)
				return false;
		} else if (!salarieId.equals(other.salarieId))
			return false;
		return true;
	}


}
