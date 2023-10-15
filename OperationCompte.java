package fr.esic.controller;

import fr.esic.model.Client;
import fr.esic.model.Compte;


public class OperationCompte {

	public static int num = 1;
	
	//Méthode qui sert a cree un nouveau compte et d'incrementer de +1 chaque nouveau compte
	public static Compte createCompte() {
		Compte c = new Compte("FR00P75015B" + num, 0);
		num++;
		return c;
	}

	//Méthode qui sert a choisir un client
	public static Compte choixCompteByClient(Client client) {
		String data = "";
		int nb = 1;
		for (Compte c : client.getComptes()) {
			data += nb + "- " + c.infoCompte() + "\n";
			nb++;
		}

		int choix = MyLibrary.saisieInt("Choisir le compte \n" + data);

		return client.getComptes().get(choix - 1);
	}

	//Méthode qui sert a consulter le solde
	public static void consulterSolde(Client client) {
		MyLibrary.afficher("Le solde est de " + choixCompteByClient(client).getSolde() + " €");
	}

	//Méthode qui sert a effectuer le depot avec un client choisi
	public static void deposer(Client client) {
		Compte c = choixCompteByClient(client);
		double oldSolde = c.getSolde();
		double montantDepot = MyLibrary.saisieDouble("Montant du dépot");
		c.depot(montantDepot);
		MyLibrary.afficher("Dépot terminé ! \n Ancien solde : " + oldSolde + " € \n Nouveau solde : " +  c.getSolde()+ " € ");
		OperationHistorique historique = new OperationHistorique("Depot", montantDepot);
		OperationHistorique.historique();
		OperationHistorique.ajouterHistorique(historique);
	}

	//Méthode qui sert a effectuer le retrait avec un client choisi
	public static void retirer(Client client) {
		Compte c = choixCompteByClient(client);
		double oldSolde = c.getSolde();
		double montantRetrait = MyLibrary.saisieDouble("Montant du Retrait");
		c.retrait(montantRetrait);
		MyLibrary.afficher("Retrait terminé ! \n Ancien solde : " + oldSolde + " € \n Nouveau solde : " +  c.getSolde()+ " € ");
		OperationHistorique historique = new OperationHistorique("Retrait", montantRetrait);
		OperationHistorique.historique();
		OperationHistorique.ajouterHistorique(historique);
	}
	
	//Méthode qui sert a effectuer le virement avec un client choisi
	public static void versement(Client client) {
		MyLibrary.afficher("Vous allez effectuer un virement! \n Veuillez d'abord choisir le compte qui envoie. \n Puis celui qui reçois. ");
		Compte c = choixCompteByClient(client);
		Compte c2 = choixCompteByClient(client);
		double oldSolde = c.getSolde();
		double oldSolde2 = c2.getSolde();
		double montantVersement = MyLibrary.saisieDouble("Montant du Versement");
		c.virement( c2, montantVersement);
		MyLibrary.afficher("Virement envoyé ! \n Ancien solde : " + oldSolde + " € \n Nouveau solde : " +  c.getSolde()+ " € ");
		MyLibrary.afficher("Virement reçu ! \n Ancien solde : " + oldSolde2 + " € \n Nouveau solde : " +  c2.getSolde()+ " € ");
		OperationHistorique historique = new OperationHistorique("Virement", montantVersement);
		OperationHistorique.historique();
		OperationHistorique.ajouterHistorique(historique);
	}
	
	
}
