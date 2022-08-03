package model;

public class Details_panier {
	private Produit produit;
	private int qte;
	
	public Details_panier() {
	}
	public Details_panier(Produit produit, int qte) {
		this.produit = produit;
		this.qte = qte;
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	@Override
	public String toString() {
		return "Panier [produit=" + produit + ", qte=" + qte + "]";
	}
}

