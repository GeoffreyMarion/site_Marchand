package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Adresse_livraison;
import model.Categorie;
import model.Commande;
import model.Details_commande;
import model.Entree_en_stock;
import model.Fournisseur;
import model.Produit;
import model.Sous_categorie;
import model.Utilisateur;

public class Entree_en_stockDao implements IDAO<Entree_en_stock> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Entree_en_stock entreeEnStock) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO entree_en_stock(fk_id_fournisseur,fk_produit,date_entree_en_stock,quantite) VALUES (?,?,?,?)");
			statement.setInt(1, entreeEnStock.getFournisseur().getId_fournisseur());
			statement.setInt(2, entreeEnStock.getProduit().getId_produit());
			statement.setDate(3, (Date) entreeEnStock.getDate_entree_en_stock());
			statement.setInt(4, entreeEnStock.getQuantite());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Entree_en_stock> read() {
		ResultSet afficher;
		ArrayList<Entree_en_stock> listeEntreeEnStock = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM entree_en_stock INNER JOIN fournisseur ON entree_en_stock.fk_id_fournisseur=fournisseur.id_fournisseur "
							+ "INNER JOIN produit ON entree_en_stock.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Fournisseur fournisseur = new Fournisseur(afficher.getInt("id_fournisseur"),afficher.getString("nom"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));
				
						Entree_en_stock entreeEnStock = new Entree_en_stock(afficher.getInt("id_entree_en_stock"),
						fournisseur, produit, afficher.getDate("date_entree_en_stock"), afficher.getInt("quantite"));
				listeEntreeEnStock.add(entreeEnStock);
			}
		} catch (SQLException e) {
			System.out.println("Données / Liste d'entrees  non lues");
			e.printStackTrace();
		}
		return listeEntreeEnStock;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM entree_en_stock WHERE id_entree_en_stock=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove de l'entree en sotkc avec id=" + id + " fait\n----------------");
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
	public Entree_en_stock findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM entree_en_stock INNER JOIN fournisseur ON entree_en_stock.fk_id_fournisseur=fournissuer.id_fournisseur "
							+ "INNER JOIN produit ON entree_en_stock.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_entree_en_stock=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Fournisseur fournisseur = new Fournisseur(afficher.getInt("id_fournisseur"),afficher.getString("nom"));

				Produit produit = new Produit(afficher.getInt("id_produit"), afficher.getString("titre_produit"),
						afficher.getString("description"), afficher.getFloat("prix"), afficher.getString("image"),
						new Sous_categorie(afficher.getInt("id_sous_categorie"), afficher.getString("titre"),
								new Categorie(afficher.getInt("id_categorie"), afficher.getString("titre"))),
						afficher.getInt("stock"), afficher.getInt("stock_minimum"));

				Entree_en_stock entreeEnStock = new Entree_en_stock(id, fournisseur, produit,
						afficher.getDate("date_entree_en_stock"), afficher.getInt("quantite"));
				return entreeEnStock;
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
}
