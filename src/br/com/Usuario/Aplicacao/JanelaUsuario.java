package br.com.Usuario.Aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.Usuario.dao.UsuarioDAO;
import br.com.Usuario.factory.ConnectionFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Toolkit;
// Aula 6 de outubro mostra como gerar vinculo entra janelas 
//https://www.youtube.com/watch?v=XeBJGEZrbJw
public class JanelaUsuario {

	public JFrame frmCriarUsuario;
	private JTextField I_CPF;
	private JTextField I_Nome;
	private JTextField I_Funcao;
	private JTextField I_Senha;
	protected Object frame;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JTextField txtExcluir;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2;
	private JTextField textField_Busc;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaUsuario window = new JanelaUsuario();
					window.frmCriarUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCriarUsuario = new JFrame();
		frmCriarUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmCriarUsuario.getContentPane().setBackground(Color.WHITE);
		frmCriarUsuario.setForeground(Color.WHITE);
		frmCriarUsuario.setBackground(Color.WHITE);
		frmCriarUsuario.setTitle("Criar Usuario");
		frmCriarUsuario.setBounds(100, 100, 517, 410);
		frmCriarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCriarUsuario.getContentPane().setLayout(null);
		
		I_CPF = new JTextField();
		I_CPF.setBounds(190, 154, 183, 20);
		frmCriarUsuario.getContentPane().add(I_CPF);
		I_CPF.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuarioDao = new UsuarioDAO();
				//nao terminei esta parte (Integer.parseIn) por (Long.)
				usuarioDao.save(I_CPF.getText() ,I_Nome.getText(), I_Funcao.getText(),I_Senha.getText());
				
				JOptionPane.showMessageDialog(null,"Usuario incluido com sucesso");
				
			}
				
		});
		btnNewButton.setBounds(10, 337, 105, 23);
		frmCriarUsuario.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(143, 153, 37, 23);
		frmCriarUsuario.getContentPane().add(lblNewLabel);
		
		I_Nome = new JTextField();
		I_Nome.setBounds(190, 123, 183, 20);
		frmCriarUsuario.getContentPane().add(I_Nome);
		I_Nome.setColumns(10);
		
		I_Funcao = new JTextField();
		I_Funcao.setBounds(190, 188, 183, 20);
		frmCriarUsuario.getContentPane().add(I_Funcao);
		I_Funcao.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(143, 120, 37, 23);
		frmCriarUsuario.getContentPane().add(lblNome);
		
		JLabel lblFunc = new JLabel("Funcao");
		lblFunc.setBounds(143, 187, 43, 23);
		frmCriarUsuario.getContentPane().add(lblFunc);
		
		I_Senha = new JTextField();
		I_Senha.setColumns(10);
		I_Senha.setBounds(190, 222, 183, 20);
		frmCriarUsuario.getContentPane().add(I_Senha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBackground(Color.BLACK);
		lblSenha.setBounds(143, 221, 43, 23);
		frmCriarUsuario.getContentPane().add(lblSenha);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(143, 95, 46, 14);
		frmCriarUsuario.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(190, 92, 183, 20);
		frmCriarUsuario.getContentPane().add(textField);
		textField.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(377, 261, 114, 99);
		frmCriarUsuario.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql2 = "DELETE FROM u01 WHERE u01_id LIKE ?";

				Connection conn2 = null;
				PreparedStatement pstm2 = null;		
				
				try {
					conn2 = ConnectionFactory.createConnectionToMySQL();
					
					pstm2 = (PreparedStatement) conn2.prepareStatement(sql2);
					
					pstm2.setString(1, txtExcluir.getText());
					pstm2.execute();
					
					pstm2.close();
					conn2.close();
					
					JOptionPane.showMessageDialog(null, "Excluido");
				
					
					} catch (Exception e2) { 
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(24, 65, 75, 23);
		panel.add(btnNewButton_1);
		
		txtExcluir = new JTextField();
		txtExcluir.setBounds(13, 34, 86, 20);
		panel.add(txtExcluir);
		txtExcluir.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Insisra o ID");
		lblNewLabel_2.setBounds(25, 9, 89, 14);
		panel.add(lblNewLabel_2);
		
		btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT u01_id, u01_cpf, u01_nome, u01_funcao, u01_senha FROM u01 where u01_id LIKE ?;";

				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = (PreparedStatement) conn.prepareStatement(sql1);
					
					pstm.setString(1, "%"+ textField_Busc.getText());
					
					ResultSet rs = pstm.executeQuery();
					
					while(rs.next()) {
						
						textField.setText(rs.getString("u01_id"));
						I_Nome.setText(rs.getString("u01_cpf"));
						I_CPF.setText(rs.getString("u01_nome"));
						I_Funcao.setText(rs.getString("u01_funcao"));
						I_Senha.setText(rs.getString("u01_senha"));

					
					}
					
								 
					 					 
					 rs.close();
					 conn.close();
				} catch (Exception ee) { 
					ee.printStackTrace();
				}finally {
					
					try {
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
							
						}
					}catch (Exception ee) {
						ee.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton_2.setBounds(7, 39, 89, 23);
		frmCriarUsuario.getContentPane().add(btnNewButton_2);
		
		textField_Busc = new JTextField();
		textField_Busc.setBounds(10, 11, 86, 20);
		frmCriarUsuario.getContentPane().add(textField_Busc);
		textField_Busc.setColumns(10);
		
		btnNewButton_3 = new JButton("ATUALIZAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || I_Nome.getText().equals("") || I_CPF.getText().equals("") || I_Funcao.getText().equals("") || I_Senha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos em branco");
					}else {
					Connection conn = null;
					PreparedStatement pstm = null;
					
					try {
						conn = ConnectionFactory.createConnectionToMySQL();
						String sql = "UPDATE u01 SET u01_id = ?, u01_cpf = ?, u01_nome = ?,u01_funcao = ?, u01_senha = ? WHERE u01_id = ?";
						pstm = (PreparedStatement) conn.prepareStatement(sql);
						
						pstm.setString(1,textField.getText());
						pstm.setString(2,I_Nome.getText());
						pstm.setString(3,I_CPF.getText());
						pstm.setString(4,I_Funcao.getText());
						pstm.setString(5,I_Senha.getText());
						pstm.setString(6,textField_Busc.getText());

						
						
						pstm.execute();
					} catch (Exception ee) { 
						ee.printStackTrace();
					}finally {
						
						try {
							if(pstm!=null) {
								pstm.close();
								JOptionPane.showMessageDialog(null, "Atualizado");

							}
							if(conn!=null) {
								conn.close();
								
							}
						}catch (Exception ee) {
							ee.printStackTrace();
						}
						
					}
					}
			
			}
		});
		btnNewButton_3.setBounds(116, 337, 89, 23);
		frmCriarUsuario.getContentPane().add(btnNewButton_3);
	}
}
