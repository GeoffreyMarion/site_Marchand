package model;

public class Administrateur {
	private int id_administrateur;
	private String nom;
	private String email;
	private String mot_de_passe;
	private String privileges;
	
	public Administrateur() {

	}

	public Administrateur(int id_administrateur, String nom, String email, String mot_de_passe, String privileges) {
		this.id_administrateur = id_administrateur;
		this.nom = nom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.privileges = privileges;
	}
	
	public Administrateur(String nom, String email, String mot_de_passe, String privileges) {
		this.nom = nom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.privileges = privileges;
	}

	public int getId_administrateur() {
		return id_administrateur;
	}

	public void setId_administrateur(int id_administrateur) {
		this.id_administrateur = id_administrateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "Administrateur [id_administrateur=" + id_administrateur + ", nom=" + nom + ", email=" + email
				+ ", mot_de_passe=" + mot_de_passe + ", privileges=" + privileges + "]";
	}
}
