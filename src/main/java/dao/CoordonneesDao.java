package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Coordonnees;

public class CoordonneesDao implements IDAO<Coordonnees>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Coordonnees coordonnees) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO coordonnees(nom,adresse,telephone,email,logo) VALUES (?,?,?,?,?)");
			statement.setString(1,coordonnees.getNom());
			statement.setString(2,coordonnees.getAdresse());
			statement.setString(3,coordonnees.getTelephone());
			statement.setString(4,coordonnees.getEmail());
			statement.setString(5,coordonnees.getLogo());
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
	public ArrayList<Coordonnees> read() {
		ResultSet afficher;
		ArrayList<Coordonnees> ListCoordonnees = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM coordonnees");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Coordonnees coordonnees = new Coordonnees(afficher.getInt("id_coordonnees"), afficher.getString("nom"),
						afficher.getString("adresse"), afficher.getString("telephone"), afficher.getString("email"),
						afficher.getString("logo"));
				ListCoordonnees.add(coordonnees);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCoordonnees;
	}
	
	public Coordonnees update(String nom, String adresse, String telephone, String email, String logo,int id) {
		Coordonnees coordonnees = null;
		if (findById(id) != null) {
			coordonnees = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE coordonnees SET nom=?,adresse=?,telephone=?,email=?,logo=? WHERE id_coordonnees=?");
				statement.setString(1, nom);
				statement.setString(2, adresse);
				statement.setString(3, telephone);
				statement.setString(4, email);
				statement.setString(5, logo);
				statement.setInt(6, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			coordonnees.setNom(nom);
			coordonnees.setAdresse(adresse);
			coordonnees.setTelephone(telephone);
			coordonnees.setEmail(email);
			coordonnees.setLogo(logo);
			return coordonnees;
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
						.prepareStatement("DELETE FROM coordonnees WHERE id_coordonnees=?");
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
	public Coordonnees findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM coordonnees WHERE id_coordonnees=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String nom = afficher.getString("nom");
				String adresse = afficher.getString("adresse");
				String telephone = afficher.getString("telephone");
				String email = afficher.getString("email");
				String logo = afficher.getString("logo");
				Coordonnees coordonnees= new Coordonnees(id,nom,adresse,telephone,email,logo);
				return coordonnees;
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


