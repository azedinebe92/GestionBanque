package fr.esic.controller;

import java.util.ArrayList;
import java.util.Date;

public class OperationHistorique {
	private static ArrayList<OperationHistorique> operations;
	private String type;
	private double montant;
	private Date date;
	
	public OperationHistorique(String type, double montant) {
		this.type = type;
		this.montant = montant;
		this.date = new Date();
	}
	
	//Méthode qui sert a creer une nouvelle list pour stocker l'historique
	public static void historique() {
		operations = new ArrayList<>();
	}
	
	//Méthode qui sert a ajouter une operation dans la list de l'historique
	public static void ajouterHistorique(OperationHistorique operation) {
		operations.add(operation) ;
	}
	
	//Méthode qui sert a afficher la list de l'historique
	public static void afficherHistorique() {
		for (OperationHistorique operation : operations) {
			if (operations != null) {
				MyLibrary.afficher("Voici l'historique des actions: " + operations);
			}
		}
	}
}
