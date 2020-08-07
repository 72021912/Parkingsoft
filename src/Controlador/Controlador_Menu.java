package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.Caja;
import Modelo.*;
import Modelo.Login;
import Vista.*;

public class Controlador_Menu {
	public Controlador_Menu() {
		try {
			Vista_Menu window = new Vista_Menu();
			window.setVisible(true);	
			iniciarEventos(window);	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Vista_Menu window = new Vista_Menu();
			window.setVisible(true);	
			iniciarEventos(window);	

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_Menu vista) {
		vista.newcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.conexionObligatoria()) {
					new Controlador_ClienteAdd();
				}
			
			}
		});
		vista.ClientesAfiliados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.conexionObligatoria()) {
					new Controlador_Cliente();
				}
			
			}
		});
		vista.vehiparque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.conexionObligatoria()) {
					new Controlador_VehiculoActivo();
				}
		
			}
		});
		vista.tarivehi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.conexionObligatoria()) {
					new Controlador_Tarifa();
				}
				
			}
		});
		vista.historial1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(Login.conexionObligatoria()) {
					new Controlador_Historial();
				}
				
			}
		});
		vista.Caja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.conexionObligatoria()) {
					new Controlador_Caja();
				}
			}
		});
		vista.login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_OpcionesLogin();
			}
		});
		
		vista.logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
		vista.ControlEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.conexionObligatoria()) {
					new Controlador_ControlEmpleado();
				}
			}
		});
		
		if(Login.estaConectado()) {
			vista.jTnombre.setText("  "+Login.getNombre()+" "+Login.getApellido());
		}
	
	}
}
