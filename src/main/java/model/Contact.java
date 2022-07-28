package model;

public class Contact {
private int id_contact;
private String sujet;
private String message;
private boolean etat_contact;
private Utilisateur utilisateur;
private String email;

public Contact() {

}

public Contact(int id_contact, String sujet, String message, boolean etat_contact, Utilisateur utilisateur,
		String email) {
	this.id_contact = id_contact;
	this.sujet = sujet;
	this.message = message;
	this.etat_contact = etat_contact;
	this.utilisateur = utilisateur;
	this.email = email;
}
public Contact(String sujet, String message, boolean etat_contact, Utilisateur utilisateur,
		String email) {
	this.sujet = sujet;
	this.message = message;
	this.etat_contact = etat_contact;
	this.utilisateur = utilisateur;
	this.email = email;
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

public boolean isEtat_contact() {
	return etat_contact;
}

public void setEtat_contact(boolean etat_contact) {
	this.etat_contact = etat_contact;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Contact [id_contact=" + id_contact + ", sujet=" + sujet + ", message=" + message + ", etat_contact="
			+ etat_contact + ", utilisateur=" + utilisateur + ", email=" + email + "]";
}

}
