package br.com.listachamados.all;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.JanelaIMAGE.JanelaIMAGE;
import br.com.Maquinas.IncluirMaquina;
import br.com.Maquinas.JanelaListadeMaquinas;
import br.com.Usuario.Aplicacao.JanelaListadeUsuario;
import br.com.Usuario.Aplicacao.JanelaUsuario;
import br.com.Usuario.factory.ConnectionFactory;
import br.com.janelachamadosclientes.AbrirNovoChamado;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class JanelaChamados {

	public JFrame frmChamados;
	private JTable table_Cha_Abrt;
	private JTable table_Cha_Exec;
	private JTable table_Cha_Fin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaChamados window = new JanelaChamados();
					window.frmChamados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaChamados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChamados = new JFrame();
		frmChamados.setTitle("Chamados");
		frmChamados.getContentPane().setBackground(Color.WHITE);
		frmChamados.setBounds(100, 100, 1768, 645);
		frmChamados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChamados.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chamados em aberto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Chamados em espera");
		panel.setBackground(Color.YELLOW);
		panel.setBounds(10, 22, 503, 561);
		frmChamados.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 483, 529);
		panel.add(scrollPane);
		
		table_Cha_Abrt = new JTable();
		table_Cha_Abrt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Assunto", "Prioridade", "Data de Abertura", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_Cha_Abrt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Chamados em espera");
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chamados sendo executados", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(523, 22, 503, 561);
		frmChamados.getContentPane().add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 483, 529);
		panel_1.add(scrollPane_1);
		
		table_Cha_Exec = new JTable();
		table_Cha_Exec.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Assunto", "Prioridade ", "Data de Abertura", "Status"
			}
		));
		scrollPane_1.setViewportView(table_Cha_Exec);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setToolTipText("Chamados em espera");
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chamados concluidos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.GREEN);
		panel_1_1.setBounds(1036, 22, 503, 561);
		frmChamados.getContentPane().add(panel_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 21, 483, 529);
		panel_1_1.add(scrollPane_2);
		
		table_Cha_Fin = new JTable();
		table_Cha_Fin.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Assunto", "Prioridade", "Data de Abertura", "Status"
			}
		));
		scrollPane_2.setViewportView(table_Cha_Fin);
		
		JButton btnNewButton = new JButton("Lista de usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaListadeUsuario Chama_Lista_Usu= new JanelaListadeUsuario();
				Chama_Lista_Usu.frameListaUsu.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(1597, 549, 135, 23);
		frmChamados.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista maquinas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaListadeMaquinas Novo_Cadastro = new JanelaListadeMaquinas();
				Novo_Cadastro.frmListaqMaquina.setVisible(true); 
			}
		});
		btnNewButton_1.setBounds(1597, 521, 135, 23);
		frmChamados.getContentPane().add(btnNewButton_1);
		
		JButton bntmapa = new JButton("Mapa sala");
		bntmapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIMAGE MAPA = new JanelaIMAGE();
	               MAPA.frmMapa.setVisible(true); 
			}
		});
		bntmapa.setBounds(1610, 22, 111, 40);
		frmChamados.getContentPane().add(bntmapa);
		
		JButton btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT c01_id , c01_assunto, c01_prioridade, c01_data_abertura ,(CASE WHEN c01_status = 1 THEN 'ABERTO' END) AS STATUS FROM c01 where c01_status = 1;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) table_Cha_Abrt.getModel();
					 
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
		btnNewButton_3.setBounds(10, 583, 135, 23);
		frmChamados.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Atualizar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String sql1 = "SELECT c01_id , c01_assunto, c01_prioridade, c01_data_abertura ,(CASE WHEN c01_status = 2 THEN 'EXECUTANDO' END) AS STATUS FROM c01 where c01_status = 2;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) table_Cha_Exec.getModel();
					 
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
		btnNewButton_4.setBounds(523, 583, 89, 23);
		frmChamados.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Atualizar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String sql1 = "SELECT c01_id , c01_assunto, c01_prioridade, c01_data_abertura ,(CASE WHEN c01_status = 3 THEN 'FINALIZADO' END) AS STATUS FROM c01 where c01_status = 3;";

				Connection conn5 = null;
				PreparedStatement pstm5 = null;
				
				try {
					conn5 = ConnectionFactory.createConnectionToMySQL();
					
					pstm5 = (PreparedStatement) conn5.prepareStatement(sql1);
					
					ResultSet rs = pstm5.executeQuery();
					 
					//pstm1.execute();
					 
					DefaultTableModel modelo = (DefaultTableModel) table_Cha_Fin.getModel();
					 
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
		btnNewButton_5.setBounds(1036, 583, 111, 23);
		frmChamados.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Buscar chamado");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirNovoChamado cad_cham = new AbrirNovoChamado();
	               cad_cham.frmChamado.setVisible(true); 
			}
		});
		btnNewButton_6.setBounds(1597, 494, 135, 23);
		frmChamados.getContentPane().add(btnNewButton_6);
	}
}
