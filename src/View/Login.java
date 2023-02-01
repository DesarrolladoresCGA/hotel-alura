package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sql.Conexion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 562);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 788, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBounds(0, 0, 788, 36);
		panelHeader.setOpaque(false);
		panel.add(panelHeader);
		panelHeader.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/cancelar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(729, 0, 59, 34);
		panelHeader.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(484, 0, 304, 562);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/img-hotel-login-.png")));
		lblNewLabel.setBounds(0, 0, 294, 506);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/aH-40px.png")));
		lblNewLabel_1.setBounds(65, 65, 48, 59);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("INICIAR SESI\u00D3N");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(65, 149, 371, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("USUARIO");
		lblNewLabel_3.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(65, 219, 131, 26);
		panel.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsuario.setText("");
			}
		});
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setText("ingrese su nombre de usuario");
		txtUsuario.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtUsuario.setBounds(65, 256, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_4.setForeground(SystemColor.textInactiveText);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(65, 316, 140, 26);
		panel.add(lblNewLabel_4);
		
		txtContra = new JPasswordField("123456");
		txtContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtContra.setText("");
			}
		});
		txtContra.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtContra.setEchoChar('*');
		txtContra.setForeground(SystemColor.textInactiveText);
		txtContra.setBounds(65, 353, 324, 32);
		panel.add(txtContra);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(65, 292, 324, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(65, 393, 324, 2);
		panel.add(separator_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps;
				ResultSet rs;
				try {
					con = Conexion.getConection();
					
					ps = con.prepareStatement("SELECT * FROM usuarios WHERE  usuario = ? AND contrasena = ?");
					
					ps.setString(1,txtUsuario.getText());
					ps.setString(2,txtContra.getText());
					
					rs = ps.executeQuery();
					
					if(rs.next()) {
						MenuUsuario frmUsuario = new MenuUsuario();
						frmUsuario.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Error Usuario o contraseña incorectos");
					}
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
			}
		});
		btnEntrar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnEntrar.setBackground(SystemColor.textHighlight);
		btnEntrar.setForeground(SystemColor.text);
		btnEntrar.setBounds(65, 431, 122, 44);
		panel.add(btnEntrar);
	}
}
