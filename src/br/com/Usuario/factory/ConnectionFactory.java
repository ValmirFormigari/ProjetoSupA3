package br.com.Usuario.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSORD	= "";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/trabalhoa3";
	
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSORD);
		
		return connection; 
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conexao obtida com sucesso!");
			con.close();
		}
	}

}
