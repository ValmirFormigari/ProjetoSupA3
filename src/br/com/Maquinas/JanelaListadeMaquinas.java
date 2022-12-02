package br.com.Maquinas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.Usuario.factory.ConnectionFactory;
import br.com.janelachamadosclientes.AbrirNovoChamado;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JanelaListadeMaquinas {

	public JFrame frmListaqMaquina;
	private JTable table_maquina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaListadeMaquinas window = new JanelaListadeMaquinas();
					window.frmListaqMaquina.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaListadeMaquinas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaqMaquina = new JFrame();
		frmListaqMaquina.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmListaqMaquina.setTitle("Lista Maquina");
		frmListaqMaquina.getContentPane().setBackground(Color.WHITE);
		frmListaqMaquina.setBounds(100, 100, 547, 618);
		frmListaqMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListaqMaquina.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("Lista Maquinas");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lista de Maquinas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.YELLOW);
		panel.setBounds(10, 11, 503, 540);
		frmListaqMaquina.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 483, 508);
		panel.add(scrollPane);
		
		table_maquina = new JTable();
		table_maquina.setBackground(Color.WHITE);
		table_maquina.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"m01_id", "m01_descricao", "m01_caracteristica", "m01_processador"
			}
		));
		scrollPane.setViewportView(table_maquina);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT m01_id, m01_descricao, m01_caracteristica, m01_processador FROM m01;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel maquina = (DefaultTableModel) table_maquina.getModel();
					 
					 maquina.setNumRows(0);
					 while(rs.next()) {
						
						 maquina.addRow(new Object[] {rs.getString("m01_id"),rs.getString("m01_descricao"),rs.getString("m01_caracteristica"),rs.getString("m01_processador")});
						 
					 }
					 rs.close();
					 conn5.close();
					} catch (Exception e2) { 
						e2.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(10, 553, 89, 23);
		frmListaqMaquina.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Criar novo cadastro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirMaquina Novo_Cadastro = new IncluirMaquina();
				Novo_Cadastro.frmNovoCadastro.setVisible(true); 
				
				
			}
		});
		btnNewButton_1.setBounds(380, 553, 133, 23);
		frmListaqMaquina.getContentPane().add(btnNewButton_1);
	}
}
