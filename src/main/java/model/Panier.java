package model;

import java.sql.Date;

public class Panier {
	private int id_panier;
	private  Utilisateur utilisateur;
	private float total;
	
	
	public Panier() {
		super();
	}

	public Panier(int id_panier, Utilisateur utilisateur, float total) {
		super();
		this.id_panier = id_panier;
		this.utilisateur = utilisateur;
		this.total = total;
	}

	public int getId_panier() {
		return id_panier;
	}

	public void setId_panier(int id_panier) {
		this.id_panier = id_panier;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Panier [id_panier=" + id_panier + ", utilisateur=" + utilisateur + ", total=" + total + "]";
	}
}
