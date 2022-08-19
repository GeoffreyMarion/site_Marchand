package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Adresse_livraison;
import model.Categorie;
import model.Commande;
import model.Details_commande;
import model.Produit;
import model.Sous_categorie;
import model.Utilisateur;

public class Details_commandeDao implements IDAO<Details_commande> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Details_commande details_commande) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO details_commande(fk_id_commande,fk_produit,quantite,prix) VALUES (?,?,?,?)");
			statement.setInt(1, details_commande.getCommande().getId_commande());
			statement.setInt(2, details_commande.getProduit().getId_produit());
			statement.setInt(3, details_commande.getQuantite());
			statement.setFloat(4, details_commande.getPrix());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Details_commande> read() {
		ResultSet afficher;
		ArrayList<Details_commande> ListDetails_commande = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM details_commande INNER JOIN commande ON details_commande.fk_id_commande=commande.id_commande "
							+ "INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse "
							+ "INNER JOIN produit ON details_commande.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
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

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Details_commande details_commande = new Details_commande(afficher.getInt("id_details_commande"),
						commande, produit, afficher.getInt("quantite"), afficher.getFloat("prix"));
				ListDetails_commande.add(details_commande);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListDetails_commande;
	}

	public Details_commande update(Commande commande, Produit produit, int quantite, Float prix,int id) {
		Details_commande details_commande = null;
		if (findById(id) != null) {
			details_commande = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE details_commande SET fk_id_commande=?,fk_id_roduit=?,quantite=?,prix=? WHERE id_details_commande=?");
				statement.setInt(1, commande.getId_commande());
				statement.setInt(2, produit.getId_produit());
				statement.setInt(3, quantite);
				statement.setFloat(4, prix);
				statement.setInt(5, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			details_commande.setCommande(commande);
			details_commande.setProduit(produit);
			details_commande.setQuantite(quantite);
			details_commande.setPrix(prix);
			return details_commande;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM details_commande WHERE id_details_commande=?");
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
	public Details_commande findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM details_commande INNER JOIN commande ON details_commande.fk_id_commande=commande.id_commande "
							+ "INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse "
							+ "INNER JOIN produit ON details_commande.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_details_commande=?");
			statement.setInt(1, id);
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

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Details_commande details_commande = new Details_commande(id, commande, produit,
						afficher.getInt("quantite"), afficher.getFloat("prix"));
				return details_commande;
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
	
	public Details_commande findByC(int id_commande) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM details_commande INNER JOIN commande ON details_commande.fk_id_commande=commande.id_commande "
							+ "INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse "
							+ "INNER JOIN produit ON details_commande.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_commande=?");
			statement.setInt(1, id_commande);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));
				Adresse_livraison adresse_livraison = new Adresse_livraison(afficher.getInt("id_adresse"), utilisateur,
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				Commande commande = new Commande(id_commande, utilisateur, afficher.getDate("date"),
						afficher.getInt("total"), adresse_livraison, afficher.getInt("etat"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Details_commande details_commande = new Details_commande(afficher.getInt("id_details_commande"),
						commande, produit, afficher.getInt("quantite"), afficher.getFloat("prix"));
				return details_commande;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id_commande + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Details_commande findByP(int id_produit) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM details_commande INNER JOIN commande ON details_commande.fk_id_commande=commande.id_commande "
							+ "INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse "
							+ "INNER JOIN produit ON details_commande.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_produit=?");
			statement.setInt(1, id_produit);
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

				Produit produit = new Produit(id_produit, afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Details_commande details_commande = new Details_commande(afficher.getInt("id_details_commande"),
						commande, produit, afficher.getInt("quantite"), afficher.getFloat("prix"));
				return details_commande;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println("Aucun produit avec une id_sous_categorie="+id_produit + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Details_commande> findByMot(String input) {
		ResultSet afficher;
		ArrayList<Details_commande> ListDetails_commande = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM details_commande INNER JOIN commande ON details_commande.fk_id_commande=commande.id_commande "
							+ "INNER JOIN utilisateur ON commande.fk_id_utilisateur=utilisateur.id_utilisateur "
							+ "INNER JOIN adresse_livraison ON commande.fk_id_adresse=adresse_livraison.id_adresse "
							+ "INNER JOIN produit ON details_commande.fk_id_produit=produit.id_produit "
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie "
							+ "WHERE utilisateur.prenom LIKE ? OR utilisateur.nom LIKE ? OR produit.titre_produit LIKE ?");
			statement.setString(1,"%" + input + "%");
			statement.setString(2,"%" + input + "%");
			statement.setString(3,"%" + input + "%");
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

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Details_commande details_commande = new Details_commande(afficher.getInt("id_details_commande"),
						commande, produit, afficher.getInt("quantite"), afficher.getFloat("prix"));
				ListDetails_commande.add(details_commande);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListDetails_commande;
	}
}
