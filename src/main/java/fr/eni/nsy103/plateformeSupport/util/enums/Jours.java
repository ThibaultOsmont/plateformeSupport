package fr.eni.nsy103.plateformeSupport.util.enums;

public enum Jours {
	LUNDI(1),MARDI(2),MERCREDI(3),JEUDI(4),VENDREDI(5),SAMEDI(6),DIMANCHE(7);
	
	private int numeroJour;
	
	private Jours(int numeroJour){
		this.numeroJour = numeroJour;
	}

	public int getNumeroJour() {
		return numeroJour;
	}

	public void setNumeroJour(int numeroJour) {
		this.numeroJour = numeroJour;
	}
	
}
