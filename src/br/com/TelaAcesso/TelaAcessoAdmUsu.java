package br.com.TelaAcesso;

import java.awt.EventQueue;

import javax.swing.JFrame;

import br.com.janelachamadosclientes.AbrirNovoChamado;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class TelaAcessoAdmUsu {

	private JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcessoAdmUsu window = new TelaAcessoAdmUsu();
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
	public TelaAcessoAdmUsu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 680, 466);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Administrador");
		btnNewButton_1.setBounds(111, 218, 176, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAcessoAdm Tela_ADM = new TelaAcessoAdm();
				Tela_ADM.frmLogin.setVisible(true);
			}
		});
		frmLogin.getContentPane().setLayout(null);
		btnNewButton_1.setFont(new Font("Arial", Font.ITALIC, 18));
		frmLogin.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(273, 87, 225, 225);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\valmi\\Downloads\\download.png"));
		frmLogin.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Usuario");
		btnNewButton_1_1.setBounds(131, 164, 118, 31);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAcessoDAO Tela_Entra_Us = new TelaAcessoDAO();
				Tela_Entra_Us.frmLogin.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.ITALIC, 18));
		frmLogin.getContentPane().add(btnNewButton_1_1);
	}
}
