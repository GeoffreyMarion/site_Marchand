package model;

public class Commentaire {
private int id_commentaire;
private String commentaire;
private int note;
private Produit produit;
private Utilisateur utilisateur;

public Commentaire() {

}

public Commentaire(int id_commentaire, String commentaire, int note, Produit produit, Utilisateur utilisateur) {
	super();
	this.id_commentaire = id_commentaire;
	this.commentaire = commentaire;
	this.note = note;
	this.produit = produit;
	this.utilisateur = utilisateur;
}

public int getId_commentaire() {
	return id_commentaire;
}
public void setId_commentaire(int id_commentaire) {
	this.id_commentaire = id_commentaire;
}
public String getCommentaire() {
	return commentaire;
}
public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}
public int getNote() {
	return note;
}
public void setNote(int note) {
	this.note = note;
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

@Override
public String toString() {
	return "Commentaire [id_commentaire=" + id_commentaire + ", commentaire=" + commentaire + ", note=" + note
			+ ", utilisateur=" + utilisateur + "]";
}

}
