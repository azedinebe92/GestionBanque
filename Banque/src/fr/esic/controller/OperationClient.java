package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import fr.esic.model.Compte;
import fr.esic.model.Adresse;
import fr.esic.model.Client;


public class OperationClient {
	
	public static List<Client> clients = new ArrayList<>();

	//Méthode qui sert a cree un client
	public static void creationClient() {
		String nom = MyLibrary.saisieString("Votre nom:");
		String prenom = MyLibrary.saisieString("Votre prenom:");
		int age = MyLibrary.saisieInt("Votre age:");
		String login = MyLibrary.saisieString("Votre login:");
		String password = MyLibrary.saisieString("Votre mot de passe:");

		Adresse a = OperationAdresse.createAdresse();

		List<Compte> comptes = new ArrayList<>();
		comptes.add(OperationCompte.createCompte());

		Client c = new Client(nom, prenom, age, login, password, a, comptes);
		clients.add(c);
	}

	//Méthode qui sert a verifier l'authentification
	public static Client authClient() {
		String login = MyLibrary.saisieString("Votre login:");
		String password = MyLibrary.saisieString("Votre mot de passe:");

		Client c = null;

		for (Client client : clients) {
			if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
				c = client;
			}
		}

		return c;
	}

	}
