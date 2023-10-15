package fr.esic.model;

public class Compte {

	private String numCompte;
	private double solde;
	
	//Constructeur vide
	public Compte() {
		
	}

	//Constructeur plein
	public Compte(String numCompte, double solde) {
		this.numCompte = numCompte;
		this.solde = solde;
	}
	
	//Méthode qui sert a effectuer le depot
	public double depot(double montant) {
		if(montant > 0) {
		 solde += montant;
		}
		return solde;
	}
	
	//Méthode qui sert a effectuer le retrait
	public boolean retrait(double montant) {
		if(montant <= solde) {
			solde-=montant;
			return true;
		}else {
			return false;
		}
	}
	
	//Méthode qui sert a effectuer le virement
	public boolean virement(Compte c, double montant) {
		if(montant <= solde) {
			this.retrait(montant);
			c.depot(montant);
			return true;
		}else {
			return false;
		}
	}

	
	//Méthode get et set
	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	//Méthode qui sert a voir les information sur le compte
	public String infoCompte() {
		return "N° : " + numCompte + " Solde : " + solde;
	}
}