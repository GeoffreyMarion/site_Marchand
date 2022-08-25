package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;
import model.Produit;
import model.Images;
import model.Sous_categorie;

public class ImagesDao implements IDAO<Images> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Images images) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO images(fk_id_produit,url) VALUES (?,?)");
			statement.setInt(1, images.getProduit().getId_produit());
			statement.setString(2, images.getUrl());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Images> read() {
		ResultSet afficher;
		ArrayList<Images> ListImages = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM images INNER JOIN produit ON images.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Images images = new Images(afficher.getInt("id_image"),
						produit, afficher.getString("url"));
				ListImages.add(images);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListImages;
	}

	public Images update(Produit produit, String url,int id) {
		Images images = null;
		if (findById(id) != null) {
			images = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE images SET fk_id_produit=?,url=? WHERE id_image=?");
				statement.setInt(1, produit.getId_produit());
				statement.setString(2, url);
				statement.setInt(3, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			images.setProduit(produit);
			images.setUrl(url);
			return images;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM images WHERE id_image=?");
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
	public Images findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM images INNER JOIN produit ON images.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_image=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Images favori = new Images(id, produit, afficher.getString("url"));
				return favori;
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
	
	public ArrayList<Images> findByProd(int idprod) {
		ResultSet afficher;
		ArrayList<Images> ListImages = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM images INNER JOIN produit ON images.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie "
							+ "WHERE id_produit = ?");
			statement.setInt(1, idprod);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Images images = new Images(afficher.getInt("id_image"),
						produit, afficher.getString("url"));
				ListImages.add(images);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListImages;
	}
}


