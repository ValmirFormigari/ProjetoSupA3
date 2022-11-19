package br.com.Usuario.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.Usuario.factory.ConnectionFactory;
import br.com.Usuario.model.Usuario;


public class UsuarioDAO {
	
	public void save(Usuario usuario) {
		
		String sql = "INSERT INTO u01(u01_cpf,u01_nome,u01_nasc,u01_funcao,u01_senha) VALUES(?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, usuario.getU01_cpf());
			pstm.setString(2, usuario.getU01_nome());
			pstm.setDate(3, new Date(usuario.getU01_data_nasc().getTime()));
			pstm.setString(4, usuario.getU01_funcao());
			pstm.setString(5, usuario.getU01_senha());
			
			pstm.execute();
			
			} catch (Exception e) { 
				e.printStackTrace();
			}finally {
				
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		
	}
}
