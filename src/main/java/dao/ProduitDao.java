package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;
import model.Produit;
import model.Sous_categorie;

public class ProduitDao implements IDAO<Produit> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Produit produit) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO produit(titre_produit,description,prix,image,fk_id_sous_categorie,stock,stock_minimum) VALUES (?,?,?,?,?,?,?)");
			statement.setString(1, produit.getTitre_produit());
			statement.setString(2, produit.getDescription());
			statement.setDouble(3, produit.getPrix());
			statement.setString(4, produit.getImage());
			statement.setInt(5, produit.getSous_categorie().getId_sous_categorie());
			statement.setInt(6, produit.getStock());
			statement.setInt(7, produit.getStock_minimum());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Produit> read() {
		ResultSet afficher;
		ArrayList<Produit> ListProduit = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM produit INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));
				ListProduit.add(produit);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListProduit;
	}

	public Produit update(String titre_produit, String description, float prix, String image, Sous_categorie sous_categorie,int stock,int stock_minimum,int id) {
		Produit produit = null;
		if (findById(id) != null) {
			produit = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE produit SET titre_produit=?,description=?,prix=?,image=?,id_sous_categorie=?,stock=?,stock_minimum=? WHERE id_produit=?");
				statement.setString(1, titre_produit);
				statement.setString(2, description);
				statement.setFloat(3, prix);
				statement.setString(4, image);
				statement.setInt(5, sous_categorie.getId_sous_categorie());
				statement.setInt(6, stock);
				statement.setInt(7, stock_minimum);
				statement.setInt(8, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			produit.setTitre_produit(titre_produit);
			produit.setDescription(description);
			produit.setPrix(prix);
			produit.setImage(image);
			produit.setSous_categorie(sous_categorie);
			produit.setStock(stock);
			produit.setStock_minimum(stock_minimum);
			return produit;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM produit WHERE id_produit=?");
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
	public Produit findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM produit INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_produit=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				String titre_produit = afficher.getString("titre_produit");
				String description = afficher.getString("prenom");
				float prix = afficher.getFloat("prix");
				String image = afficher.getString("image");
				Sous_categorie sous_categorie = new Sous_categorie(afficher.getInt("id_sous_categorie"),
						afficher.getString("titre"),
						new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre")));
				int stock = afficher.getInt("stock");
				int stock_minimum = afficher.getInt("stock_minimum");
				Produit produit = new Produit(id,titre_produit, description, prix, image, sous_categorie, stock,
						stock_minimum);
				return produit;
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
	
	public Produit findByCat(int id_categorie) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM produit INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_categorie=?");
			statement.setInt(1, id_categorie);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				int id_produit = afficher.getInt("id_produit");
				String titre_produit = afficher.getString("titre_produit");
				String description = afficher.getString("prenom");
				float prix = afficher.getFloat("prix");
				String image = afficher.getString("image");
				Sous_categorie sous_categorie = new Sous_categorie(afficher.getInt("id_sous_categorie"),
						afficher.getString("titre"),
						new Categorie(id_categorie, afficher.getString("titre")));
				int stock = afficher.getInt("stock");
				int stock_minimum = afficher.getInt("stock_minimum");
				Produit produit = new Produit(id_produit,titre_produit, description, prix, image, sous_categorie, stock,
						stock_minimum);
				return produit;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec id_categorie="+id_categorie + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Produit findBySCat(int id_sous_categorie) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM produit INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_sous_categorie=?");
			statement.setInt(1, id_sous_categorie);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				int id_produit = afficher.getInt("id_produit");
				String titre_produit = afficher.getString("titre_produit");
				String description = afficher.getString("prenom");
				float prix = afficher.getFloat("prix");
				String image = afficher.getString("image");
				Sous_categorie sous_categorie = new Sous_categorie(id_sous_categorie,
						afficher.getString("titre"),
						new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre")));
				int stock = afficher.getInt("stock");
				int stock_minimum = afficher.getInt("stock_minimum");
				Produit produit = new Produit(id_produit,titre_produit, description, prix, image, sous_categorie, stock,
						stock_minimum);
				return produit;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec une id_sous_categorie="+id_sous_categorie + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Produit findByI(String input) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM produit INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE produit.titre_produit LIKE '%?%' OR produit.description LIKE '%?%'");
			statement.setString(1, input);
			statement.setString(2, input);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				int id_produit = afficher.getInt("id_produit");
				String titre_produit = afficher.getString("titre_produit");
				String description = afficher.getString("prenom");
				float prix = afficher.getFloat("prix");
				String image = afficher.getString("image");
				Sous_categorie sous_categorie = new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
						new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre")));
				int stock = afficher.getInt("stock");
				int stock_minimum = afficher.getInt("stock_minimum");
				Produit produit = new Produit(id_produit, titre_produit, description, prix, image, sous_categorie,
						stock, stock_minimum);
				return produit;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit contenant le mot=" + input
					+ " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public String imgBySous_cat(Sous_categorie sous_categorie) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT image FROM produit INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+"WHERE produit.fk_id_sous_categorie LIKE '?' ");
			statement.setInt(1, sous_categorie.getId_sous_categorie());
			afficher = statement.executeQuery();
			if (afficher.next()) {
				String image=afficher.getString("image");
				return image;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit contenant le mot=" + sous_categorie
					+ " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	
	}

}

