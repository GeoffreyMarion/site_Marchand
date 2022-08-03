package model;

public class Details_panier {
	private int id_details_panier;
	private Panier panier;
	private Produit produit;
	private int quantite;
	private int prix;
	
	public Details_panier() {
		super();
	}

	public Details_panier(int id_details_panier, Panier panier, Produit produit, int quantite, int prix) {
		super();
		this.id_details_panier = id_details_panier;
		this.panier = panier;
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}

	public int getId_details_panier() {
		return id_details_panier;
	}

	public void setId_details_panier(int id_details_panier) {
		this.id_details_panier = id_details_panier;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Details_panier [id_details_panier=" + id_details_panier + ", panier=" + panier + ", produit=" + produit
				+ ", quantite=" + quantite + ", prix=" + prix + "]";
	}
}
