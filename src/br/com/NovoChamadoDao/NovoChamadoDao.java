package br.com.NovoChamadoDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.Usuario.factory.ConnectionFactory;

public class NovoChamadoDao {
public void save(String c01_u01_id, String c01_m01_id, String c01_assunto, String c01_descricao , String c01_comentario, String c01_data_abertura, String c01_prioridade, String c01_status) {
		
		String sql = "INSERT INTO c01(c01_u01_id, c01_m01_id,c01_assunto,c01_descricao,c01_comentario, c01_data_abertura,c01_prioridade, c01_status) VALUES(?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		 
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1,c01_u01_id);
			pstm.setString(2,c01_m01_id);
			pstm.setString(3,c01_assunto);
			pstm.setString(4,c01_descricao);
			pstm.setString(5,c01_comentario);
			pstm.setString(6,c01_data_abertura);
			pstm.setString(7,c01_prioridade);
			pstm.setString(8,c01_status);
			
			} catch (Exception e) { 
				e.printStackTrace();
			}finally {
				
				try {
					if(pstm!=null) {
						pstm.close();
				}
					if(conn!=null) {
						//conn.close();
						
					}
				}catch (Exception e) {
					e.printStackTrace();
			}
				
			}
		
	}
}
