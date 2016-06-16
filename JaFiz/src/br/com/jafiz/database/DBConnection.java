package br.com.jafiz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

		public static Connection getConnection(){
			Connection dbcon = null;
			try {
				Class.forName("org.postgresql.Driver");
				dbcon = DriverManager.getConnection("database:postgresql://localhost:5432/JaFiz","postgres","stocker@root");
				System.out.println("Banco de dados Conectado!");
			} catch (SQLException e) {
				System.out.println("Erro de Conexao: "+e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("Erro Driver: "+e.getMessage());
			}
			return dbcon;
		}
}
