package bj.highfive.user_management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bj.highfive.user_management.bean.User;

public class UserDao {
/*
 * 1- enrégistrer le  pilote(driver)
 * 2- récupérer l'objet de connection à la BDD
 * 3- créer la requête
 * 4- exécuter la requête
 * 5- fermer la connection
 * 
 * **/
	
	protected static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// database est de type mysql
			//synthaxe de connexion 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_app", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static boolean createUser(User user) {
		
		boolean result = false;
		// Etape : récupération de l'objet de connexion
		Connection connection = getConnection();
		
		//Etape: Créer la requête
		try {
		//preparation de la requette avec l'objet PreparedStatement 
			PreparedStatement ps = connection.
					prepareStatement("INSERT INTO users (`name`,`email`,`city`) VALUES(?,?,?);");
		//grace à la methode setString ou setInt et autre j'affecte les valeur à la requette 
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getCity());
			result = ps.execute();
			//Etape femerture  de la requette
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	/***
	 * 
	 * Méthode qui se connecte à la BDD au travers de l'interface DriverManager
	 * get(dsn, username,password)
	 * dsn = data source name
	 * $dsn = "mysql:host=loclhost;dbname=user_app;port=3306;charset=UTF-8";
	 * ex php: $conn = new PDO("$dsn, "root", "")
	 * 
	 * 
	 * dsn mysql java ==> "jdbc:mysql://localhost:port/nom_de_la _BDD"
	 * 
	 * ****/
	/*
	 * 1- Create => cré une ressource (createUser)
	 * 2- Read => lire une ressource (getUserById | getAllUsers)
	 * 3- Update => mise à jour d'une ressource (updateUser)
	 * 4- Delete => supprimer une ressource (deleteUser)
	 * 
	 * **/	
	public static List<User> getAllUsers(){
		List<User> userList= new ArrayList<User>(); 
		//Récuperation de l'objet de connection
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users;");
		//Exécuter la requete
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				User u = new User();
				u.setId(results.getInt("id"));
				u.setName(results.getString("name"));
				u.setEmail(results.getString("email"));
				u.setCity(results.getString("city"));
				
				userList.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList ;
	}

}
