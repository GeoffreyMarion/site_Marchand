package model;

public class Adresse_livraison {
	private int id_adresse;
	private String adresse;
	private int code_postal;
	private String ville;
	private String pays;
	
	public Adresse_livraison() {

	}

	public Adresse_livraison(int id_adresse, String adresse, int code_postal, String ville, String pays) {
		this.id_adresse = id_adresse;
		this.adresse = adresse;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	public int getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}
