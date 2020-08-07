package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.*;
import Vista.*;

public class Controlador_Caja {
	
	public static String [][] imprimir;
	public static String [] cabezera;
	
	public Controlador_Caja() {
		try {
			Vista_Caja window = new Vista_Caja();
			Caja caja=new Caja();
			window.setVisible(true);
			
			mostrarTodo(window,caja);
			iniciarEventos(window,caja);
			cabezera=new String [] {
	                "Id", "Monto_Apertura", "Fecha_Apertura","Hora Apertura", "Monto_Actual", "Fecha_Cierre", "Hora_Cierre", "Monto_Cierre"
	            };

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_Caja vista, Caja caja) {
		vista.btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_CajaAdd();
				
			}
		});
		vista.btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
		vista.btncerrarcaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_CajaCerrar();	
			}
		});
		vista.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=vista.tf_informe.getText();
				new Generar_Excel(nombre,cabezera,imprimir);
				vista.tf_informe.setText("");
				
			}
		});
		
	}

	public static void mostrarTodo(Vista_Caja vista, Caja caja) {

		String[][] registros = new String[caja.contadorRegistros()][8];
		double montoTotal=0;
		ResultSet cajabd = caja.getRegistros();
		PreparedStatement prepare = null;
		Conexion con = new Conexion();
		for (int i = 0; i < registros.length; i++) {
			try {
				cajabd.next();
				registros[i][0] = String.valueOf(cajabd.getInt("id_registro"));
				registros[i][1] = String.valueOf(cajabd.getDouble("monto_apertura"));
				registros[i][2] = cajabd.getString("fecha_apertura");
				registros[i][3] = cajabd.getString("hora_apertura");
				registros[i][4] = String.valueOf(cajabd.getDouble("monto_actual"));
				registros[i][5] = cajabd.getString("fecha_cierre");
				registros[i][6] = cajabd.getString("hora_cierre");
				registros[i][7] = String.valueOf(cajabd.getDouble("monto_cierre"));

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCaja.setModel(new javax.swing.table.DefaultTableModel(registros,
	            new String [] {
	                "Id", "Monto_Apertura", "Fecha_Apertura","Hora Apertura", "Monto_Actual", "Fecha_Cierre", "Hora_Cierre", "Monto_Cierre"
	            }
	        ));
		imprimir=registros;

	}
}
