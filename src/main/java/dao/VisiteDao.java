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
import model.Utilisateur;
import model.Visite;

public class VisiteDao implements IDAO<Visite> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Visite visite) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO visite(fk_id_produit,fk_id_utilisateur,date_visite) VALUES (?,?,now())");
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
	public ArrayList<Visite> read() {
		ResultSet afficher;
		ArrayList<Visite> ListVisite = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM visite INNER utilisateur ON visite.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON visite.fk_id_produit=produit.id_produit"
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

				Visite visite = new Visite(afficher.getInt("id_visite"),
						produit, utilisateur, afficher.getDate("date_visite"));
				ListVisite.add(visite);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListVisite;
	}

	public Visite update(Produit produit, Utilisateur utilisateur,int id) {
		Visite visite = null;
		if (findById(id) != null) {
			visite = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE visite SET fk_id_produit=?,fk_id_utilisateur=? WHERE id_visite=?");
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
				PreparedStatement statement = connection.prepareStatement("DELETE FROM visite WHERE id_visite=?");
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
	public Visite findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM visite INNER utilisateur ON visite.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON visite.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_visite=?");
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

				Visite visite = new Visite(id, produit, utilisateur, afficher.getDate("date_visite"));
				return visite;
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
	
	public Visite findByP(int id_produit) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM visite INNER utilisateur ON visite.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON visite.fk_id_produit=produit.id_produit"
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

				Visite visite = new Visite(afficher.getInt("id_visite"), produit, utilisateur, afficher.getDate("date_visite"));
				return visite;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id_produit + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Visite findByU(int id_utilisateur) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM visite INNER utilisateur ON visite.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON visite.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_utilisateur=?");
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

				Visite visite = new Visite(afficher.getInt("id_visite"), produit, utilisateur, afficher.getDate("date_visite"));
				return visite;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec une id_sous_categorie="+id_utilisateur + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}
