package com.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static Connection connection;
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
                        
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/carbdd","root","");
			System.out.println("Connexion effecturer");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return connection;
	}

}
