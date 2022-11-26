package br.com.TelaAcesso;

import java.awt.EventQueue;

import javax.swing.JFrame;

import br.com.janelachamadosclientes.AbrirNovoChamado;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Administrador");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAcessoAdm Tela_ADM = new TelaAcessoAdm();
				Tela_ADM.frmLogin.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.ITALIC, 18));
		btnNewButton_1.setBounds(145, 125, 161, 53);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Usuario");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAcessoDAO Tela_Entra_Us = new TelaAcessoDAO();
				Tela_Entra_Us.frmLogin.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.ITALIC, 18));
		btnNewButton_1_1.setBounds(145, 61, 161, 53);
		frmLogin.getContentPane().add(btnNewButton_1_1);
	}
}
