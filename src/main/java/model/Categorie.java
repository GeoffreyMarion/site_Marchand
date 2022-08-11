package model;

public class Categorie {
	private int id_categorie;
	private String titre;

	public Categorie() {
	}

	public Categorie(int id_categorie, String titre) {
		super();
		this.id_categorie = id_categorie;
		this.titre = titre;
	}
	
	public Categorie(String titre) {
		super();
		this.titre = titre;
	}

	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Categorie [id_categorie=" + id_categorie + ", titre=" + titre + "]";
	}
	
	

}
