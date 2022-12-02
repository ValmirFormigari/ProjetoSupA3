package br.com.Maquinas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Usuario.factory.ConnectionFactory;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class IncluirMaquina {

	public JFrame frmNovoCadastro;
	private JTextField textField_ID;
	private JTextField textField_desc;
	private JTextField textField_carac;
	private JTextField textField_proc;
	private JButton btn_Inserir;
	private JButton btn_Excluir;
	private JTextField TX_DELETE;
	private JPanel panel;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btn_Buscar;
	private JTextField textField_busc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncluirMaquina window = new IncluirMaquina();
					window.frmNovoCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IncluirMaquina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoCadastro = new JFrame();
		frmNovoCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmNovoCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNovoCadastro.setTitle("Novo Cadastrro");
		frmNovoCadastro.getContentPane().setBackground(Color.WHITE);
		frmNovoCadastro.setBounds(100, 100, 576, 353);
		frmNovoCadastro.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(144, 73, 46, 14);
		frmNovoCadastro.getContentPane().add(lblNewLabel);
		
		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setBounds(232, 70, 155, 20);
		frmNovoCadastro.getContentPane().add(textField_ID);
		textField_ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descricao");
		lblNewLabel_1.setBounds(144, 98, 46, 14);
		frmNovoCadastro.getContentPane().add(lblNewLabel_1);
		
		textField_desc = new JTextField();
		textField_desc.setBounds(231, 95, 156, 20);
		frmNovoCadastro.getContentPane().add(textField_desc);
		textField_desc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Caracteristicas");
		lblNewLabel_2.setBounds(144, 129, 86, 14);
		frmNovoCadastro.getContentPane().add(lblNewLabel_2);
		
		textField_carac = new JTextField();
		textField_carac.setBounds(231, 126, 156, 20);
		frmNovoCadastro.getContentPane().add(textField_carac);
		textField_carac.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Processador");
		lblNewLabel_3.setBounds(144, 156, 72, 14);
		frmNovoCadastro.getContentPane().add(lblNewLabel_3);
		
		textField_proc = new JTextField();
		textField_proc.setBounds(231, 157, 156, 20);
		frmNovoCadastro.getContentPane().add(textField_proc);
		textField_proc.setColumns(10);
		
		btn_Inserir = new JButton("SALVAR");
		btn_Inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "INSERT INTO m01(m01_descricao,m01_caracteristica,m01_processador) VALUES(?,?,?)";

				Connection conn = null;
				PreparedStatement pstm = null;
				 
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = (PreparedStatement) conn.prepareStatement(sql);
					
					pstm.setString(1, textField_desc.getText());
					pstm.setString(2,textField_carac.getText());
					pstm.setString(3,textField_proc.getText());
					
					
					pstm.execute();
					
					} catch (Exception ex) { 
						ex.printStackTrace();
					}finally {
						
						try {
							if(pstm!=null) {
								pstm.close();
							}
							if(conn!=null) {
								conn.close();
								
							}
						}catch (Exception ex) {
							ex.printStackTrace();
						}
					}
			}
		});
		btn_Inserir.setBounds(261, 184, 89, 23);
		frmNovoCadastro.getContentPane().add(btn_Inserir);
		
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(406, 212, 144, 91);
		frmNovoCadastro.getContentPane().add(panel);
		panel.setLayout(null);
		
		TX_DELETE = new JTextField();
		TX_DELETE.setBounds(31, 32, 86, 20);
		panel.add(TX_DELETE);
		TX_DELETE.setColumns(10);
		
		btn_Excluir = new JButton("Excluir");
		btn_Excluir.setBounds(28, 57, 89, 23);
		panel.add(btn_Excluir);
		
		lblNewLabel_4 = new JLabel("Insisra o ID");
		lblNewLabel_4.setBounds(42, 11, 124, 14);
		panel.add(lblNewLabel_4);
		
		btnNewButton = new JButton("ATUALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_ID.getText().equals("") || textField_desc.getText().equals("") || textField_carac.getText().equals("") || textField_proc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos em branco");
					}else {
					Connection conn = null;
					PreparedStatement pstm = null;
					
					try {
						conn = ConnectionFactory.createConnectionToMySQL();
						String sql = "UPDATE m01 SET m01_descricao = ?, m01_caracteristica = ?,m01_processador = ?, m01_Id = ? WHERE m01_Id = ?";
						pstm = (PreparedStatement) conn.prepareStatement(sql);
						
						pstm.setString(1,textField_desc.getText());
						pstm.setString(2,textField_carac.getText());
						pstm.setString(3,textField_proc.getText());
						pstm.setString(4,textField_ID.getText());
						pstm.setString(5,textField_busc.getText());


						
						
						pstm.execute();
					} catch (Exception ee) { 
						ee.printStackTrace();
					}finally {
						
						try {
							if(pstm!=null) {
								pstm.close();
								JOptionPane.showMessageDialog(null, "Atualizdo");

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
		btnNewButton.setBounds(13, 280, 89, 23);
		frmNovoCadastro.getContentPane().add(btnNewButton);
		
		btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT m01_id, m01_descricao, m01_caracteristica, m01_processador FROM m01 where m01_id LIKE ?;";

				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = (PreparedStatement) conn.prepareStatement(sql1);
					
					pstm.setString(1, "%"+ textField_busc.getText());
					
					ResultSet rs = pstm.executeQuery();
					
					while(rs.next()) {
						
						textField_ID.setText(rs.getString("m01_id"));
						textField_desc.setText(rs.getString("m01_descricao"));
						textField_carac.setText(rs.getString("m01_caracteristica"));
						textField_proc.setText(rs.getString("m01_processador"));
					
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
		btn_Buscar.setBounds(13, 40, 89, 23);
		frmNovoCadastro.getContentPane().add(btn_Buscar);
		
		textField_busc = new JTextField();
		textField_busc.setBounds(13, 11, 86, 20);
		frmNovoCadastro.getContentPane().add(textField_busc);
		textField_busc.setColumns(10);
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql2 = "DELETE FROM m01 WHERE m01_id LIKE ?";

				Connection conn2 = null;
				PreparedStatement pstm2 = null;		
				
				try {
					conn2 = ConnectionFactory.createConnectionToMySQL();
					
					pstm2 = (PreparedStatement) conn2.prepareStatement(sql2);
					
					pstm2.setString(1, TX_DELETE.getText());
					pstm2.execute();
					
					pstm2.close();
					conn2.close();
					
					JOptionPane.showMessageDialog(null, "Excluido");
				
					
					} catch (Exception e2) { 
					e2.printStackTrace();
				}
			}
		});
	}
}
