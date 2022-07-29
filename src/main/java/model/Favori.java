package model;

public class Favori {
private int id_favori;
private Produit produit;
private Utilisateur utilisateur;

public Favori() {

}

public Favori(int id_favori, Produit produit, Utilisateur utilisateur) {
	super();
	this.id_favori = id_favori;
	this.produit = produit;
	this.utilisateur = utilisateur;
}

public Favori(Produit produit, Utilisateur utilisateur) {
	super();
	this.produit = produit;
	this.utilisateur = utilisateur;
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

public int getId_favori() {
	return id_favori;
}
public void setId_favori(int id_favori) {
	this.id_favori = id_favori;
}

@Override
public String toString() {
	return "Favori [id_favori=" + id_favori + ", utilisateur=" + utilisateur + "]";
}
}
