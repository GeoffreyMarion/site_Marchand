package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;
import model.Favori;
import model.Produit;
import model.Sous_categorie;
import model.Utilisateur;

public class FavoriDao implements IDAO<Favori> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Favori visite) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO favori(fk_id_produit,fk_id_utilisateur) VALUES (?,?)");
			statement.setInt(1, visite.getProduit().getId_produit());
			statement.setInt(2, visite.getUtilisateur().getId_utilisateur());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Favori> read() {
		ResultSet afficher;
		ArrayList<Favori> ListFavori = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM favori INNER JOIN utilisateur ON favori.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN produit ON favori.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Favori favori = new Favori(afficher.getInt("id_favori"),
						produit, utilisateur);
				ListFavori.add(favori);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListFavori;
	}

	public Favori update(Produit produit, Utilisateur utilisateur,int id) {
		Favori visite = null;
		if (findById(id) != null) {
			visite = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE favori SET fk_id_produit=?,fk_id_utilisateur=? WHERE id_favori=?");
				statement.setInt(1, produit.getId_produit());
				statement.setInt(2, utilisateur.getId_utilisateur());
				statement.setInt(5, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			visite.setProduit(produit);
			visite.setUtilisateur(utilisateur);
			return visite;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM favori WHERE id_favori=?");
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
	public Favori findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM favori INNER JOIN utilisateur ON favori.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN produit ON favori.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_favori=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Favori favori = new Favori(id, produit, utilisateur);
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
	
	public ArrayList<Favori> findByP(int id_produit) {
		ResultSet afficher = null;
		ArrayList<Favori> ListFavori = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM favori INNER JOIN utilisateur ON favori.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN produit ON favori.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_produit=?");
			statement.setInt(1, id_produit);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));

				Produit produit = new Produit(id_produit, afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Favori favori = new Favori(afficher.getInt("id_favori"), produit, utilisateur);
				ListFavori.add(favori);
			}
			return ListFavori;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id_produit + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Favori> findByU(int id_utilisateur) {
		ResultSet afficher = null;
		ArrayList<Favori> ListFavori = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM favori INNER JOIN utilisateur ON favori.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN produit ON favori.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE fk_id_utilisateur=?");
			statement.setInt(1, id_utilisateur);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(id_utilisateur, afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Favori favori = new Favori(afficher.getInt("id_favori"), produit, utilisateur);
				ListFavori.add(favori);
			}
			return ListFavori;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec une id_sous_categorie="+id_utilisateur + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Favori> findByU_P(int id_produit,int id_utilisateur) {
		ResultSet afficher = null;
		ArrayList<Favori> ListFavori = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM favori INNER JOIN utilisateur ON favori.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN produit ON favori.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE fk_id_produit=? AND fk_id_utilisateur=?");
			statement.setInt(1, id_produit);
			statement.setInt(2, id_utilisateur);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(id_utilisateur, afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));

				Produit produit = new Produit(id_produit, afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Favori favori = new Favori(afficher.getInt("id_favori"), produit, utilisateur);
				ListFavori.add(favori);
			}
			return ListFavori;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec une id_sous_categorie="+id_utilisateur + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Favori> FindByMot(String input) {
		ResultSet afficher;
		ArrayList<Favori> ListFavori = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM favori INNER JOIN utilisateur ON favori.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN produit ON favori.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie "
							+ "WHERE utilisateur.prenom LIKE ? OR utilisateur.nom LIKE ? OR  produit.titre_produit LIKE ?");
			statement.setString(1,"%" + input + "%");
			statement.setString(2,"%" + input + "%");
			statement.setString(3,"%" + input + "%");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Favori favori = new Favori(afficher.getInt("id_favori"),
						produit, utilisateur);
				ListFavori.add(favori);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListFavori;
	}
}

