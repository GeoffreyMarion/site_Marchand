package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import connection.Database;
import model.Recherche;
import model.Utilisateur;

public class RechercheDao implements IDAO<Recherche>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Recherche recherche) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO recherche(fk_id_utilisateur,mot_cle,date_recherche) VALUES (?,?,now())");
			statement.setInt(1,recherche.getUtilisateur().getId_utilisateur());
			statement.setString(2,recherche.getMot_cle());
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
	public ArrayList<Recherche> read() {
		ResultSet afficher;
		ArrayList<Recherche> ListRecherche = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM recherche INNER JOIN utilisateur ON recherche.fk_id_utilisateur=utilisateur.id_utilisateur");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Recherche recherche = new Recherche(afficher.getInt("id_recherche"),
						new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
								afficher.getString("prenom"), afficher.getDate("date_inscription"),
								afficher.getString("email"), afficher.getString("mot_de_passe")),
						afficher.getString("mot_cle"), afficher.getDate("date_recherche"));
				ListRecherche.add(recherche);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListRecherche;
	}
	
	public Recherche update(Utilisateur utilisateur,String mot_cle,int id) {
		Recherche recherche=null;
		if(findById(id)!=null) {
			recherche=findById(id);
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE recherche SET fk_id_utilisateur=?,mot_cle=? WHERE id_recherche=?");
				statement.setInt(1, utilisateur.getId_utilisateur());
				statement.setString(2,mot_cle);
				statement.setInt(3,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			recherche.setMot_cle(mot_cle);
			return recherche;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}
	
	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM recherche WHERE id_recherche=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove de la recherche id=" + id + " fait\n----------------");
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
	public Recherche findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM recherche INNER JOIN utilisateur ON recherche.fk_id_utilisateur=utilisateur.id_utilisateur WHERE id_recherche=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
						afficher.getString("prenom"), afficher.getDate("date_inscription"), afficher.getString("email"),
						afficher.getString("mot_de_passe"));
				String mot_cle = afficher.getString("mot_cle");
				Date date = afficher.getDate("date_recherche");
				Recherche recherche = new Recherche(id, utilisateur, mot_cle, date);
				return recherche;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Recherche findByIdU(int id_utilisateur) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM recherche INNER JOIN utilisateur ON recherche.fk_id_utilisateur=utilisateur.id_utilisateur WHERE fk_id_utilisateur=?");
			statement.setInt(1,id_utilisateur);
			afficher =statement.executeQuery();
			while (afficher.next()) {
				int id = afficher.getInt("id_recherche");
				Utilisateur utilisateur = new Utilisateur(id_utilisateur,afficher.getString("nom"),afficher.getString("prenom"),afficher.getDate("date_inscription"),afficher.getString("email"),afficher.getString("mot_de_passe"));
				String mot_cle = afficher.getString("mot_cle");
				java.sql.Date date = afficher.getDate("date_recherche");
				Recherche recherche= new Recherche(id,utilisateur,mot_cle,date);
				return recherche;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id_utilisateur+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}
