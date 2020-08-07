package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.*;
import Vista.*;

public class Controlador_CambiarTurno {
	public Controlador_CambiarTurno() {
		try {
			
			Vista_CambiarTurno window = new Vista_CambiarTurno();
			Login login=new Login();
			window.setVisible(true);
			
			iniciarEventos(window,login);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_CambiarTurno vista, Login login) {
		
		vista.jTidempleado.setText(Login.getRol());
		vista.jTnombres.setText(Login.getNombre());
		vista.jTapellido.setText(Login.getApellido());
		vista.jTdireccion.setText(Login.getDireccion());	
		
		vista.btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=vista.jTusuario.getText();
				String contrasena=vista.jTclave.getText();
				Login.conectar(username, contrasena);
				if(Login.estaConectado()) { 
					new Control_Empleado().actualizarRegistro();
					new Control_Empleado().crearRegistro(Login.getId_usuario());
				}
				vista.dispose();					
				new Controlador_Menu();
				
			}
		});
		vista.btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();	
				new Controlador_Menu();
				
			}
		});
		vista.jTcaja.setText(String.valueOf(new Caja().montoActual()));
	}
}
