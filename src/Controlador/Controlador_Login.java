package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Modelo.*;
import Vista.*;

public class Controlador_Login {
	public Controlador_Login() {
		try {
			Vista_Login window = new Vista_Login();
			Login login=new Login();
			window.setVisible(true);
			
			iniciarEventos(window,login);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_Login vista, Login login) {
		vista.jblogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=vista.jTfusername.getText();
				@SuppressWarnings("deprecation")
				String contrasena=vista.jPasswordField1.getText();
				Login.conectar(username, contrasena);
				
				if(Login.estaConectado() && Login.getRol().equalsIgnoreCase("Empleado")) {
					
					new Control_Empleado().crearRegistro(Login.getId_usuario());
				}
				vista.dispose();					
				new Controlador_Menu();	
			}
		});
		vista.jBcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();			
				
			}
		});
	}
}
