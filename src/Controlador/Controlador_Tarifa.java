package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.*;


import Vista.*;
import Vista.Vista_Tarifa;


public class Controlador_Tarifa {
	public Controlador_Tarifa() {
		try {
			Vista_Tarifa window = new Vista_Tarifa();
			window.setVisible(true);
			Tarifa tarifa=new Tarifa();
			
			mostrarGrilla(window, tarifa);
			iniciarEventos(window, tarifa);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void mostrarGrilla(Vista_Tarifa vista,Tarifa tarifa) {
		
		String [][] registros=new String [tarifa.contadorRegistros()][3];
		
		ResultSet tarifabd=tarifa.getRegistros();
		PreparedStatement prepare=null;
		Conexion con=new Conexion();
		for(int i=0;i<registros.length;i++) {
			try {
				tarifabd.next();	
				registros[i][0]=String.valueOf(tarifabd.getInt("id_tarifa"));
				registros[i][1]=new Tipo_Vehiculo().getNombre((tarifabd.getInt("id_tipovehiculo")));
				registros[i][2]=String.valueOf(tarifabd.getDouble("costo"));
					
				}
				
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
	            registros,
	            new String [] {
	                "Id", "Tipo Vehiculo", "Costo"
	            }
	        ));
	
	}
	public static void iniciarEventos(Vista_Tarifa vista, Tarifa tarifa) {
		
		vista.btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seleccionado=vista.tblVehiculos.getSelectedRow();
			
					new Controlador_TarifaEdit(seleccionado+1);
					vista.dispose();

			}
		});
		vista.btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
		vista.btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seleccionado=vista.tblVehiculos.getSelectedRow();
				if(new Acceso().validar("/tarifa/eliminar")) {
					tarifa.eliminar(seleccionado+1);
				}
			}
		});

	}
}
