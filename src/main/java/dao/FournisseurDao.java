package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Categorie;
import model.Fournisseur;

public class FournisseurDao implements IDAO<Fournisseur> {

	Connection connection = Database.getConnection();

	@Override
	public boolean create(Fournisseur fournisseur) {
				try {
					PreparedStatement statement = connection.prepareStatement("Insert INTO fournisseur(nom) VALUES (?)");
					statement.setString(1,fournisseur.getNom());
					statement.executeUpdate();
					return true;
					}
					catch (SQLException e){
						System.out.println("Fournisseur non créé");
						e.printStackTrace();
					}
		return false;
	}

	@Override
	public ArrayList<Fournisseur> read() {
		ResultSet afficher;
		ArrayList<Fournisseur> listeFournisseurs= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM fournisseur");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Fournisseur fournisseur=new Fournisseur(afficher.getInt("id_fournisseur"),afficher.getString("nom"));
				listeFournisseurs.add(fournisseur);
			}
		} catch (SQLException e) {
			System.out.println("Données/listeFournisseurs non lues");
			e.printStackTrace();
		}
		return listeFournisseurs;
	}

	@Override
	public boolean remove(int id) {
		if (findById(id) != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM fournisseur WHERE id_fournisseur=?");
				statement.setInt(1, id);
				statement.executeUpdate();
				System.out.println("Remove du fournisseur id=" + id + " fait\n----------------");
				return true;
			} catch (SQLException e) {
				System.out.println("Fournisseur not removed");
				e.printStackTrace();
			}
		} else {
			System.out.println("Fournisseur not removed, id absent from database");
		}
		return false;
	}

	@Override
	public Fournisseur findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM fournisseur WHERE id_fournisseur=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String nom = afficher.getString("nom");
				Fournisseur fournisseur= new Fournisseur(id,nom);
				return fournisseur;
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
