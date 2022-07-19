package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;
import model.Sous_categorie;

public class Sous_categorieDao implements IDAO<Sous_categorie> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Sous_categorie sous_categorie) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("Insert INTO sous_categorie(titre,fk_id_categorie) VALUES (?,?)");
			statement.setString(1, sous_categorie.getTitre());
			statement.setInt(1, sous_categorie.getCategorie().getId_categorie());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Sous_categorie> read() {
		ResultSet afficher;
		ArrayList<Sous_categorie> ListSous_categorie = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM sous_categorie INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Sous_categorie sous_categorie = new Sous_categorie(afficher.getInt("id_sous_categorie"),
						afficher.getString("titre"),
						new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre")));
				ListSous_categorie.add(sous_categorie);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListSous_categorie;
	}

	public Sous_categorie update(String titre,Categorie categorie, int id) {
		Sous_categorie sous_categorie = null;
		if (findById(id) != null) {
			sous_categorie = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE sous_categorie SET titre=?,fk_id_categorie=? WHERE id_sous_categorie=?");
				statement.setString(1, titre);
				statement.setInt(2, categorie.getId_categorie());
				statement.setInt(3, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			sous_categorie.setTitre(titre);
			return sous_categorie;
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
						.prepareStatement("DELETE FROM sous_categorie WHERE id_sous_categorie=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove de l'utilisateur id=" + id + " fait\n----------------");
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
	public Sous_categorie findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM sous_categorie INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_sous_categorie=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				String titre = afficher.getString("titre");
				Categorie categorie = new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"));
				Sous_categorie sous_categorie = new Sous_categorie(id, titre, categorie);
				return sous_categorie;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Sous_categorie findByCat(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM sous_categorie INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE fk_id_categorie=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				String titre = afficher.getString("titre");
				Categorie categorie = new Categorie(id, afficher.getString("titre"));
				Sous_categorie sous_categorie = new Sous_categorie(afficher.getInt("id_sous_categorie"), titre, categorie);
				return sous_categorie;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<String> ReadImgsProd() {
		ResultSet afficher;
		ArrayList<String> ListImages = new ArrayList<>();
		ProduitDao PDao= new ProduitDao();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM sous_categorie INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Sous_categorie sous_categorie = new Sous_categorie(afficher.getInt("id_sous_categorie"),
						afficher.getString("titre"),
						new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre")));
				String image= PDao.imgBySous_cat(sous_categorie);
				ListImages.add(image);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListImages;
	}
}
