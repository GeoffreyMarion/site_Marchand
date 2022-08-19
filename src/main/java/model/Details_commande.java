package model;

public class Details_commande {
private int id_details_commande;
private Commande commande;
private Produit produit;
private int quantite;
private Float prix;

public Details_commande() {

}

public Details_commande(int id_details_commande, Commande commande, Produit produit, int quantite, Float prix) {
	this.id_details_commande = id_details_commande;
	this.commande =commande;
	this.produit = produit;
	this.quantite = quantite;
	this.prix = prix;
}

public Details_commande(Commande commande, Produit produit, int quantite, Float prix) {
	this.commande =commande;
	this.produit = produit;
	this.quantite = quantite;
	this.prix = prix;
}

public int getId_details_commande() {
	return id_details_commande;
}

public void setId_details_commande(int id_details_commande) {
	this.id_details_commande = id_details_commande;
}



public Commande getCommande() {
	return commande;
}

public void setCommande(Commande commande) {
	this.commande = commande;
}

public Produit getProduit() {
	return produit;
}

public void setProduit(Produit produit) {
	this.produit = produit;
}

public int getQuantite() {
	return quantite;
}

public void setQuantite(int quantite) {
	this.quantite = quantite;
}

public Float getPrix() {
	return prix;
}

public void setPrix(Float prix) {
	this.prix = prix;
}

@Override
public String toString() {
	return "Details_commande [id_details_commande=" + id_details_commande + ", commande=" + commande + ", quantite="
			+ quantite + ", prix=" + prix + "]";
}
}
