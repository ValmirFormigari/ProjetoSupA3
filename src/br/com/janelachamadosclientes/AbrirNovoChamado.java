package br.com.janelachamadosclientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import br.com.NovoChamadoDao.NovoChamadoDao;
import br.com.Usuario.dao.UsuarioDAO;
import br.com.Usuario.factory.ConnectionFactory;

import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class AbrirNovoChamado {

	public JFrame frmChamado;
	private JTextField textField_id;
	private JTextField textField_MAQ;
	private JTextField textField_2;
	private JTextField textField_Assun;
	private JTextField textField_DSC;
	private JTextField textField_Com;
	private JTextField txtAvaliar;
	private JTextField textField_status;
	private JTextField textFielddt;
	private JTextField textFieldadm;
	private JButton btnNewButton_1;
	private JTextField Buscar;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirNovoChamado window = new AbrirNovoChamado();
					window.frmChamado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AbrirNovoChamado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChamado = new JFrame();
		frmChamado.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valmi\\Downloads\\download.png"));
		frmChamado.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		frmChamado.getContentPane().setBackground(Color.WHITE);
		frmChamado.setTitle("Chamado");
		frmChamado.setBackground(UIManager.getColor("Button.highlight"));
		frmChamado.setForeground(SystemColor.windowText);
		frmChamado.setBounds(100, 100, 748, 625);
		frmChamado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmChamado.getContentPane().setLayout(null);
		
		textField_id = new JTextField();
		textField_id.setBackground(SystemColor.control);
		textField_id.setBounds(70, 71, 86, 20);
		frmChamado.getContentPane().add(textField_id);
		textField_id.setColumns(10);
		
		textField_MAQ = new JTextField();
		textField_MAQ.setBackground(SystemColor.control);
		textField_MAQ.setBounds(252, 71, 86, 20);
		frmChamado.getContentPane().add(textField_MAQ);
		textField_MAQ.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 71, 86, 17);
		frmChamado.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Maquina:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(178, 71, 77, 17);
		frmChamado.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero do chamado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(10, 11, 186, 14);
		frmChamado.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBackground(UIManager.getColor("Button.light"));
		textField_2.setEditable(false);
		textField_2.setBounds(169, 10, 86, 20);
		frmChamado.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lbDate = new JLabel("Data:");
		lbDate.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lbDate.setBounds(560, 305, 86, 32);
		frmChamado.getContentPane().add(lbDate);
		
		textField_Assun = new JTextField();
		textField_Assun.setBackground(SystemColor.control);
		textField_Assun.setBounds(403, 8, 306, 20);
		frmChamado.getContentPane().add(textField_Assun);
		textField_Assun.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Assunto:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(330, 11, 63, 14);
		frmChamado.getContentPane().add(lblNewLabel_3);
		
		textField_DSC = new JTextField();
		textField_DSC.setForeground(Color.BLACK);
		textField_DSC.setBackground(SystemColor.control);
		textField_DSC.setBounds(20, 102, 689, 192);
		frmChamado.getContentPane().add(textField_DSC);
		textField_DSC.setColumns(10);
		
		textField_Com = new JTextField();
		textField_Com.setBackground(SystemColor.control);
		textField_Com.setBounds(20, 348, 689, 170);
		frmChamado.getContentPane().add(textField_Com);
		textField_Com.setColumns(10);
		
		txtAvaliar = new JTextField();
		txtAvaliar.setBackground(SystemColor.control);
		txtAvaliar.setBounds(623, 71, 86, 20);
		frmChamado.getContentPane().add(txtAvaliar);
		txtAvaliar.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Prioridade:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_4.setBounds(535, 72, 98, 14);
		frmChamado.getContentPane().add(lblNewLabel_4);
		
		textField_status = new JTextField();
		textField_status.setBackground(SystemColor.control);
		textField_status.setBounds(623, 40, 86, 20);
		frmChamado.getContentPane().add(textField_status);
		textField_status.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Status:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5.setBounds(560, 30, 86, 37);
		frmChamado.getContentPane().add(lblNewLabel_5);
		
		textFielddt = new JTextField();
		textFielddt.setBackground(UIManager.getColor("Button.background"));
		textFielddt.setText("");
		textFielddt.setToolTipText("");
		textFielddt.setBounds(603, 309, 106, 28);
		frmChamado.getContentPane().add(textFielddt);
		textFielddt.setColumns(10);
		
		JButton btnNewButton = new JButton("GRAVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_id.getText().equals("") || textField_MAQ.getText().equals("") || textField_Assun.getText().equals("") || textField_DSC.getText().equals("") || textFielddt.getText().equals("") || txtAvaliar.getText().equals("") || textField_id.getText().equals("") || textField_status.getText().equals("") || textFieldadm.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Chamado em branco");
				}else {
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					String sql = "INSERT INTO c01(c01_u01_id,c01_m01_id,c01_assunto,c01_descricao,c01_comentario,c01_data_abertura,c01_prioridade,c01_status,c01_adm01_id) VALUES(?,?,?,?,?,?,?,?,?)";
					pstm = (PreparedStatement) conn.prepareStatement(sql);
					
					pstm.setString(1,textField_id.getText());
					pstm.setString(2,textField_MAQ.getText());
					pstm.setString(3,textField_Assun.getText());
					pstm.setString(4,textField_DSC.getText());
					pstm.setString(5,textField_Com.getText());
					pstm.setString(6,textFielddt.getText());
					pstm.setString(7,txtAvaliar.getText());
					pstm.setString(8,textField_status.getText());
					pstm.setString(9,textFieldadm.getText());
					

					
					//c01_adm01_id
					
					pstm.execute();
					
					
					JOptionPane.showMessageDialog(null," Chamado incluido com sucesso");
					
				} catch (Exception ee) { 
					ee.printStackTrace();
				}finally {
					
					try {
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
							
						}
					}catch (Exception ee) {
						ee.printStackTrace();
					}
					
				}
				}
				
		}
		});
		btnNewButton.setBounds(633, 552, 89, 23);
		frmChamado.getContentPane().add(btnNewButton);
		
		textFieldadm = new JTextField();
		textFieldadm.setBackground(SystemColor.control);
		textFieldadm.setBounds(425, 71, 99, 20);
		frmChamado.getContentPane().add(textFieldadm);
		textFieldadm.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ADM:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_6.setBounds(368, 72, 46, 14);
		frmChamado.getContentPane().add(lblNewLabel_6);
		
		btnNewButton_1 = new JButton("BUSCAR ID");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Buscar.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o Id");
				}else {
				String sql1 = "SELECT c01_id, c01_u01_id,c01_m01_id,c01_assunto,c01_descricao,c01_comentario,c01_data_abertura,c01_prioridade,c01_status,c01_adm01_id FROM c01 where c01_id LIKE ?;";

				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = (PreparedStatement) conn.prepareStatement(sql1);
					
					pstm.setString(1, "%"+ Buscar.getText());
					
					ResultSet rs = pstm.executeQuery();
					
					while(rs.next()) {
						textField_2.setText(rs.getString("c01_id"));
						textField_id.setText(rs.getString("c01_u01_id"));
						textField_MAQ.setText(rs.getString("c01_m01_id"));
						textField_Assun.setText(rs.getString("c01_assunto"));
						textField_DSC.setText(rs.getString("c01_descricao"));
						textField_Com.setText(rs.getString("c01_comentario"));
						textFielddt.setText(rs.getString("c01_data_abertura"));
						txtAvaliar.setText(rs.getString("c01_prioridade"));
						textField_status.setText(rs.getString("c01_status"));
						textFieldadm.setText(rs.getString("c01_adm01_id"));

					}
					
								 
					 					 
					 rs.close();
					 conn.close();
				} catch (Exception ee) { 
					ee.printStackTrace();
				}finally {
					
					try {
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
							
						}
					}catch (Exception ee) {
						ee.printStackTrace();
					}
					
				}
				}
			}
			
		});
		btnNewButton_1.setBounds(10, 552, 89, 23);
		frmChamado.getContentPane().add(btnNewButton_1);
		
		Buscar = new JTextField();
		Buscar.setBounds(10, 529, 86, 20);
		frmChamado.getContentPane().add(Buscar);
		Buscar.setColumns(10);
		
		btnNewButton_2 = new JButton("ATUALIZAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_id.getText().equals("") || textField_MAQ.getText().equals("") || textField_Assun.getText().equals("") || textField_DSC.getText().equals("") || textFielddt.getText().equals("") || txtAvaliar.getText().equals("") || textField_id.getText().equals("") || textField_status.getText().equals("") || textFieldadm.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chamado em branco");
					}else {
					Connection conn = null;
					PreparedStatement pstm = null;
					
					try {
						conn = ConnectionFactory.createConnectionToMySQL();
						String sql = "UPDATE c01 SET c01_u01_id = ?, c01_m01_id = ?,c01_assunto = ? ,c01_descricao = ?,c01_comentario = ?,c01_data_abertura = ? ,c01_prioridade = ? ,c01_status = ?,c01_adm01_id =? WHERE C01_Id = ?";
						pstm = (PreparedStatement) conn.prepareStatement(sql);
						
						pstm.setString(1,textField_id.getText());
						pstm.setString(2,textField_MAQ.getText());
						pstm.setString(3,textField_Assun.getText());
						pstm.setString(4,textField_DSC.getText());
						pstm.setString(5,textField_Com.getText());
						pstm.setString(6,textFielddt.getText());
						pstm.setString(7,txtAvaliar.getText());
						pstm.setString(8,textField_status.getText());
						pstm.setString(9,textFieldadm.getText());
						pstm.setString(10,Buscar.getText());
						
						pstm.execute();
					} catch (Exception ee) { 
						ee.printStackTrace();
					}finally {
						
						try {
							if(pstm!=null) {
								pstm.close();
								JOptionPane.showMessageDialog(null, "Atualizdo");

							}
							if(conn!=null) {
								conn.close();
								
							}
						}catch (Exception ee) {
							ee.printStackTrace();
						}
						
					}
					}
				
				
			}
		});
		btnNewButton_2.setBounds(96, 552, 98, 23);
		frmChamado.getContentPane().add(btnNewButton_2);
		
	
	}
}
