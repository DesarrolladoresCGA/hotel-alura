package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagendeFondo = new JLabel("");
		imagendeFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/menu-img.png")));
		imagendeFondo.setBounds(-50, 0, 732, 501);
		panel.add(imagendeFondo);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/aH-150px.png")));
		logo.setBounds(722, 80, 150, 156);
		panel.add(logo);
		
		JLabel login = new JLabel("LOGIN");
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setFont(new Font("Dialog", Font.BOLD, 20));
		login.setForeground(SystemColor.textHighlight);
		login.setBounds(754, 265, 83, 24);
		panel.add(login);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frmLogin = new Login();
				frmLogin.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBackground(SystemColor.text);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/login.png")));
		btnLogin.setBounds(754, 300, 83, 70);
		panel.add(btnLogin);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setBounds(0, 0, 910, 36);
		panel.add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblSalir = new JLabel("");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/cancelar.png")));
		lblSalir.setBounds(857, 0, 53, 36);
		panelHeader.add(lblSalir);
		
		JPanel panelFooter = new JPanel();
		panelFooter.setBounds(0, 500, 910, 37);
		panelFooter.setBackground(new Color(12, 138, 199));
		contentPane.add(panelFooter);
	}
}
