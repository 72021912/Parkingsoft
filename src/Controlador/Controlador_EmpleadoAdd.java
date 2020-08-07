package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.*;
import Vista.*;

public class Controlador_EmpleadoAdd {
	public Controlador_EmpleadoAdd() {
		try {
			Vista_RegistroEmpleado window = new Vista_RegistroEmpleado();
			window.setVisible(true);
			Empleado cliente = new Empleado();
			iniciarEventos(window, cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_RegistroEmpleado vista, Empleado empleado) {
		vista.jBregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=vista.jTnombre.getText();
				String apellido=vista.jtapellido.getText();
				int telefono=Integer.parseInt(vista.jTusuario.getText());
				int dni=Integer.parseInt(vista.jTdni.getText());
				String username=vista.jTtelefono.getText();
				String contrasena=vista.jPassword.getText();
				String direccion=vista.jTextArea.getText();
				empleado.crearEmpleado(nombre, apellido, telefono, username, contrasena, dni, direccion);
				JOptionPane.showMessageDialog(null, "El Empleado "+nombre+" "+apellido+" se ha creado exitosamente");
				vista.dispose();
				new Controlador_ControlEmpleado();
			}
		});
		vista.jBcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
		
	}
}
