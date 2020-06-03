package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {	
		
		public static Connection getConectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10344949","sql10344949","L8XgU36q7r");			
		    return conexao;
		} catch (Exception e) {
			System.out.print("Falha no Banco de Dados");
			return null;
		}
	}

}
