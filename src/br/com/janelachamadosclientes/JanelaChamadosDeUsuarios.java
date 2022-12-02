package br.com.janelachamadosclientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.Usuario.Aplicacao.JanelaUsuario;
import br.com.Usuario.factory.ConnectionFactory;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JanelaChamadosDeUsuarios {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaChamadosDeUsuarios window = new JanelaChamadosDeUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaChamadosDeUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 641, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 476, 437);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane_chamados_Us = new JScrollPane();
		panel.add(scrollPane_chamados_Us);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id(Numero chamado)", "Assunto", "Prioridade", "Data de Abertura", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_chamados_Us.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Novo chamado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirNovoChamado cad_cham = new AbrirNovoChamado();
	               cad_cham.frmChamado.setVisible(true); 
			}
		});
		btnNewButton_1.setBounds(496, 425, 120, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton bnt_Finalizado = new JButton("Finalizados");
		bnt_Finalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT c01_id , c01_assunto, c01_prioridade, c01_data_abertura ,(CASE WHEN c01_status = 3 THEN 'FINALIZADO' END) AS STATUS FROM c01 where c01_status = 3;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					 
					 modelo.setNumRows(0);
					 while(rs.next()) {
						
						 modelo.addRow(new Object[] {rs.getString("c01_id"),rs.getString("c01_assunto"),rs.getString("c01_prioridade"),rs.getString("c01_data_abertura"),rs.getString("STATUS")});
						 
					 }
					 rs.close();
					 conn5.close();
					} catch (Exception e2) { 
						e2.printStackTrace();
					}
			}
		});
		bnt_Finalizado.setBounds(513, 308, 103, 23);
		frame.getContentPane().add(bnt_Finalizado);
		
		JButton bnt_Executando = new JButton("Executando");
		bnt_Executando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT c01_id , c01_assunto, c01_prioridade, c01_data_abertura ,(CASE WHEN c01_status = 2 THEN 'EXECUTANDO' END) AS STATUS FROM c01 where c01_status = 2;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					 
					 modelo.setNumRows(0);
					 while(rs.next()) {
						
						 modelo.addRow(new Object[] {rs.getString("c01_id"),rs.getString("c01_assunto"),rs.getString("c01_prioridade"),rs.getString("c01_data_abertura"),rs.getString("STATUS")});
						 
					 }
					 rs.close();
					 conn5.close();
					} catch (Exception e2) { 
						e2.printStackTrace();
					}
			}
		});
		bnt_Executando.setBounds(513, 342, 103, 23);
		frame.getContentPane().add(bnt_Executando);
		
		JButton bnt_Aberto = new JButton("Aguradando");
		bnt_Aberto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT c01_id , c01_assunto, c01_prioridade, c01_data_abertura ,(CASE WHEN c01_status = 1 THEN 'ABERTO' END) AS STATUS FROM c01 where c01_status = 1;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					 
					 modelo.setNumRows(0);
					 while(rs.next()) {
						
						 modelo.addRow(new Object[] {rs.getString("c01_id"),rs.getString("c01_assunto"),rs.getString("c01_prioridade"),rs.getString("c01_data_abertura"),rs.getString("STATUS")});
						 
					 }
					 rs.close();
					 conn5.close();
					} catch (Exception e2) { 
						e2.printStackTrace();
					}
				
			}
		});
		bnt_Aberto.setBounds(513, 376, 103, 23);
		frame.getContentPane().add(bnt_Aberto);
	}
}
