package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Adresse_livraison;
import model.Utilisateur;

public class Adresse_livraisonDao implements IDAO<Adresse_livraison>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Adresse_livraison adresse_livraison) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO adresse_livraison(fk_id_utilisateur,adresse,code_postal,ville,pays) VALUES (?,?,?,?,?)");
			statement.setInt(1,adresse_livraison.getUtilisateur().getId_utilisateur());
			statement.setString(2,adresse_livraison.getAdresse());
			statement.setInt(3,adresse_livraison.getCode_postal());
			statement.setString(4,adresse_livraison.getVille());
			statement.setString(5,adresse_livraison.getPays());
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
	public ArrayList<Adresse_livraison> read() {
		ResultSet afficher;
		ArrayList<Adresse_livraison> ListAdresse = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM adresse_livraison INNER JOIN utilisateur ON adresse_livraison.fk_id_utilisateur=utilisateur.id_utilisateur");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Adresse_livraison adresse_livraison = new Adresse_livraison(afficher.getInt("id_adresse"),
						new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
								afficher.getString("prenom"), afficher.getDate("date_inscription"),
								afficher.getString("email"), afficher.getString("mot_de_passe")),
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				ListAdresse.add(adresse_livraison);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListAdresse;
	}
	
	public Adresse_livraison update(Utilisateur utilisateur,String adresse,int code_postal,String ville,String pays,int id) {
		Adresse_livraison adresse_livraison=null;
		if(findById(id)!=null) {
			adresse_livraison=findById(id);
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE adresse_livraison SET fk_id_utilisateur=?,adresse=?,code_postal=?,ville=?,pays=? WHERE id_adresse=?");
				statement.setInt(1, utilisateur.getId_utilisateur());
				statement.setString(2,adresse);
				statement.setInt(3,code_postal);
				statement.setString(4,ville);
				statement.setString(5,pays);
				statement.setInt(6,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			adresse_livraison.setAdresse(adresse);
			adresse_livraison.setCode_postal(code_postal);
			adresse_livraison.setVille(ville);
			adresse_livraison.setPays(pays);
			return adresse_livraison;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}
	
	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM adresse_livraison WHERE id_adresse=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove de l'Adresse_livraison id=" + id + " fait\n----------------");
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
	public Adresse_livraison findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM adresse_livraison INNER JOIN utilisateur ON adresse_livraison.fk_id_utilisateur=utilisateur.id_utilisateur WHERE id_adresse=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"),afficher.getString("nom"),afficher.getString("prenom"),afficher.getDate("date_inscription"),afficher.getString("email"),afficher.getString("mot_de_passe"));
				String adresse = afficher.getString("adresse");
				int code_postal = afficher.getInt("code_postal");
				String ville = afficher.getString("ville");
				String pays = afficher.getString("pays");
				Adresse_livraison adresse_livraison= new Adresse_livraison(id,utilisateur,adresse,code_postal,ville,pays);
				return adresse_livraison;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Adresse_livraison> findByIdU(int id_utilisateur) {
		ResultSet afficher=null;
		ArrayList<Adresse_livraison> ListAdresse = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM adresse_livraison INNER JOIN utilisateur ON adresse_livraison.fk_id_utilisateur=utilisateur.id_utilisateur WHERE id_utilisateur=?");
			statement.setInt(1,id_utilisateur);
			afficher =statement.executeQuery();
			while (afficher.next()) {
				int id = afficher.getInt("id_adresse");
				Utilisateur utilisateur = new Utilisateur(id_utilisateur,afficher.getString("nom"),afficher.getString("prenom"),afficher.getDate("date_inscription"),afficher.getString("email"),afficher.getString("mot_de_passe"));
				String adresse = afficher.getString("adresse");
				int code_postal = afficher.getInt("code_postal");
				String ville = afficher.getString("ville");
				String pays = afficher.getString("pays");
				Adresse_livraison adresse_liv= new Adresse_livraison(id,utilisateur,adresse,code_postal,ville,pays);
				ListAdresse.add(adresse_liv);
			}
			return ListAdresse;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id_utilisateur+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Adresse_livraison> FindByMot(String input) {
		ResultSet afficher;
		ArrayList<Adresse_livraison> ListAdresse = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM adresse_livraison INNER JOIN utilisateur ON adresse_livraison.fk_id_utilisateur=utilisateur.id_utilisateur "
					+ "WHERE utilisateur.prenom LIKE ? OR utilisateur.nom LIKE ? OR adresse LIKE ? OR ville LIKE ? OR pays LIKE ?");
			statement.setString(1,"%" + input + "%");
			statement.setString(2,"%" + input + "%");
			statement.setString(3,"%" + input + "%");
			statement.setString(4,"%" + input + "%");
			statement.setString(5,"%" + input + "%");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Adresse_livraison adresse_livraison = new Adresse_livraison(afficher.getInt("id_adresse"),
						new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
								afficher.getString("prenom"), afficher.getDate("date_inscription"),
								afficher.getString("email"), afficher.getString("mot_de_passe")),
						afficher.getString("adresse"), afficher.getInt("code_postal"), afficher.getString("ville"),
						afficher.getString("pays"));
				ListAdresse.add(adresse_livraison);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListAdresse;
	}
}
