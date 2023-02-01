package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 944, 609);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.textHighlight);
		panelMenu.setBounds(0, 0, 257, 609);
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuUsuario.class.getResource("/Imagenes/aH-150px.png")));
		lblNewLabel.setBounds(50, 58, 150, 150);
		panelMenu.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		
		JButton btnRegistro = new JButton("Registro de reservas");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservasView frmReservas = new ReservasView();
				frmReservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnRegistro.setForeground(SystemColor.text);
		btnRegistro.setBackground(SystemColor.textHighlight);
		btnRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/Imagenes/icon-reservas.png")));
		btnRegistro.setBounds(0, 255, 257, 56);
		panelMenu.add(btnRegistro);
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda frmBusqueda = new Busqueda();
				frmBusqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		btnBusqueda.setIcon(new ImageIcon(MenuUsuario.class.getResource("/Imagenes/icon-buscar.png")));
		btnBusqueda.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnBusqueda.setForeground(SystemColor.text);
		btnBusqueda.setBackground(SystemColor.textHighlight);
		btnBusqueda.setBounds(0, 312, 257, 56);
		panelMenu.add(btnBusqueda);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(SystemColor.text);
		panelHeader.setBounds(0, 0, 944, 36);
		panel.add(panelHeader);
		panelHeader.setLayout(null);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setForeground(SystemColor.text);
		btnCerrar.setBackground(SystemColor.text);
		btnCerrar.setIcon(new ImageIcon(MenuUsuario.class.getResource("/Imagenes/cancelar.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setBorder(null);
		btnCerrar.setOpaque(false);
		btnCerrar.setBounds(902, 0, 42, 36);
		panelHeader.add(btnCerrar);
		
		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panelFecha.setBounds(256, 84, 688, 121);
		panel.add(panelFecha);
		panelFecha.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(180, 11, 356, 42);
		panelFecha.add(lblNewLabel_1);
		
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
		
		JLabel lblFecha = new JLabel("Hoy es " + dia + "/" + (mes+1) + "/" + año);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 33));
		lblFecha.setForeground(SystemColor.text);
		lblFecha.setBounds(35, 64, 363, 36);
		panelFecha.add(lblFecha);
				
		JLabel lblNewLabel_2 = new JLabel("Bienvenido");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_2.setBounds(302, 234, 147, 46);
		panel.add(lblNewLabel_2);
		
		 String textoDescripcion = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
		JLabel lblNewLabel_3 = new JLabel(textoDescripcion);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(312, 291, 598, 66);
		panel.add(lblNewLabel_3);
		
	    String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
		JLabel lblNewLabel_4 = new JLabel(textoDescripcion1);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(311, 345, 569, 88);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("- Registro de Reservas y Hu\u00E9spedes");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(312, 444, 295, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("- Edici\u00F3n de Reservas y Hu\u00E9spedes existentes");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(312, 482, 355, 27);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("- Eliminar todo tipo de registros");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(312, 520, 295, 27);
		panel.add(lblNewLabel_7);
	}
}
