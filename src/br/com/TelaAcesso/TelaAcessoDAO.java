package br.com.TelaAcesso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import br.com.Usuario.Aplicacao.JanelaUsuario;
import br.com.Usuario.factory.ConnectionFactory;
import br.com.janelachamadosclientes.JanelaChamadosDeUsuarios;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class TelaAcessoDAO {

	public JFrame frmLogin;
	private JTextField TFUsuario;
	private JPasswordField TFSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcessoDAO window = new TelaAcessoDAO();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAcessoDAO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBackground(SystemColor.textHighlight);
		frmLogin.setForeground(Color.WHITE);
		frmLogin.setResizable(false);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 530, 330);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(89, 76, 99, 37);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblSenh = new JLabel("SENHA");
		lblSenh.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblSenh.setBounds(89, 139, 99, 37);
		frmLogin.getContentPane().add(lblSenh);
		
		TFUsuario = new JTextField();
		TFUsuario.setBounds(198, 78, 149, 37);
		frmLogin.getContentPane().add(TFUsuario);
		TFUsuario.setColumns(10);
		
		TFSenha = new JPasswordField();
		TFSenha.setBounds(198, 141, 149, 37);
		frmLogin.getContentPane().add(TFSenha);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Connection conn3 = null;
				
				PreparedStatement pstm3 = null;	
				
				
				
				try {
					String sql3 = "SELECT * FROM u01 WHERE u01_nome= ? and u01_senha= ?";
						
					conn3 = ConnectionFactory.createConnectionToMySQL();
					
					pstm3 = (PreparedStatement) conn3.prepareStatement(sql3);
					
					
					
					pstm3.setString(1, TFUsuario.getText());
					pstm3.setString(2, new String(TFSenha.getPassword()));
					
					
					
					Resultset rs = (Resultset) pstm3.executeQuery();
					
	
					
					if(((ResultSet) rs ).next()) {
						JanelaChamadosDeUsuarios cad_cha_us = new JanelaChamadosDeUsuarios();
						cad_cha_us.frame.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Esse usuario nao existe");
		

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(225, 210, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
	}
}
