package model;

import java.util.Date;

public class Visite {
private int id_visite;
private Produit produit;
private Utilisateur utilisateur;
private Date date_visite;

public Visite() {

}


public Visite(int id_visite, Produit produit, Utilisateur utilisateur, Date date_visite) {
	super();
	this.id_visite = id_visite;
	this.produit = produit;
	this.utilisateur = utilisateur;
	this.date_visite = date_visite;
}

public Visite(Produit produit, Utilisateur utilisateur) {
	super();
	this.produit = produit;
	this.utilisateur = utilisateur;
}

public int getId_visite() {
	return id_visite;
}

public void setId_visite(int id_visite) {
	this.id_visite = id_visite;
}


public Produit getProduit() {
	return produit;
}


public void setProduit(Produit produit) {
	this.produit = produit;
}


public Utilisateur getUtilisateur() {
	return utilisateur;
}


public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}


public Date getDate_visite() {
	return date_visite;
}


public void setDate_visite(Date date_visite) {
	this.date_visite = date_visite;
}


@Override
public String toString() {
	return "Visite [id_visite=" + id_visite + ", produit=" + produit + ", utilisateur=" + utilisateur + ", date_visite="
			+ date_visite + "]";
}

}
