package fr.esic.controller;

import fr.esic.model.Adresse;

public class OperationAdresse {

	//M�thode qui sert a configurer l'adresse
	public static Adresse createAdresse() {
		String rue  = MyLibrary.saisieString("Votre rue:");
		String codePostal = MyLibrary.saisieString("Votre codePostal:");
		String ville = MyLibrary.saisieString("Votre ville:");
		
		return new Adresse(rue, codePostal, ville);
	}
}