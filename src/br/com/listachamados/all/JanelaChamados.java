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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaChamados {

	private JFrame frmChamados;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
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
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
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
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("Lista de usuarios");
		btnNewButton.setBounds(1597, 549, 135, 23);
		frmChamados.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista maquinas");
		btnNewButton_1.setBounds(1597, 521, 135, 23);
		frmChamados.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mapa sala");
		btnNewButton_2.setBounds(1610, 22, 111, 40);
		frmChamados.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("att1");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(10, 583, 135, 23);
		frmChamados.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("att2");
		btnNewButton_4.setBounds(523, 583, 89, 23);
		frmChamados.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("att3");
		btnNewButton_5.setBounds(1036, 583, 89, 23);
		frmChamados.getContentPane().add(btnNewButton_5);
	}
}
