package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.*;
import Vista.*;

public class Controlador_OpcionesLogin {
	public Controlador_OpcionesLogin() {
		try {
			Vista_OpcionesLogin window = new Vista_OpcionesLogin();
			Login login=new Login();
			window.setVisible(true);
			
			iniciarEventos(window,login);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_OpcionesLogin vista, Login login) {
		vista.jBiniciarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				vista.dispose();
				new Controlador_Login();
				
			}
		});
		vista.jBcerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Login.getRol().equalsIgnoreCase("Empleado")) {
					
					new Control_Empleado().actualizarRegistro();
				}
				Login.desconectar();
				vista.dispose();
				new Controlador_Menu();
				
			}
		});
		vista.jBcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();			
				new Controlador_Menu();
			}
		});
		vista.jBchangeturno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_CambiarTurno();
				
			}
		});
	}
}
