package br.com.sinep.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/sinep", "postgres", "4525");
			return con;
		} catch (Exception ex) {
			System.out.println("BancoDeDados.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}