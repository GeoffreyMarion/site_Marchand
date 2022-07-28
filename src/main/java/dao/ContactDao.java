package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;
import model.Contact;
import model.Utilisateur;

public class ContactDao implements IDAO<Contact>{
	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Contact contact) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO contact(sujet,message,etat_contact,fk_id_utilisateur,email) VALUES (?,?,?,?,?)");
			statement.setString(1,contact.getSujet());
			statement.setString(2,contact.getMessage());
			statement.setBoolean(3,contact.isEtat_contact());
			statement.setInt(4,contact.getUtilisateur().getId_utilisateur());
			statement.setString(5,contact.getEmail());
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
	public ArrayList<Contact> read() {
		ResultSet afficher;
		ArrayList<Contact> ListContact = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT* FROM contact INNER JOIN utilisateur ON contact.fk_id_utilisateur=utilisateur.id_utilisateur");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Contact contact = new Contact(afficher.getInt("id_contact"), afficher.getString("sujet"),
						afficher.getString("message"), afficher.getBoolean("etat_contact"),
						new Utilisateur(afficher.getInt("id_utilisateur"), afficher.getString("nom"),
								afficher.getString("prenom"), afficher.getDate("date_inscription"),
								afficher.getString("email"), afficher.getString("mot_de_passe")),
						afficher.getString("email"));
				ListContact.add(contact);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListContact;
	}
	
	public Contact update(String sujet, String message, boolean etat_contact,Utilisateur utilisateur, String email, int id) {
		Contact contact = null;
		if (findById(id) != null) {
			contact = findById(id);
			try {
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE contact SET sujet=?,message=?,etat_contact=?,fk_id_utilisateur=?,email=? WHERE id_contact=?");
				statement.setString(1, sujet);
				statement.setString(2, message);
				statement.setBoolean(3, etat_contact);
				statement.setInt(4, utilisateur.getId_utilisateur());
				statement.setString(5, email);
				statement.setInt(6, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			contact.setSujet(sujet);
			contact.setMessage(message);
			contact.setEtat_contact(etat_contact);
			contact.setEmail(email);
			return contact;
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
						.prepareStatement("DELETE FROM contact WHERE id_contact=?");
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
	public Contact findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM contact INNER JOIN utilisateur ON recherche.fk_id_utilisateur=utilisateur.id_utilisateur WHERE id_recherche=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String sujet = afficher.getString("sujet");
				String message = afficher.getString("message");
				boolean etat_contact = afficher.getBoolean("etat_contact");
				Utilisateur utilisateur = new Utilisateur(afficher.getInt("id_utilisateur"),afficher.getString("nom"),afficher.getString("prenom"),afficher.getDate("date_inscription"),afficher.getString("email"),afficher.getString("mot_de_passe"));
				String email = afficher.getString("email");
				Contact contact= new Contact(id,sujet,message,etat_contact,utilisateur,email);
				return contact;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public Contact findByIdU(int id_utilisateur) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM contact INNER JOIN utilisateur ON contact.fk_id_utilisateur=utilisateur.id_utilisateur WHERE id_utilisateur=?");
			statement.setInt(1,id_utilisateur);
			afficher =statement.executeQuery();
			while (afficher.next()) {
				int id = afficher.getInt("id_recherche");
				String sujet = afficher.getString("sujet");
				String message = afficher.getString("message");
				boolean etat_contact = afficher.getBoolean("etat_contact");
				Utilisateur utilisateur = new Utilisateur(id_utilisateur,afficher.getString("nom"),afficher.getString("prenom"),afficher.getDate("date_inscription"),afficher.getString("email"),afficher.getString("mot_de_passe"));
				String email = afficher.getString("email");
				Contact contact= new Contact(id,sujet,message,etat_contact,utilisateur,email);
				return contact;
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
