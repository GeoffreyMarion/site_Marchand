package model;

import java.sql.Date;

public class Recherche {
	private int id_recherche;
	private Utilisateur utilisateur;
	private String mot_cle;
	private Date date_recherche;
	
	public Recherche() {

	}

	public Recherche(int id_recherche, Utilisateur utilisateur, String mot_cle, Date date_recherche) {
		this.id_recherche = id_recherche;
		this.utilisateur = utilisateur;
		this.mot_cle = mot_cle;
		this.date_recherche = date_recherche;
	}
	
	public Recherche(Utilisateur utilisateur, String mot_cle) {
		this.utilisateur = utilisateur;
		this.mot_cle = mot_cle;
	}

	public int getId_recherche() {
		return id_recherche;
	}

	public void setId_recherche(int id_recherche) {
		this.id_recherche = id_recherche;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getMot_cle() {
		return mot_cle;
	}

	public void setMot_cle(String mot_cle) {
		this.mot_cle = mot_cle;
	}

	public Date getDate_recherche() {
		return date_recherche;
	}

	public void setDate_recherche(Date date_recherche) {
		this.date_recherche = date_recherche;
	}
}
