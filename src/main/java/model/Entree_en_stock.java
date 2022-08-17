package model;

import java.util.Date;

public class Entree_en_stock {
	private int id_entree_en_stock;
	private Fournisseur fournisseur;
	private Produit produit;
	private Date date_entree_en_stock;
	private int quantite;

	public Entree_en_stock() {
	}

	public Entree_en_stock(int id_entree_en_stock, Fournisseur fournisseur, Produit produit, Date date_entree_en_stock,
			int quantite) {
		super();
		this.id_entree_en_stock = id_entree_en_stock;
		this.fournisseur = fournisseur;
		this.produit = produit;
		this.date_entree_en_stock = date_entree_en_stock;
		this.quantite = quantite;
	}
	
	public Entree_en_stock(Fournisseur fournisseur, Produit produit,int quantite) {
		super();
		this.fournisseur = fournisseur;
		this.produit = produit;
		this.quantite = quantite;
	}


	public int getId_entree_en_stock() {
		return id_entree_en_stock;
	}

	public void setId_entree_en_stock(int id_entree_en_stock) {
		this.id_entree_en_stock = id_entree_en_stock;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Date getDate_entree_en_stock() {
		return date_entree_en_stock;
	}

	public void setDate_entree_en_stock(Date date_entree_en_stock) {
		this.date_entree_en_stock = date_entree_en_stock;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "Entree_en_stock [id_entree_en_stock=" + id_entree_en_stock + ", fournisseur=" + fournisseur
				+ ", date_entree_en_stock=" + date_entree_en_stock + ", quantite=" + quantite + "]";
	}
}
