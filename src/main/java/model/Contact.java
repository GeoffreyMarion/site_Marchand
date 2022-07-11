package model;

public class Contact {
private int id_contact;
private String sujet;
private String message;
private int etat_contact;
private Utilisateur utilisateur;

public Contact() {

}

public Contact(String sujet, String message, int etat_contact) {
	this.sujet = sujet;
	this.message = message;
	this.etat_contact = etat_contact;
}

public Contact(int id_contact, Utilisateur utilisateur, String sujet, String message, int etat_contact) {
	this.id_contact = id_contact;
	this.utilisateur = utilisateur;
	this.sujet = sujet;
	this.message = message;
	this.etat_contact = etat_contact;
}
public int getId_contact() {
	return id_contact;
}
public void setId_contact(int id_contact) {
	this.id_contact = id_contact;
}




public Utilisateur getUtilisateur() {
	return utilisateur;
}


public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}


public String getSujet() {
	return sujet;
}
public void setSujet(String sujet) {
	this.sujet = sujet;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getEtat_contact() {
	return etat_contact;
}
public void setEtat_contact(int etat_contact) {
	this.etat_contact = etat_contact;
}


@Override
public String toString() {
	return "Contact [id_contact=" + id_contact + ", sujet=" + sujet + ", message=" + message + ", etat_contact="
			+ etat_contact + ", utilisateur=" + utilisateur + "]";
}

}
