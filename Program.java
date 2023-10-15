package fr.esic.view;

import java.util.ArrayList;
import java.util.List;

import fr.esic.controller.OperationClient;
import fr.esic.controller.OperationCompte;
import fr.esic.model.Adresse;
import fr.esic.model.Client;
import fr.esic.model.Compte;

public class Program {

	static {
		Compte c1 = new Compte("FR00P75015B" + OperationCompte.num, 150);
		OperationCompte.num++;
		Compte c2 = new Compte("FR00P75015B" + OperationCompte.num, 0);
		OperationCompte.num++;
		Compte c3 = new Compte("FR00P75015B" + OperationCompte.num, 300);
		OperationCompte.num++;

		List<Compte> comptes1 = new ArrayList<>();
		comptes1.add(c1);
		comptes1.add(c2);
		List<Compte> comptes2 = new ArrayList<>();
		comptes2.add(c3);

		Adresse a1 = new Adresse("374 rue de vaugirad", "75015", "Paris");
		Adresse a2 = new Adresse("36 Avenue Pierre Brossollet", "92240", "Malakoff");

		Client client1 = new Client("BELLA", "Azedine", 21, "a", "a", a1, comptes1);
		Client client2 = new Client("ROJA", "Nat", 19, "qsd", "azerty", a2, comptes2);
		OperationClient.clients.add(client1);
		OperationClient.clients.add(client2);

	}
	
	public static void main(String[] args) {
		Menu.menuPrincipale();
	}
}