package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.*;

import Vista.*;

public class Controlador_ControlEmpleado {

	public Controlador_ControlEmpleado() {
		try {
			Vista_ControlEmpleado window = new Vista_ControlEmpleado();
			window.setVisible(true);
			Empleado empleado = new Empleado();
			Control_Empleado control=new Control_Empleado();
			mostrarTodo(window,control,empleado);
			iniciarEventos(window, empleado, control);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_ControlEmpleado vista,Empleado empleado, Control_Empleado control) {
		vista.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!vista.jtbuscar.getText().equals("")) {
					String nombre=vista.jtbuscar.getText();
					busquedaEmpleado(vista,control,empleado,nombre);
					vista.jtbuscar.setText("");
				}
			}
		});
		vista.btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
		vista.btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTodo(vista,control,empleado);
			}
		});
		vista.btnañadirempleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_EmpleadoAdd();
			}
		});
		
	}
	public static void mostrarTodo(Vista_ControlEmpleado vista, Control_Empleado control, Empleado empleado) {

		String[][] registros = new String[control.contadorRegistros()][6];
		ResultSet historialbd = control.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				historialbd.next();
				registros[i][0] = String.valueOf(historialbd.getInt("id_control"));
				registros[i][1] = empleado.getNombre(historialbd.getInt("id_empleado"));
				registros[i][2] = historialbd.getString("f_entrada");
				registros[i][3] = historialbd.getString("h_entrada");
				registros[i][4] = historialbd.getString("f_salida");
				registros[i][5] = historialbd.getString("h_salida");
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		vista.tblCaja.setModel(new javax.swing.table.DefaultTableModel(registros, new String[] { "Numero Control",
				"Empleado", "Fecha de Entrada", "Hora de Entrada", "Fecha de Salida", "Hora de Salida" }));

	}
	public static void busquedaEmpleado(Vista_ControlEmpleado vista, Control_Empleado control, Empleado empleado,
			String nombreEmpleado) {

		String[][] registros = new String[control.contadorRegistros()][7];
		ResultSet historialbd = control.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(historialbd.next()==false) {break;}
				if (empleado.getNombre(historialbd.getInt("id_empleado")).equalsIgnoreCase(nombreEmpleado)) {
					registros[i][0] = String.valueOf(historialbd.getInt("id_control"));
					registros[i][1] = empleado.getNombre(historialbd.getInt("id_empleado"));
					registros[i][2] = historialbd.getString("f_entrada");
					registros[i][3] = historialbd.getString("h_entrada");
					registros[i][4] = historialbd.getString("f_salida");
					registros[i][5] = historialbd.getString("h_salida");
					
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCaja.setModel(new javax.swing.table.DefaultTableModel(registros, new String[] { "Numero Control",
				"Empleado", "Fecha de Entrada", "Hora de Entrada", "Fecha de Salida", "Hora de Salida" }));

	}
}
