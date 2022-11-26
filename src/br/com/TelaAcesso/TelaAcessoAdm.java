package br.com.TelaAcesso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import br.com.Usuario.factory.ConnectionFactory;
import br.com.janelachamadosclientes.JanelaChamadosDeUsuarios;
import br.com.listachamados.all.JanelaChamados;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TelaAcessoAdm {

	public JFrame frmLogin;
	private JTextField TFADM;
	private JPasswordField TFSenhaADM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcessoAdm window = new TelaAcessoAdm();
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
	public TelaAcessoAdm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBackground(Color.WHITE);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 681, 438);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblAdministrador.setBounds(126, 138, 138, 37);
		frmLogin.getContentPane().add(lblAdministrador);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblSenha.setBounds(186, 214, 99, 37);
		frmLogin.getContentPane().add(lblSenha);
		
		TFADM = new JTextField();
		TFADM.setBounds(274, 140, 149, 37);
		frmLogin.getContentPane().add(TFADM);
		TFADM.setColumns(10);
		
		TFSenhaADM = new JPasswordField();
		TFSenhaADM.setBounds(274, 224, 149, 37);
		frmLogin.getContentPane().add(TFSenhaADM);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn4 = null;
				PreparedStatement pstm4 = null;	
				
				try {
					String sql4 = "SELECT * FROM adm01 WHERE adm01_nome= ? and adm01_senha= ?";
						
					conn4 = ConnectionFactory.createConnectionToMySQL();
					
					pstm4 = (PreparedStatement) conn4.prepareStatement(sql4);
					
					
					
					pstm4.setString(1, TFADM.getText());
					pstm4.setString(2, new String(TFSenhaADM.getPassword()));
					
					
					
					Resultset rs = (Resultset) pstm4.executeQuery();
					
	
					
					if(((ResultSet) rs ).next()) {
						JanelaChamados All_Chamados_Only_ADM = new JanelaChamados();
						All_Chamados_Only_ADM.frmChamados.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Esse administrador nao existe");
		

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(312, 286, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
	}
}
