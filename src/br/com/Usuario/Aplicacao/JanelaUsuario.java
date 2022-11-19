package br.com.Usuario.Aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// Aula 6 de outubro mostra como gerar vinculo entra janelas 
//https://www.youtube.com/watch?v=XeBJGEZrbJw
public class JanelaUsuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaUsuario window = new JanelaUsuario();
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
	public JanelaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(80, 35, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(233, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("cfp");
		lblNewLabel.setBounds(33, 34, 37, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 79, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 147, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(33, 78, 37, 23);
		frame.getContentPane().add(lblNome);
		
		JLabel lblDataNsc = new JLabel("data nsc");
		lblDataNsc.setBounds(33, 113, 98, 23);
		frame.getContentPane().add(lblDataNsc);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(80, 116, 86, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblFunc = new JLabel("func");
		lblFunc.setBounds(33, 150, 98, 23);
		frame.getContentPane().add(lblFunc);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(80, 186, 86, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(33, 189, 98, 23);
		frame.getContentPane().add(lblSenha);
	}

}
