package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.DefaultComboBoxModel;

public class ReservasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCheckIn;
	private JTextField txtCheckOut;
	private JTextField txtValorReserva;
	public static String chechin,chechout,valor,formaPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
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
	public ReservasView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getOldValue() != null) {
					SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yy");
					txtCheckIn.setText(ff.format(calendar.getCalendar().getTime()));
					calendar.setVisible(false);
				}
			}
		});
		calendar.setBounds(90, 197, 237, 161);
		calendar.setVisible(false);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getOldValue() != null) {
					SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yy");
					txtCheckOut.setText(ff.format(calendar_1.getCalendar().getTime()));
					calendar_1.setVisible(false);
				}
			}
		});
		calendar_1.setBounds(90, 284, 237, 174);
		calendar_1.setVisible(false);
		panel.add(calendar_1);
		panel.add(calendar);
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground(Color.WHITE);
		panel_header.setBounds(0, 0, 910, 36);
		panel_header.setOpaque(false);
		panel.add(panel_header);
		panel_header.setLayout(null);
		
		JLabel lblAtras = new JLabel("<");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario frmMenuUsuario = new MenuUsuario(); 
				frmMenuUsuario.setVisible(true);
				dispose();
			}
		});
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblAtras.setBounds(0, 0, 53, 36);
		panel_header.add(lblAtras);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario frmMenuUsuario = new MenuUsuario();
				frmMenuUsuario.setVisible(true);
				dispose();
			}
		});
		btnCerrar.setBackground(SystemColor.textHighlight);
		btnCerrar.setIcon(new ImageIcon(ReservasView.class.getResource("/Imagenes/cancelar.png")));
		btnCerrar.setBounds(857, 0, 53, 36);
		btnCerrar.setOpaque(false);
		panel_header.add(btnCerrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(428, 0, 482, 560);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ReservasView.class.getResource("/Imagenes/reservas-img-3.png")));
		lblNewLabel_6.setBounds(0, 0,482, 560);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE RESERVAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(96, 60, 244, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FECHA CHECK IN");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(68, 136, 169, 14);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(68, 195, 289, 2);
		panel.add(separator);
		
		txtCheckIn = new JTextField();
		txtCheckIn.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCheckIn.setBounds(68, 173, 259, 20);
		txtCheckIn.setBorder(null);
		panel.add(txtCheckIn);
		txtCheckIn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FECHA CHECH OUT");
		lblNewLabel_2.setForeground(SystemColor.textInactiveText);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(68, 221, 187, 14);
		panel.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(68, 281, 289, 11);
		panel.add(separator_1);
		
		txtCheckOut = new JTextField();
		txtCheckOut.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCheckOut.setBounds(68, 260, 259, 20);
		txtCheckOut.setBorder(null);
		panel.add(txtCheckOut);
		txtCheckOut.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("VALOR DE LA RESERVA");
		lblNewLabel_3.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(72, 303, 285, 14);
		panel.add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.textHighlight);
		separator_2.setBounds(68, 362, 289, 2);
		panel.add(separator_2);
		
		JLabel lblNewLabel_4 = new JLabel("$");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setBounds(66, 342, 16, 14);
		panel.add(lblNewLabel_4);
		
		txtValorReserva = new JTextField();
		txtValorReserva.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtValorReserva.setBounds(80, 340, 276, 20);
		txtValorReserva.setBorder(null);
		panel.add(txtValorReserva);
		txtValorReserva.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("FORMA DE PAGO");
		lblNewLabel_5.setForeground(SystemColor.textInactiveText);
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(68, 382, 187, 24);
		panel.add(lblNewLabel_5);
		
		JComboBox cbxFormaDePago = new JComboBox();
		cbxFormaDePago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Cr\u00E9dito", "Tarjeta de D\u00E9bito", "Dinero en Efectivo"}));
		cbxFormaDePago.setBackground(Color.WHITE);
		cbxFormaDePago.setFont(new Font("Dialog", Font.PLAIN, 16));
		cbxFormaDePago.setBounds(68, 417, 289, 38);
		panel.add(cbxFormaDePago);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtCheckIn.getText().isEmpty()) {
					if(!txtCheckOut.getText().isEmpty()) {
						if(!txtValorReserva.getText().isEmpty()) {
							chechin = txtCheckIn.getText();
							chechout = txtCheckOut.getText();
							valor = txtValorReserva.getText();
							formaPago = cbxFormaDePago.getSelectedItem().toString();
							RegistroHuesped frmRegistroHuesped  = new RegistroHuesped ();
							frmRegistroHuesped.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"Pro favor llenar el valor de la reserva");
						}
					}else {
						JOptionPane.showMessageDialog(null,"Pro favor llenar la fecha de Check out");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Pro favor llenar la fecha de Check in");
				}
				

			}
		});
		btnSiguiente.setBackground(SystemColor.textHighlight);
		btnSiguiente.setForeground(SystemColor.text);
		btnSiguiente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSiguiente.setBounds(226, 482, 131, 36);
		panel.add(btnSiguiente);
		
		JButton btnFechaIn = new JButton("");
		btnFechaIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendar.setVisible(true);
			}
		});
		btnFechaIn.setIcon(new ImageIcon(ReservasView.class.getResource("/Imagenes/calendario.png")));
		btnFechaIn.setBounds(327, 172, 28, 23);
		panel.add(btnFechaIn);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendar_1.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(ReservasView.class.getResource("/Imagenes/calendario.png")));
		btnNewButton.setBounds(327, 258, 28, 23);
		panel.add(btnNewButton);
	}
	public void cargardatos() {
		RegistroHuesped frmRegistroHuesped = new RegistroHuesped();
		txtCheckIn.setText(frmRegistroHuesped.CheckIn);
		txtCheckOut.setText(frmRegistroHuesped.CheckOut);
		txtValorReserva.setText(frmRegistroHuesped.ValorReserva);
	}
}
