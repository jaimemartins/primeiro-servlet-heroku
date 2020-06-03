package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDao {
	
	public boolean incluir (Usuario usuario) {
		
		Connection conexao = Conexao.getConectar();		
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement("insert into usuario (email) values (?) ");
			pst.setString(1, usuario.getEmail());
			pst.execute();				
			pst.close();
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
}
