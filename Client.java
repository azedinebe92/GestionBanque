package fr.esic.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String nom;
	private String prenom;
	private int age;
	private String login;
	private String password;
	private Adresse adresse;
	private List<Compte> comptes;
	
	//Constructeur vide
	public Client() {
		
	}
	
	//Constructeur plein
	public Client(String nom, String prenom, int age, String login, String password, Adresse adresse, List<Compte> comptes) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.comptes = comptes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	//Méthode qui sert a afficher les information du client
	public String infoClient() {
		return prenom + " " + nom + " " + age + " ans ==> [" + login + "]\n" 
	+ adresse.infoAdresse() + "\n" + afficherComptes();
	}
	
	
	//Méthode qui sert a afficher les comptes
	private String afficherComptes() {
		String data = "";
		for (Compte compte : comptes) {
			data += compte.infoCompte() + "\n";
		}
		return data;
	}
}