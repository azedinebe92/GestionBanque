package fr.esic.controller;

import javax.swing.JOptionPane;

public class MyLibrary {
	//Méthode qui sert a effectuer la saisie entier
	public static int saisieInt(String msg) {
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
			}
	//Méthode qui sert a effectuer la saisie double
	public static double saisieDouble(String msg) {
		return Double.parseDouble(JOptionPane.showInputDialog(msg));
	}
	//Méthode qui sert a effectuer la saisie chaine de caractere
	public static String saisieString (String msg) {
		return JOptionPane.showInputDialog(msg);
		}
	//Méthode qui sert a afficher des messages en chaine de charactere
	public static void afficher(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}