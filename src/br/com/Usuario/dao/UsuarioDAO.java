package br.com.Usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.Usuario.factory.ConnectionFactory;


public class UsuarioDAO {
	
	public void save(String getU01_cpf, String U01_nome, String U01_funcao, String getU01_senha) {
		
		String sql = "INSERT INTO u01(u01_cpf,u01_nome,u01_funcao,u01_senha) VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, getU01_cpf);
			pstm.setString(2,U01_nome);
			pstm.setString(3,U01_funcao);
			pstm.setString(4,getU01_senha);
			
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
