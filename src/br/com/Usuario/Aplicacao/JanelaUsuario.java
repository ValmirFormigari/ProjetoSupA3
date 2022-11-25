package br.com.Usuario.Aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.Usuario.dao.UsuarioDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
// Aula 6 de outubro mostra como gerar vinculo entra janelas 
//https://www.youtube.com/watch?v=XeBJGEZrbJw
public class JanelaUsuario {

	JFrame frmCriarUsuario;
	private JTextField I_CPF;
	private JTextField I_Nome;
	private JTextField I_Funcao;
	private JTextField I_Senha;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaUsuario window = new JanelaUsuario();
					window.frmCriarUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCriarUsuario = new JFrame();
		frmCriarUsuario.getContentPane().setBackground(Color.WHITE);
		frmCriarUsuario.setForeground(Color.WHITE);
		frmCriarUsuario.setBackground(Color.WHITE);
		frmCriarUsuario.setTitle("Criar Usuario");
		frmCriarUsuario.setBounds(100, 100, 371, 300);
		frmCriarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCriarUsuario.getContentPane().setLayout(null);
		
		I_CPF = new JTextField();
		I_CPF.setBounds(57, 45, 183, 20);
		frmCriarUsuario.getContentPane().add(I_CPF);
		I_CPF.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuarioDao = new UsuarioDAO();
				//nao terminei esta parte (Integer.parseIn) por (Long.)
				usuarioDao.save(I_CPF.getText() ,I_Nome.getText(), I_Funcao.getText(),I_Senha.getText());
				
				JOptionPane.showMessageDialog(null,"Usuario incluido com sucesso");
				
			}
				
		});
		btnNewButton.setBounds(256, 227, 89, 23);
		frmCriarUsuario.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(10, 44, 37, 23);
		frmCriarUsuario.getContentPane().add(lblNewLabel);
		
		I_Nome = new JTextField();
		I_Nome.setBounds(57, 14, 183, 20);
		frmCriarUsuario.getContentPane().add(I_Nome);
		I_Nome.setColumns(10);
		
		I_Funcao = new JTextField();
		I_Funcao.setBounds(57, 79, 183, 20);
		frmCriarUsuario.getContentPane().add(I_Funcao);
		I_Funcao.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 37, 23);
		frmCriarUsuario.getContentPane().add(lblNome);
		
		JLabel lblFunc = new JLabel("Funcao");
		lblFunc.setBounds(10, 78, 43, 23);
		frmCriarUsuario.getContentPane().add(lblFunc);
		
		I_Senha = new JTextField();
		I_Senha.setColumns(10);
		I_Senha.setBounds(57, 113, 183, 20);
		frmCriarUsuario.getContentPane().add(I_Senha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBackground(Color.BLACK);
		lblSenha.setBounds(10, 112, 43, 23);
		frmCriarUsuario.getContentPane().add(lblSenha);
	}
}
