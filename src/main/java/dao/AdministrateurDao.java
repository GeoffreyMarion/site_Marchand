package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Administrateur;

public class AdministrateurDao implements IDAO<Administrateur>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Administrateur administrateur) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO administrateur(nom,email,mot_de_passe,privileges) VALUES (?,?,Password(?),?)");
			statement.setString(1,administrateur.getNom());
			statement.setString(2,administrateur.getEmail());
			statement.setString(3,administrateur.getMot_de_passe());
			statement.setString(4,administrateur.getPrivileges());
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
	public ArrayList<Administrateur> read() {
		ResultSet afficher;
		ArrayList<Administrateur> ListAdministrateur = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM administrateur");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Administrateur administrateur = new Administrateur(afficher.getInt("id_administrateur"), afficher.getString("nom"),
						afficher.getString("email"), afficher.getString("mot_de_passe"), afficher.getString("privileges"));
				ListAdministrateur.add(administrateur);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListAdministrateur;
	}
	
	public Administrateur update(String nom, String email, String mot_de_passe, String privileges, int id) {
		Administrateur administrateur = null;
		if (findById(id) != null) {
			administrateur = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE administrateur SET nom=?,email=?,mot_de_passe=Password(?),privileges=? WHERE id_administrateur=?");
				statement.setString(1, nom);
				statement.setString(2, email);
				statement.setString(3, mot_de_passe);
				statement.setString(4, privileges);
				statement.setInt(5, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			administrateur.setNom(nom);
			administrateur.setEmail(email);
			administrateur.setMot_de_passe(mot_de_passe);
			administrateur.setPrivileges(privileges);
			return administrateur;
		} else {
			System.out.println("Update non fait id non présent dans la base");
		}
		return null;
	}
	
	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM administrateur WHERE id_administrateur=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove du contact id=" + id + " fait\n----------------");
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
	public Administrateur findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM administrateur WHERE id_administrateur=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String nom = afficher.getString("nom");
				String email = afficher.getString("email");
				String mot_de_passe = afficher.getString("mot_de_passe");
				String privileges = afficher.getString("privileges");
				Administrateur administrateur= new Administrateur(id,nom,email,mot_de_passe,privileges);
				return administrateur;
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


