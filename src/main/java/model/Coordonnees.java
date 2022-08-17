package model;

public class Coordonnees {
	private int id_coordonnees;
	private String nom;
	private String adresse;
	private String telephone;
	private String email;
	private String logo;

	public Coordonnees() {

	}

	public Coordonnees(int id_coordonnees, String nom, String adresse, String telephone, String email, String logo) {
		this.id_coordonnees = id_coordonnees;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.logo = logo;
	}
	
	public Coordonnees(String nom, String adresse, String telephone, String email, String logo) {
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.logo = logo;
	}

	public int getId_coordonnees() {
		return id_coordonnees;
	}

	public void setId_coordonnees(int id_coordonnees) {
		this.id_coordonnees = id_coordonnees;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Coordonnees [id_coordonnees=" + id_coordonnees + ", nom=" + nom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", email=" + email + ", logo=" + logo + "]";
	}
}
