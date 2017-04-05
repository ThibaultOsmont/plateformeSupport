package fr.eni.nsy103.plateformeSupport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.eni.nsy103.plateformeSupport.model.pk.RendezVousPK;

@Entity(name = "RENDEZVOUS")
@Table(name = "RENDEZVOUS")
public class RendezVous implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RendezVousPK rdvPK;
	
	@Temporal(TemporalType.DATE)
	private Date jour;
	
	//SI 0 : APRES-MIDI , SI 1 : MATIN 
	private boolean matin;
	
	public RendezVous(){
		
	}

	public RendezVousPK getRdvPK() {
		return rdvPK;
	}

	public void setRdvPK(RendezVousPK rdvPK) {
		this.rdvPK = rdvPK;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public boolean isMatin() {
		return matin;
	}

	public void setMatin(boolean matin) {
		this.matin = matin;
	}	
}
