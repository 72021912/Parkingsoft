package Controlador;

import Vista.Vista_ClienteAdd;
import Vista.Vista_Historial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.*;

public class Controlador_Historial {
	public static String [][] imprimir;
	public static String [] cabezera;
	
	public Controlador_Historial() {
		try {
			Vista_Historial window = new Vista_Historial();
			window.setVisible(true);
			Cliente cliente = new Cliente();
			Empleado empleado = new Empleado();
			Historial historial = new Historial();
			mostrarTodo(window,cliente,empleado,historial);
			iniciarEventos(window, cliente, empleado, historial);
			 cabezera=new String[] { "Id", "Empleado",
						"Cliente", "Placa", "Hora Entrada", "Hora Salida", "Pago", "Dia", "Mes", "Año" };

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void iniciarEventos(Vista_Historial vista,Cliente cliente, Empleado empleado,Historial historial) {
		vista.btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!vista.tfPlaca.getText().equals("")) {
					String placa=vista.tfPlaca.getText();
					busquedaPlaca(vista,cliente,empleado,historial,placa);
					vista.tfPlaca.setText("");
					vista.tfPropietario.setText("");
					
				}
				if(!vista.tfPropietario.getText().equals("")) {
					String propietario=vista.tfPropietario.getText();
					busquedaCliente(vista,cliente,empleado,historial,propietario);
					vista.tfPlaca.setText("");
					vista.tfPropietario.setText("");
				}
				if(!vista.tfDia.getText().equals("") && !vista.tfMes.getText().equals("") &&
						!vista.tfAno.getText().equals("") ) {
					int dia=Integer.parseInt(vista.tfDia.getText());
					int mes=Integer.parseInt(vista.tfAno.getText());
					int ano=Integer.parseInt(vista.tfMes.getText());
					busquedaFecha(vista,cliente,empleado,historial,dia,mes,ano);
					vista.tfPlaca.setText("");
					vista.tfPropietario.setText("");
					vista.tfDia.setText("");
					vista.tfMes.setText("");
					vista.tfAno.setText("");
				}
				
			}
		});
		vista.btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTodo(vista,cliente,empleado,historial);
			}
		});
		vista.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=vista.tf_total.getText();
				new Generar_Excel(nombre,cabezera,imprimir);
				vista.tf_total.setText("");
			}
		});
		vista.btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
	}

	public static void mostrarTodo(Vista_Historial vista, Cliente cliente, Empleado empleado, Historial historial) {

		String[][] registros = new String[historial.contadorRegistros()][10];
		double montoTotal=0;
		ResultSet historialbd = historial.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				historialbd.next();
				registros[i][0] = String.valueOf(historialbd.getInt("id_registro"));
				registros[i][1] = empleado.getNombre(historialbd.getInt("id_empleado"));
				registros[i][2] = cliente.getNombre((historialbd.getInt("id_cliente")));
				registros[i][3] = cliente.getPlaca((historialbd.getInt("id_cliente")));
				registros[i][4] = historialbd.getString("hora_entrada");
				registros[i][5] = historialbd.getString("hora_salida");
				registros[i][6] = String.valueOf(historialbd.getDouble("monto"));
				registros[i][7] = String.valueOf(historialbd.getInt("dia"));
				registros[i][8] = String.valueOf(historialbd.getInt("mes"));
				registros[i][9] = String.valueOf(historialbd.getInt("ano"));
				montoTotal+=historialbd.getDouble("monto");

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(registros, new String[] { "Id", "Empleado",
				"Cliente", "Placa", "Hora Entrada", "Hora Salida", "Pago", "Dia", "Mes", "Año" }));
		vista.tf_total1.setText(String.valueOf(montoTotal));
		imprimir=registros;

	}

	public static void busquedaPlaca(Vista_Historial vista, Cliente cliente, Empleado empleado, Historial historial,
			String placa) {

		String[][] registros = new String[historial.contadorRegistros()][10];
		double montoTotal=0;
		ResultSet historialbd = historial.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(historialbd.next()==false) {break;}
				if (cliente.getPlaca(historialbd.getInt("id_cliente")).equalsIgnoreCase(placa)) {
					registros[i][0] = String.valueOf(historialbd.getInt("id_registro"));
					registros[i][1] = empleado.getNombre(historialbd.getInt("id_empleado"));
					registros[i][2] = cliente.getNombre((historialbd.getInt("id_cliente")));
					registros[i][3] = cliente.getPlaca((historialbd.getInt("id_cliente")));
					registros[i][4] = historialbd.getString("hora_entrada");
					registros[i][5] = historialbd.getString("hora_salida");
					registros[i][6] = String.valueOf(historialbd.getDouble(("monto")));
					registros[i][7] = String.valueOf(historialbd.getInt(("dia")));
					registros[i][8] = String.valueOf(historialbd.getInt(("mes")));
					registros[i][9] = String.valueOf(historialbd.getInt(("ano")));
					montoTotal+=historialbd.getDouble("monto");
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(registros, new String[] { "Id", "Empleado",
				"Cliente", "Placa", "Hora Entrada", "Hora Salida", "Pago", "Dia", "Mes", "Año" }));
		vista.tf_total1.setText(String.valueOf(montoTotal));
		imprimir=registros;

	}
	public static void busquedaFecha(Vista_Historial vista, Cliente cliente, Empleado empleado, Historial historial,
			int dia, int mes, int ano) {
		String[][] registros = new String[historial.contadorRegistros()][10];
		double montoTotal=0;
		ResultSet historialbd = historial.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(historialbd.next()==false) {break;}
				
				if (historialbd.getInt("dia")==dia && historialbd.getInt("mes")==mes && historialbd.getInt("ano")==ano) {
					System.out.println(1);
					registros[i][0] = String.valueOf(historialbd.getInt("id_registro"));
					registros[i][1] = empleado.getNombre(historialbd.getInt("id_empleado"));
					registros[i][2] = cliente.getNombre((historialbd.getInt("id_cliente")));
					registros[i][3] = cliente.getPlaca((historialbd.getInt("id_cliente")));
					registros[i][4] = historialbd.getString("hora_entrada");
					registros[i][5] = historialbd.getString("hora_salida");
					registros[i][6] = String.valueOf(historialbd.getDouble(("monto")));
					registros[i][7] = String.valueOf(historialbd.getInt(("dia")));
					registros[i][8] = String.valueOf(historialbd.getInt(("mes")));
					registros[i][9] = String.valueOf(historialbd.getInt(("ano")));
					montoTotal+=historialbd.getDouble("monto");
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(registros, new String[] { "Id", "Empleado",
				"Cliente", "Placa", "Hora Entrada", "Hora Salida", "Pago", "Dia", "Mes", "Año" }));
		vista.tf_total1.setText(String.valueOf(montoTotal));
		imprimir=registros;
	}

	public static void busquedaCliente(Vista_Historial vista, Cliente cliente, Empleado empleado, Historial historial,
			String propietario) {

		String[][] registros = new String[historial.contadorRegistros()][10];
		double montoTotal=0;
		ResultSet historialbd = historial.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(historialbd.next()==false) {break;}
				if (cliente.getNombre(historialbd.getInt("id_cliente")).equalsIgnoreCase(propietario)) {
					registros[i][0] = String.valueOf(historialbd.getInt("id_registro"));
					registros[i][1] = empleado.getNombre(historialbd.getInt("id_empleado"));
					registros[i][2] = cliente.getNombre((historialbd.getInt("id_cliente")));
					registros[i][3] = cliente.getPlaca((historialbd.getInt("id_cliente")));
					registros[i][4] = historialbd.getString("hora_entrada");
					registros[i][5] = historialbd.getString("hora_salida");
					registros[i][6] = String.valueOf(historialbd.getDouble("monto"));
					registros[i][7] = String.valueOf(historialbd.getInt("dia"));
					registros[i][8] = String.valueOf(historialbd.getInt("mes"));
					registros[i][9] = String.valueOf(historialbd.getInt("ano"));
					montoTotal+=historialbd.getDouble("monto");
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(registros, new String[] { "Id", "Empleado",
				"Cliente", "Placa", "Hora Entrada", "Hora Salida", "Pago", "Dia", "Mes", "Año" }));
		vista.tf_total1.setText(String.valueOf(montoTotal));
		imprimir=registros;

	}

}
