package br.com.JanelaIMAGE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class JanelaIMAGE {

	public JFrame frmMapa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaIMAGE window = new JanelaIMAGE();
					window.frmMapa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaIMAGE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMapa = new JFrame();
		frmMapa.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmMapa.setTitle("MAPA");
		frmMapa.setBounds(100, 100, 668, 740);
		frmMapa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMapa.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\valmi\\Downloads\\Setor X.png"));
		lblNewLabel.setBounds(10, 11, 723, 700);
		frmMapa.getContentPane().add(lblNewLabel);
	}
}
