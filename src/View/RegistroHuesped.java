package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;

import Sql.Conexion;

import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import java.awt.Color;

public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFechaNacimiento;
	private JTextField txtTelefono;
	private JTextField txtnReserva;
	
	//variables de ReservasView
	public static String CheckIn,CheckOut,ValorReserva;
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;
	int id = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped();
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
	public RegistroHuesped() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 910, 634);
		contentPane.add(panel);
		panel.setLayout(null);
	
		JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getOldValue() != null) {
					SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yy");
					txtFechaNacimiento.setText(ff.format(calendar.getCalendar().getTime()));
					calendar.setVisible(false);
				}
			}
		});
		calendar.setBounds(595, 317, 219, 190);
		panel.add(calendar);
		calendar.setVisible(false);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(SystemColor.menu);
		panelHeader.setBounds(0, 0, 910, 36);
		panelHeader.setOpaque(false);
		panel.add(panelHeader);
		panelHeader.setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBackground(SystemColor.text);
		btnSalir.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/cancelar.png")));
		btnSalir.setBounds(858, 0, 52, 36);
		btnSalir.setOpaque(false);
		panelHeader.add(btnSalir);
		
		JLabel lblAtras = new JLabel("<");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView frmReservasView = new ReservasView();
				frmReservasView.setVisible(true);
				frmReservasView.cargardatos();
				dispose();

			}
		});
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblAtras.setForeground(SystemColor.text);
		lblAtras.setBounds(0, 0, 46, 36);
		panelHeader.add(lblAtras);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 489, 634);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/Ha-100px.png")));
		lblLogo.setBounds(194, 39, 104, 107);
		panel_1.add(lblLogo);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/registro.png")));
		lblImagenFondo.setBounds(0, 121, 489, 502);
		panel_1.add(lblImagenFondo);
		
		JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblTitulo.setBounds(583, 55, 290, 42);
		panel.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNombre.setBounds(562, 119, 253, 14);
		panel.add(lblNombre);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(560, 170, 289, 2);
		panel.add(separator);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBorder(null);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblApellido.setBounds(560, 189, 255, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 242, 33);
		txtApellido.setBorder(null);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(560, 240, 289, 2);
		panel.add(separator_1);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblFechaNacimiento.setBounds(560, 256, 255, 14);
		panel.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtFechaNacimiento.setBounds(560, 280, 250, 33);
		txtFechaNacimiento.setBorder(null);
		panel.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.textHighlight);
		separator_2.setBounds(560, 314, 289, 2);
		panel.add(separator_2);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNacionalidad.setBounds(560, 326, 255, 14);
		panel.add(lblNacionalidad);
		
		JComboBox cbxNacionalidad = new JComboBox();
		cbxNacionalidad.setFont(new Font("Dialog", Font.PLAIN, 16));
		cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"Afganist\u00E1n - afgano", "Alemania - alem\u00E1n", "Arabia Saudita - \u00E1rabe", "Argentina - argentino", "Australia - australiano", "B\u00E9lgica - belga", "Bolivia - boliviano", "Brasil - brasile\u00F1o", "Camboya - camboyano", "Canad\u00E1 - canadiense", "Chile - chileno", "China - chino", "Colombia - colombiano", "Corea - coreano", "Costa Rica - costarricense", "Cuba - cubano", "Dinamarca - dan\u00E9s", "Ecuador - ecuatoriano", "Egipto- egipcio", "El Salvador - salvadore\u00F1o", "Escocia - escoc\u00E9s", "Espa\u00F1a - espa\u00F1ol", "Estados Unidos - estadounidense", "Estonia - estonio", "Etiopia - etiope", "Filipinas - filipino", "Finlandia - finland\u00E9s", "Francia - franc\u00E9s", "Gales - gal\u00E9s", "Grecia - griego", "Guatemala - guatemalteco", "Hait\u00ED - haitiano", "Holanda - holand\u00E9s", "Honduras - hondure\u00F1o", "Indonesia - indon\u00E9s", "Inglaterra - ingl\u00E9s", "Irak - iraqu\u00ED", "Ir\u00E1n - iran\u00ED", "Irlanda - irland\u00E9s", "Israel - israel\u00ED", "Italia - italiano", "Jap\u00F3n - japon\u00E9s", "Jordania - jordano", "Laos - laosiano", "Letonia - let\u00F3n", "Lituania - leton\u00E9s", "Malasia - malayo", "Marruecos - marroqu\u00ED", "M\u00E9xico - mexicano", "Nicaragua - nicarag\u00FCense", "Noruega - noruego", "Nueva Zelanda - neozeland\u00E9s", "Panam\u00E1 - paname\u00F1o", "Paraguay - paraguayo", "Per\u00FA - peruano", "Polonia - polaco ", "Portugal - portugu\u00E9s", "Puerto Rico - puertorrique\u00F1o", "Republica Dominicana - dominicano", "Rumania - rumano", "Rusia - ruso", "Suecia - sueco", "Suiza - suizo", "Tailandia - tailand\u00E9s", "Taiw\u00E1n - taiwanes", "Turqu\u00EDa - turco", "Ucrania - ucraniano", "Uruguay - uruguayo", "Venezuela - venezolano", "Vietnam - vietnamita"}));
		cbxNacionalidad.setBounds(560, 350, 289, 36);
		panel.add(cbxNacionalidad);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(SystemColor.textHighlight);
		separator_3.setBounds(560, 386, 289, 2);
		panel.add(separator_3);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblTelefono.setBounds(562, 406, 253, 14);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setBorder(null);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(SystemColor.textHighlight);
		separator_4.setBounds(560, 457, 289, 2);
		panel.add(separator_4);
		
		JLabel lblNumeroReserva = new JLabel("N\u00DAMERO DE RESERVA");
		lblNumeroReserva.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNumeroReserva.setBounds(560, 474, 253, 14);
		panel.add(lblNumeroReserva);
		
		txtnReserva = new JTextField();
		txtnReserva.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtnReserva.setBounds(560, 495, 285, 33);
		txtnReserva.setBorder(null);
		txtnReserva.setEditable(false);
		panel.add(txtnReserva);
		txtnReserva.setColumns(10);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(SystemColor.textHighlight);
		separator_5.setBounds(560, 529, 289, 2);
		panel.add(separator_5);
		
		numeroDeReserva();
		
		ReservasView frmReservasView = new ReservasView();
		
		CheckIn = frmReservasView.chechin;
		CheckOut = frmReservasView.chechout;
		ValorReserva = frmReservasView.valor;
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNombre.getText().isEmpty()) {
					if(!txtApellido.getText().isEmpty()) {
						if(!txtFechaNacimiento.getText().isEmpty()) {
							if(!txtTelefono.getText().isEmpty()) {
																
								try {
									con = Conexion.getConection();
									
									ps = con.prepareStatement("INSERT INTO reservas (id,fechaentrada,fechaSalida,valor,formaPagar) VALUES (?,?,?,?,?)");
									
									ps.setString(1, String.valueOf( id));
									ps.setString(2, CheckIn);
									ps.setString(3, CheckOut);
									ps.setString(4, ValorReserva);
									ps.setString(5, frmReservasView.formaPago);
									
									
									int verificacion = ps.executeUpdate();
									
							
									if (verificacion > 0) {
										
										try {
											con = Conexion.getConection();
											
											ps = con.prepareStatement("INSERT INTO huespedes (nombre,apellido,fechaNacimiento,nacionalidad,telefono,idReserva) VALUES (?,?,?,?,?,?)");
											
											ps.setString(1, txtNombre.getText());
											ps.setString(2, txtApellido.getText());
											ps.setString(3, txtFechaNacimiento.getText());
											ps.setString(4, cbxNacionalidad.getSelectedItem().toString());
											ps.setString(5, txtTelefono.getText());
											ps.setString(6, String.valueOf(id));
											
											int verificacion2 = ps.executeUpdate();
											
											if (verificacion2 > 0) {
												Exito frmExito = new  Exito();
												frmExito.setVisible(true);
												dispose();
												
											}else {
												JOptionPane.showMessageDialog(null, "Error no se a podigo guardarel huesped");
											}
											
										} catch (Exception e2) {
											System.out.println(e2);
										}
										
										
									}else {
										JOptionPane.showMessageDialog(null, "Error no se a podigo guardar la reserva");
									}
									
									con.close();
									
								} catch (Exception e2) {
									System.out.println(e2);
								}
							}else {
								JOptionPane.showMessageDialog(null,"Pro favor llenar el campo del telefono del huesped");
							}
						}else {
							JOptionPane.showMessageDialog(null,"Pro favor llenar la fecha de Nacimiento del huesped");
						}
					}else {
						JOptionPane.showMessageDialog(null,"Pro favor llenar el apellido del huesped");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Pro favor llenar el nombre del huesped");
				}
				
				
			}
		});
		btnGuardar.setForeground(SystemColor.text);
		btnGuardar.setBackground(SystemColor.textHighlight);
		btnGuardar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnGuardar.setBounds(728, 552, 121, 36);
		panel.add(btnGuardar);
		
		JButton btnFecha = new JButton("");
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendar.setVisible(true);
				
				numeroDeReserva();
			}
		});
		btnFecha.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/calendario.png")));
		btnFecha.setBounds(810, 278, 40, 36);
		panel.add(btnFecha);
	}
	public void numeroDeReserva() {
		try {
			con = Conexion.getConection();
			
			ps = con.prepareStatement("SELECT * FROM  reservas");
			
			//ps.setString(1,String.valueOf(id));
			
			rs = ps.executeQuery();

			while(rs.next()) {
				id = rs.getInt("id");
				id++;
				txtnReserva.setText(String.valueOf(id));
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
