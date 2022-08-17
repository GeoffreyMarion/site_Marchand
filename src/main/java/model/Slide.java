package model;

public class Slide {
	private int id_slide;
	private String titre_slide;
	private String image;
	private String url;

	public Slide() {

	}

	public Slide(int id_slide, String titre_slide, String image, String url) {
		this.id_slide = id_slide;
		this.titre_slide = titre_slide;
		this.image = image;
		this.url = url;
	}
	
	public Slide(String titre_slide, String image, String url) {
		this.titre_slide = titre_slide;
		this.image = image;
		this.url = url;
	}

	public int getId_slide() {
		return id_slide;
	}

	public void setId_slide(int id_slide) {
		this.id_slide = id_slide;
	}

	public String getTitre_slide() {
		return titre_slide;
	}

	public void setTitre_slide(String titre_slide) {
		this.titre_slide = titre_slide;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Slide [id_slide=" + id_slide + ", titre_slide=" + titre_slide + ", image=" + image + ", url=" + url
				+ "]";
	}

}
