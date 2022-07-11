package model;

public class Image {
	private int id_image;
	private Produit produit;
	private String url;

	public Image() {

	}


	public Image(int id_image, Produit produit, String url) {
		super();
		this.id_image = id_image;
		this.produit = produit;
		this.url = url;
	}

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Image [id_image=" + id_image + ", produit=" + produit + ", url=" + url + "]";
	}
}
