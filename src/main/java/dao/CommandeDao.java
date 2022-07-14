package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Adresse_livraison;
import model.Commande;
import model.Utilisateur;

public class CommandeDao implements IDAO<Commande> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Commande commande) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO commande(fk_id_utilisateur,date,total,fk_id_adresse,etat) VALUES (?,now(),?,?,?)");
			statement.setInt(1, commande.getUtilisateur().getId_utilisateur());
			statement.setDouble(2, commande.getTotal());
			statement.setInt(3, commande.getAdresse_livraison().getId_adresse());
			statement.setInt(4, commande.getEtat());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Commande> read() {
		ResultSet afficher;
		ArrayList<Commande> ListCommande = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commande INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));
				Adresse_livraison adresse_livraison = new Adresse_livraison(afficher.getInt("id_adresse"), utilisateur,
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				Commande commande = new Commande(afficher.getInt("id_commande"), utilisateur, afficher.getDate("date"),
						afficher.getInt("total"), adresse_livraison, afficher.getInt("etat"));
				ListCommande.add(commande);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCommande;
	}

	public Commande update(Utilisateur utilisateur, float total, Adresse_livraison adresse, int etat,int id) {
		Commande commande = null;
		if (findById(id) != null) {
			commande = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE commande SET fk_id_utilisateur=?,total=?,fk_id_adresse=?,etat=? WHERE id_commande=?");
				statement.setInt(1, utilisateur.getId_utilisateur());
				statement.setDouble(2, total);
				statement.setInt(3, adresse.getId_adresse());
				statement.setInt(4, etat);
				statement.setInt(5, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			commande.setUtilisateur(utilisateur);
			commande.setTotal(total);
			commande.setAdresse_livraison(adresse);
			commande.setEtat(etat);
			return commande;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM commande WHERE id_commande=?");
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
	public Commande findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commande INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse WHERE id_commande=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));
				Adresse_livraison adresse_livraison = new Adresse_livraison(afficher.getInt("id_adresse"), utilisateur,
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				Commande commande = new Commande(id, utilisateur, afficher.getDate("date"),
						afficher.getInt("total"), adresse_livraison, afficher.getInt("etat"));
				return commande;
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
	
	public Commande findByU(int id_utilisateur) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commande INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_utilisateur=?");
			statement.setInt(1, id_utilisateur);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(id_utilisateur, afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));
				Adresse_livraison adresse_livraison = new Adresse_livraison(afficher.getInt("id_adresse"), utilisateur,
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				Commande commande = new Commande(afficher.getInt("id_commande"), utilisateur, afficher.getDate("date"),
						afficher.getInt("total"), adresse_livraison, afficher.getInt("etat"));
				return commande;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id_utilisateur + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Commande findByA(int id_adresse) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commande INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_adresse=?");
			statement.setInt(1, id_adresse);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));
				Adresse_livraison adresse_livraison = new Adresse_livraison(id_adresse, utilisateur,
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				Commande commande = new Commande(afficher.getInt("id_commande"), utilisateur, afficher.getDate("date"),
						afficher.getInt("total"), adresse_livraison, afficher.getInt("etat"));
				return commande;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec une id_sous_categorie="+id_adresse + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}


