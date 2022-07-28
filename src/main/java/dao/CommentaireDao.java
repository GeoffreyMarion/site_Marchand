package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;
import model.Commentaire;
import model.Produit;
import model.Sous_categorie;
import model.Utilisateur;

public class CommentaireDao implements IDAO<Commentaire> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Commentaire commentaire) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Insert INTO commentaire(commentaire,note,fk_id_produit,fk_id_utilisateur) VALUES (?,?,?,?)");
			statement.setString(1, commentaire.getCommentaire());
			statement.setInt(2, commentaire.getNote());
			statement.setInt(3, commentaire.getProduit().getId_produit());
			statement.setInt(4, commentaire.getUtilisateur().getId_utilisateur());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Commentaire> read() {
		ResultSet afficher;
		ArrayList<Commentaire> ListCommentaire = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commentaire INNER utilisateur ON commentaire.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON commentaire.fk_id_produit=produit.id_produit"
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

				Commentaire commentaire = new Commentaire(afficher.getInt("id_commentaire"),
						afficher.getString("commentaire"), afficher.getInt("note"), produit, utilisateur);
				ListCommentaire.add(commentaire);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCommentaire;
	}

	public Commentaire update(String commentaire,int note,Produit produit, Utilisateur utilisateur,int id) {
		Commentaire commentaire_ = null;
		if (findById(id) != null) {
			commentaire_ = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE commentaire SET commentaire=?,note=?,fk_id_produit=?,fk_id_utilisateur=? WHERE id_commentaire=?");
				statement.setString(1, commentaire_.getCommentaire());
				statement.setInt(2, commentaire_.getNote());
				statement.setInt(3, produit.getId_produit());
				statement.setInt(4, utilisateur.getId_utilisateur());
				statement.setInt(5, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			commentaire_.setCommentaire(commentaire);
			commentaire_.setNote(note);
			commentaire_.setProduit(produit);
			commentaire_.setUtilisateur(utilisateur);
			return commentaire_;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM commentaire WHERE id_commentaire=?");
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
	public Commentaire findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commentaire INNER utilisateur ON commentaire.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON commentaire.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_commentaire=?");
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

				Commentaire commentaire = new Commentaire(id, afficher.getString("commentaire"),
						afficher.getInt("note"), produit, utilisateur);
				return commentaire;
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
	
	public ArrayList<Commentaire> findByP(int id_produit) {
		ResultSet afficher = null;
		ArrayList<Commentaire> ListCommentaire = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commentaire INNER utilisateur ON commentaire.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON commentaire.fk_id_produit=produit.id_produit"
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

				Commentaire commentaire = new Commentaire(afficher.getInt("id_commentaire"), afficher.getString("commentaire"),
						afficher.getInt("note"), produit, utilisateur);
				ListCommentaire.add(commentaire);
			}
			return ListCommentaire;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id_produit + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Commentaire findByU(int id_utilisateur) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM commentaire INNER utilisateur ON commentaire.fk_id_utilisateur=utilisateur.id_utilisateur"
							+ "INNER JOIN produit ON commentaire.fk_id_produit=produit.id_produit"
							+ "INNER JOIN sous_categorie ON produit.fk_id_sous_categorie=sous_categorie.id_sous_categorie "
							+ "INNER JOIN categorie ON sous_categorie.fk_id_categorie=categorie.id_categorie WHERE id_produit=?");
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

				Commentaire commentaire = new Commentaire(afficher.getInt("id_commentaire"), afficher.getString("commentaire"),
						afficher.getInt("note"), produit, utilisateur);
				return commentaire;
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
