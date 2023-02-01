package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Sql.Conexion;

public class Busqueda extends JFrame {
	
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tablaHuespedes;
	private JTable tablaReservas;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private JTabbedPane tabbedPane;
	private String nombre,apellido,fechaNacimiento,nacionalidad,telefono;
	private String fechaEntrada,fechaSalida,valor,formadePagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 0, 910, 36);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAtras = new JLabel("<");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario frmMenuUsuario = new MenuUsuario(); 
				frmMenuUsuario.setVisible(true);
				dispose();
			}
		});
		lblAtras.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(0, 0, 53, 36);
		panel_1.add(lblAtras);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario frmMenuUsuario = new MenuUsuario();
				frmMenuUsuario.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Busqueda.class.getResource("/Imagenes/cancelar.png")));
		btnNewButton.setBounds(857, 0, 53, 36);
		panel_1.add(btnNewButton);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Busqueda.class.getResource("/Imagenes/Ha-100px.png")));
		lblLogo.setBounds(56, 51, 104, 107);
		panel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(315, 62, 318, 42);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(632, 156, 193, 2);
		panel.add(separator);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaHuespedes();
				llenarReservas();
				
			}
		});
		btnBuscar.setIcon(new ImageIcon(Busqueda.class.getResource("/Imagenes/lupa2.png")));
		btnBuscar.setForeground(SystemColor.text);
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(835, 110, 50, 48);
		panel.add(btnBuscar);
		
		txtBuscar = new JTextField("Numero de Reserva");
		txtBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(null);
			}
		});
		txtBuscar.setForeground(Color.GRAY);
		txtBuscar.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtBuscar.setBounds(632, 127, 193, 31);
		txtBuscar.setBorder(null);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("Nacionalidad");
		model.addColumn("Telefono");
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(tabbedPane.getSelectedIndex() == 0) {
					eliminarHuesped();
				}else if (tabbedPane.getSelectedIndex() == 1) {
					eliminarReserva();
				}
			}
		});
		btnEliminar.setBackground(SystemColor.textHighlight);
		btnEliminar.setForeground(SystemColor.text);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEliminar.setBounds(762, 508, 123, 36);
		panel.add(btnEliminar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getSelectedIndex() == 0) {
					editarHuesped();
				}else if (tabbedPane.getSelectedIndex() == 1) {
					editarReserva();
				}
			}
		});
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setForeground(SystemColor.text);
		btnEditar.setBounds(637, 508, 115, 36);
		panel.add(btnEditar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 181, 856, 303);
		panel.add(tabbedPane);
		
		JPanel panelHuespedes = new JPanel();
		tabbedPane.addTab("Húespedes", null, panelHuespedes, null);
		panelHuespedes.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 831, 253);
		panelHuespedes.add(scrollPane);
		
		tablaHuespedes = new JTable();
		model = new DefaultTableModel();
		tablaHuespedes.setModel(model);
		model.addColumn("nombre");
		model.addColumn("apellido");
		model.addColumn("fecha_nacimiento");
		model.addColumn("nacionalidad");
		model.addColumn("telefono");
		
		scrollPane.setViewportView(tablaHuespedes);
		
		
		JPanel panelReservas = new JPanel();
		tabbedPane.addTab("Reservas", null, panelReservas, null);
		panelReservas.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 831, 253);
		panelReservas.add(scrollPane_1);
		
		tablaReservas = new JTable();
		model2 = new DefaultTableModel();
		tablaReservas.setModel(model2);
		model2.addColumn("fecha_entraada");
		model2.addColumn("fecha_salida");
		model2.addColumn("valor");
		model2.addColumn("forma_de_pago");
		
		scrollPane_1.setViewportView(tablaReservas);
	}
	public void llenarTablaHuespedes() {
		try {
			con = Conexion.getConection();
			
			ps = con.prepareStatement("SELECT * FROM  huespedes WHERE idReserva = ? ");
			
			ps.setString(1,String.valueOf(txtBuscar.getText()));
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Object[] fila = new Object[5];
				fila[0] = (rs.getString("nombre"));
				fila[1] =(rs.getString("apellido"));
				fila[2] =(rs.getString("fechaNacimiento"));
				fila[3] =(rs.getString("nacionalidad"));
				fila[4] =(rs.getString("telefono"));
				
				model.addRow(fila);
			}
			rs.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editarHuesped() {
		 // Obtenemos el primer dato del renglon seleccionado
        if (tablaHuespedes.getSelectedRow() != -1) {
            nombre = (String) model.getValueAt(tablaHuespedes.getSelectedRow(), 0);
            apellido =(String) model.getValueAt(tablaHuespedes.getSelectedRow(), 1);
            fechaNacimiento =(String) model.getValueAt(tablaHuespedes.getSelectedRow(), 2);
            nacionalidad =(String) model.getValueAt(tablaHuespedes.getSelectedRow(), 3);
            telefono =(String) model.getValueAt(tablaHuespedes.getSelectedRow(), 4);
            System.out.println(nombre + apellido + fechaNacimiento + nacionalidad + telefono);
            try {
    			con = Conexion.getConection();
    			
    			ps = con.prepareStatement("UPDATE huespedes SET nombre =?, apellido =?, fechaNacimiento =?, nacionalidad =?, telefono =?  WHERE idReserva =? ");
    			
    			ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, fechaNacimiento);
				ps.setString(4, nacionalidad);
				ps.setString(5, telefono);
				ps.setString(6, String.valueOf(txtBuscar.getText()));
				
				int verificacion = ps.executeUpdate();
    			
    			if(verificacion > 0) {
    				JOptionPane.showMessageDialog(null, "Huesped actualizado con exito");
    				
    				int a = tablaHuespedes.getRowCount() -1;
    		        for (int i = a; i >= 0; i--) {          
    		        model.removeRow(model.getRowCount()-1);
    		        }
    			}else {
    				JOptionPane.showMessageDialog(null, "error Huesped no ha podido ser actualizado");
    			}
    			
    			con.close();
    		} catch (Exception e) {
    			System.out.println(e);
    		}
            

        } else {
            System.out.println("Seleccione un renglon primero");
        }
	}
	public void eliminarHuesped() {
           try {
   				con = Conexion.getConection();
   			
   				ps = con.prepareStatement("DELETE FROM huespedes WHERE idReserva =? ");

				ps.setString(1, String.valueOf(txtBuscar.getText()));
				
				int verificacion = ps.executeUpdate();
   			
				if(verificacion > 0) {
					JOptionPane.showMessageDialog(null, "Huesped eliminado con exito");
   				
					int a = tablaHuespedes.getRowCount() -1;
					for (int i = a; i >= 0; i--) {          
						model.removeRow(model.getRowCount()-1);
					}
				}else {
					JOptionPane.showMessageDialog(null, "error Huesped no ha podido ser eliminado");
				}
				
   			con.close();
   		} catch (Exception e) {
   			System.out.println(e);
   		}
	}
	public void llenarReservas() {
		
		try {
			con = Conexion.getConection();
			
			ps = con.prepareStatement("SELECT * FROM  reservas WHERE id = ? ");
			
			ps.setString(1,String.valueOf(txtBuscar.getText()));
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Object[] fila = new Object[4];
				fila[0] = (rs.getString("fechaentrada"));
				fila[1] =(rs.getString("fechaSalida"));
				fila[2] =(rs.getString("valor"));
				fila[3] =(rs.getString("formaPagar"));
				
				model2.addRow(fila);
			}
			rs.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void editarReserva() {
		 // Obtenemos el primer dato del renglon seleccionado
       if (tablaReservas.getSelectedRow() != -1) {
           fechaEntrada = (String) model2.getValueAt(tablaReservas.getSelectedRow(), 0);
           fechaSalida =(String) model2.getValueAt(tablaReservas.getSelectedRow(), 1);
           valor =(String) model2.getValueAt(tablaReservas.getSelectedRow(), 2);
           formadePagar =(String) model2.getValueAt(tablaReservas.getSelectedRow(), 3);
           try {
   			con = Conexion.getConection();
   			
   			ps = con.prepareStatement("UPDATE reservas SET fechaentrada =?, fechaSalida =?, valor =?, formaPagar =? WHERE id =? ");
   			
   			ps.setString(1, fechaEntrada);
				ps.setString(2, fechaSalida);
				ps.setString(3, valor);
				ps.setString(4, formadePagar);
				ps.setString(5, String.valueOf(txtBuscar.getText()));
				
				int verificacion = ps.executeUpdate();
   			
   			if(verificacion > 0) {
   				JOptionPane.showMessageDialog(null, "Reserva actualizada con exito");
   				
   				int a = tablaReservas.getRowCount() -1;
   		        for (int i = a; i >= 0; i--) {          
   		        	model2.removeRow(model2.getRowCount()-1);
   		        }
   			}else {
   				JOptionPane.showMessageDialog(null, "error Reserva no ha podido ser actualizada");
   			}
   			
   			con.close();
   		} catch (Exception e) {
   			System.out.println(e);
   		}
           

       } else {
           System.out.println("Seleccione un renglon primero");
       }
	}
	public void eliminarReserva() {
		if (tablaReservas.getSelectedRow() != -1) {
			try {
				con = Conexion.getConection();
			
				ps = con.prepareStatement("DELETE FROM reservas WHERE id =? ");

				ps.setString(1, String.valueOf(txtBuscar.getText()));
			
				int verificacion = ps.executeUpdate();
			
				if(verificacion > 0) {
					JOptionPane.showMessageDialog(null, "Reserva eliminada con exito");
				
					int a = tablaReservas.getRowCount() -1;
					for (int i = a; i >= 0; i--) {          
						model2.removeRow(model2.getRowCount()-1);
					}
				}else {
					JOptionPane.showMessageDialog(null, "error Reservas no ha podido ser eliminada");
				}
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}else {
            System.out.println("Seleccione un renglon primero");
        }
		
	}
}
