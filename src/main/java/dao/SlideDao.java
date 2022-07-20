package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Slide;

public class SlideDao implements IDAO<Slide>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Slide slide) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO slide(titre_slide,image,url) VALUES (?,?,?)");
			statement.setString(1,slide.getTitre_slide());
			statement.setString(2,slide.getImage());
			statement.setString(3,slide.getUrl());
			statement.executeUpdate();
			return true;
			}
			catch (SQLException e){
				System.out.println("Données non crées");
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public ArrayList<Slide> read() {
		ResultSet afficher;
		ArrayList<Slide> ListSlide = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM slide");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Slide slide = new Slide(afficher.getInt("id_slide"), afficher.getString("titre_slide"),
						afficher.getString("image"), afficher.getString("url"));
				ListSlide.add(slide);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListSlide;
	}
	
	public Slide update(String titre_slide, String image, String url,int id) {
		Slide slide = null;
		if (findById(id) != null) {
			slide = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE slide SET titre_slide=?,image=?,url=? WHERE id_slide=?");
				statement.setString(1, titre_slide);
				statement.setString(2, image);
				statement.setString(3, url);
				statement.setInt(4, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			slide.setTitre_slide(titre_slide);
			slide.setImage(image);
			slide.setUrl(url);
			return slide;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}
	
	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM slide WHERE id_slide=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove du contact id=" + id + " fait\n----------------");
				return true;
			} catch (SQLException e) {
				System.out.println("Remove non fait");
				e.printStackTrace();
			}
		} else {
			System.out.println("Remove non fait id non présent dans la base");
		}
		return false;
	}

	@Override
	public Slide findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM slide WHERE id_slide=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			if (afficher.next()) {
				String titre_slide = afficher.getString("titre_slide");
				String image = afficher.getString("image");
				String url = afficher.getString("url");
				Slide slide= new Slide(id,titre_slide,image,url);
				return slide;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

}

