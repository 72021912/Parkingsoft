package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.*;

import Vista.*;

public class Controlador_Cliente {
	public Controlador_Cliente() {
		try {
			Vista_Cliente window = new Vista_Cliente();
			window.setVisible(true);
			Cliente cliente = new Cliente();
			Persona persona = new Persona();
			mostrarTodo(window, cliente, persona);
			iniciarEventos(window, cliente, persona);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void iniciarEventos(Vista_Cliente vista,Cliente cliente, Persona persona) {
		vista.btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!vista.tfPlaca.getText().equals("")) {
					String placa=vista.tfPlaca.getText();
					busquedaPlaca(vista,cliente,persona,placa);
					vista.tfPlaca.setText("");
					vista.tfNombre.setText("");
					
				}
				if(!vista.tfNombre.getText().equals("")) {
					String nombre=vista.tfNombre.getText();
					busquedaNombre(vista,cliente,persona,nombre);
					vista.tfPlaca.setText("");
					vista.tfNombre.setText("");
				}
			}
		});
		vista.btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTodo(vista,cliente,persona);
			}
		});
		vista.btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
			
	}

	public static void mostrarTodo(Vista_Cliente vista, Cliente cliente, Persona persona) {

		String[][] registros = new String[cliente.clientesActivos()][7];
		double montoTotal=0;
		ResultSet clientebd = cliente.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				clientebd.next();
				registros[i][0] = String.valueOf(clientebd.getInt("id_cliente"));
				registros[i][1] = persona.getNombre(clientebd.getInt("id_persona"));
				registros[i][2] = persona.getApellido(clientebd.getInt("id_persona"));
				registros[i][3] = String.valueOf(persona.getTelefono(clientebd.getInt("id_persona")));
				registros[i][4] = new Vehiculo().getTipoVehiculo(clientebd.getInt("id_cliente"));
				registros[i][5] = cliente.getPlaca(clientebd.getInt("id_cliente"));
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCliente.setModel(new javax.swing.table.DefaultTableModel(registros,
				new String[] { "Id", "Nombre", "Apellido", "Telefono", "Tipo Vehiculo", "Placa" }));

	}
	public static void busquedaPlaca(Vista_Cliente vista, Cliente cliente, Persona persona,
			String placa) {

		String[][] registros = new String[cliente.clientesActivos()][10];
		double montoTotal=0;
		ResultSet clientebd = cliente.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(clientebd.next()==false) {break;}
				if (cliente.getPlaca(clientebd.getInt("id_cliente")).equalsIgnoreCase(placa)) {
					registros[i][0] = String.valueOf(clientebd.getInt("id_cliente"));
					registros[i][1] = persona.getNombre(clientebd.getInt("id_persona"));
					registros[i][2] = persona.getApellido(clientebd.getInt("id_persona"));
					registros[i][3] = String.valueOf(persona.getTelefono(clientebd.getInt("id_persona")));
					registros[i][4] = new Vehiculo().getTipoVehiculo(clientebd.getInt("id_cliente"));
					registros[i][5] = cliente.getPlaca(clientebd.getInt("id_cliente"));
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCliente.setModel(new javax.swing.table.DefaultTableModel(registros,
				new String[] { "Id", "Nombre", "Apellido", "Telefono", "Tipo Vehiculo", "Placa" }));

	}

	public static void busquedaNombre(Vista_Cliente vista, Cliente cliente, Persona persona,
			String nombre) {

		String[][] registros = new String[cliente.clientesActivos()][10];
		double montoTotal=0;
		ResultSet clientebd = cliente.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(clientebd.next()==false) {break;}
				if (cliente.getNombre(clientebd.getInt("id_cliente")).equalsIgnoreCase(nombre)) {
					registros[i][0] = String.valueOf(clientebd.getInt("id_cliente"));
					registros[i][1] = persona.getNombre(clientebd.getInt("id_persona"));
					registros[i][2] = persona.getApellido(clientebd.getInt("id_persona"));
					registros[i][3] = String.valueOf(persona.getTelefono(clientebd.getInt("id_persona")));
					registros[i][4] = new Vehiculo().getTipoVehiculo(clientebd.getInt("id_cliente"));
					registros[i][5] = cliente.getPlaca(clientebd.getInt("id_cliente"));
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCliente.setModel(new javax.swing.table.DefaultTableModel(registros,
				new String[] { "Id", "Nombre", "Apellido", "Telefono", "Tipo Vehiculo", "Placa" }));
	}
}
