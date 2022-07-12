package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;

public class CategorieDao implements IDAO<Categorie>{
Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Categorie categorie) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO categorie(titre) VALUES (?)");
			statement.setString(1,categorie.getTitre());
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
	public ArrayList<Categorie> read() {
		ResultSet afficher;
		ArrayList<Categorie> ListCategorie= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM categorie");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Categorie categorie=new Categorie(afficher.getInt("id_categorie"),afficher.getString("titre"));
				ListCategorie.add(categorie);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCategorie;
	}
	
	public Categorie update(String titre,int id) {
		Categorie categorie=null;
		if(findById(id)!=null) {
			categorie=findById(id);
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE categorie SET titre=? WHERE id_categorie=?");
				statement.setString(1,titre);
				statement.setInt(2,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			categorie.setTitre(titre);
			return categorie;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}
	
	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM categorie WHERE id_categorie=?");
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
	public Categorie findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM categorie WHERE id_categorie=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String titre = afficher.getString("titre");
				Categorie categorie= new Categorie(id,titre);
				return categorie;
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
