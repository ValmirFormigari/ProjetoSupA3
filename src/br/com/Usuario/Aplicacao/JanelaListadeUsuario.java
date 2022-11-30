package br.com.Usuario.Aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.Usuario.dao.UsuarioDAO;
import br.com.Usuario.factory.ConnectionFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class JanelaListadeUsuario {

	public JFrame frameListaUsu;
	private JTable tbUS;
	private JTextField delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaListadeUsuario window = new JanelaListadeUsuario();
					window.frameListaUsu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaListadeUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameListaUsu = new JFrame();
		frameListaUsu.getContentPane().setBackground(Color.WHITE);
		frameListaUsu.setBounds(100, 100, 732, 470);
		frameListaUsu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameListaUsu.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 542, 382);
		frameListaUsu.getContentPane().add(scrollPane);
		
		tbUS = new JTable();
		tbUS.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "cpf", "Funcao", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbUS);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setBounds(10, 404, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				String sql1 = "SELECT u01_id, u01_nome, u01_cpf, u01_funcao, u01_senha FROM u01";

				Connection conn1 = null;
				PreparedStatement pstm1 = null;
				
				try {
					conn1 = ConnectionFactory.createConnectionToMySQL();
					
					pstm1 = (PreparedStatement) conn1.prepareStatement(sql1);
					
					ResultSet rs = pstm1.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) tbUS.getModel();
					 
					 modelo.setNumRows(0);
					 while(rs.next()) {
						
						 modelo.addRow(new Object[] {rs.getString("u01_id"),rs.getString("u01_nome"),rs.getString("u01_cpf"),rs.getString("u01_funcao"),rs.getString("u01_senha") });
						 
					 }
					 rs.close();
					 conn1.close();
					} catch (Exception e2) { 
						e2.printStackTrace();
					}
			}
		});
		frameListaUsu.getContentPane().add(btnNewButton);
		
		JButton bt_us = new JButton("Criar Usuario");
		bt_us.setBounds(591, 11, 122, 23);
		bt_us.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frameListaUsu.getContentPane().add(bt_us);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(562, 342, 151, 85);
		frameListaUsu.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Insira o Id ");
		panel.add(lblNewLabel);
		
		delete = new JTextField();
		panel.add(delete);
		delete.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent DE) {
				
				String sql2 = "DELETE FROM u01 WHERE u01_id LIKE ?";

				Connection conn2 = null;
				PreparedStatement pstm2 = null;		
				
				try {
					conn2 = ConnectionFactory.createConnectionToMySQL();
					
					pstm2 = (PreparedStatement) conn2.prepareStatement(sql2);
					
					pstm2.setString(1, delete.getText());
					pstm2.execute();
					
					pstm2.close();
					conn2.close();
					
					JOptionPane.showMessageDialog(null, "Excluido");
				
					
					} catch (Exception e2) { 
					e2.printStackTrace();
				}
				
				
			}
		});
		bt_us.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JanelaUsuario cad_usu = new JanelaUsuario();
               cad_usu.frmCriarUsuario.setVisible(true);
            }
        });
			
	}
}
