package fr.eni.nsy103.plateformeSupport.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RendezVousPK implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	private Integer salarieId;
	private Integer clientId;
	
	public RendezVousPK(){		
	}
	
	public RendezVousPK(Integer salarieId,Integer clientId){
		this.salarieId = salarieId;
		this.clientId = clientId;
	}

	public Integer getSalarieId() {
		return salarieId;
	}

	public void setSalarieId(Integer salarieId) {
		this.salarieId = salarieId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
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
