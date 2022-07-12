package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import connection.Database;
import model.Utilisateur;

public class UtilisateurDao implements IDAO<Utilisateur>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Utilisateur utilisateur) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO utilisateur(nom,prenom,date_inscription,email,mot_de_passe) VALUES (?,?,now(),?,Password(?))");
			statement.setString(1,utilisateur.getNom());
			statement.setString(2,utilisateur.getPrenom());
			statement.setString(3,utilisateur.getEmail());
			statement.setString(4,utilisateur.getMot_de_passe());
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
	public ArrayList<Utilisateur> read() {
		ResultSet afficher;
		ArrayList<Utilisateur> ListUtilisateur= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM utilisateur");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Utilisateur utilisateur=new Utilisateur(afficher.getInt("id_utilisateur"),afficher.getString("nom"),afficher.getString("prenom"),afficher.getDate("date_inscription"),afficher.getString("email"),afficher.getString("mot_de_passe"));
				ListUtilisateur.add(utilisateur);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListUtilisateur;
	}
	
	public Utilisateur update(String nom,String prenom,String email,String mdp,int id) {
		Utilisateur utilisateur=null;
		if(findById(id)!=null) {
			utilisateur=findById(id);
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE utilisateur SET nom=?,prenom=?,email,mot_de_passe=PASSWORD(?) WHERE id_utilisateur=?");
				statement.setString(1,nom);
				statement.setString(2,prenom);
				statement.setString(3,email);
				statement.setString(4,mdp);
				statement.setInt(5,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setMot_de_passe(mdp);
			return utilisateur;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}
	
	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM utilisateur WHERE id_utilisateur=?");
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
	
	public Utilisateur findByEmail(String email) {
		ResultSet afficher=null;
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateur WHERE email LIKE ?");
			statement.setString(1,email);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String nom = afficher.getString("nom");
				String prenom = afficher.getString("prenom");
				Date date = afficher.getDate("date_inscription");
				String mail = afficher.getString("email");
				String mdp = afficher.getString("mot_de_passe");
				Utilisateur utilisateur= new Utilisateur(nom,prenom,date,mail,mdp);
				return utilisateur;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(email+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	@Override
	public Utilisateur findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM utilisateur WHERE id_utilisateur=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String nom = afficher.getString("nom");
				String prenom = afficher.getString("prenom");
				Date date = afficher.getDate("date_inscription");
				String mail = afficher.getString("email");
				String mdp = afficher.getString("mot_de_passe");
				Utilisateur utilisateur= new Utilisateur(nom,prenom,date,mail,mdp);
				return utilisateur;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

}
