package fr.esic.view;

import fr.esic.controller.MyLibrary;
import fr.esic.controller.OperationClient;
import fr.esic.controller.OperationCompte;
import fr.esic.controller.OperationHistorique;
import fr.esic.model.Client;
import fr.esic.model.Compte;


public class Menu {

	public static Client clientConnected = null;
	
	public static void menuPrincipale(){
		String msg = "Menu principale \n\n\n 1- Crée un compte\n 2- Se connecter\n\n 0- Quitter";
		
		boolean sortie = false;
		
		while (sortie == false) {
			
			switch (MyLibrary.saisieInt(msg)) {
			case 1:
				OperationClient.creationClient();
				MyLibrary.afficher("Votre compte a bien été créer.");
				break;
			case 2:
				clientConnected = OperationClient.authClient();
				if (clientConnected != null) {
					menuOperation();
				} else {
					MyLibrary.afficher("Identifiant ou mot de passe incorrect.");
				}
				break;
			case 0: 
				sortie = true;
				break;
				
			default:
				MyLibrary.afficher("Erreur!!!\n\n Vous n'avez pas choisi une option existante."); 
				break;
			}
			
		}
	}
	
	public static void menuOperation(){
		String msg = "Menu Operation \n\n 1- Consulter Solde\n 2- Déposer\n 3- Retirer\n 4- Virement\n 5- Historique\n 6- Créer un nouveau compte\n 7- Information Client\n\n 8- Retour Menu \n\n 0- Quitter";
		
		boolean sortie = false;

		while (sortie == false) {
			switch (MyLibrary.saisieInt(msg)) {
			case 1:
				OperationCompte.consulterSolde(clientConnected);
				break;
			case 2:
				OperationCompte.deposer(clientConnected);
				break;
			case 3:
				OperationCompte.retirer(clientConnected);
				break;
			case 4:
				OperationCompte.versement(clientConnected);
				break;
			case 5:
				OperationHistorique.afficherHistorique();
				break;
			case 6:
				Compte c = OperationCompte.createCompte();
				clientConnected.getComptes().add(c);
				MyLibrary.afficher(c.getNumCompte() + " a bien été créer");
				break;
			case 7:
				MyLibrary.afficher(clientConnected.infoClient());
				break;
			case 8:
				sortie = true;
				break;
			case 0:
				System.exit(1);
				break;

			default:
				MyLibrary.afficher("Erreur!!!\n\n Vous n'avez pas choisi une option existante.");
				break;
			}
			
		}
	}
}