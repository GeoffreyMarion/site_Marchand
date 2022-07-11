package model;

import java.sql.Date;

public class Commande {
	private int id_commande;
	private  Utilisateur utilisateur;
	private Date date;
	private float total;
	private Adresse_livraison adresse;
	private int etat;
	
	public Commande() {
		
	}
	
	public Commande(int id_commande, Utilisateur utilisateur, Date date, float total, Adresse_livraison adresse, int etat) {
		super();
		this.id_commande = id_commande;
		this.utilisateur = utilisateur;
		this.date = date;
		this.total = total;
		this.adresse = adresse;
		this.etat = etat;
	}
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Adresse_livraison getAdresse_livraison() {
		return adresse;
	}
	public void setAdresse_livraison(Adresse_livraison adresse) {
		this.adresse = adresse;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}

	
}
