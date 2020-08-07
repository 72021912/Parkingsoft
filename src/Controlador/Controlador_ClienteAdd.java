
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.*;
import Vista.*;

public class Controlador_ClienteAdd {
	
	public Controlador_ClienteAdd() {
		try {
			Vista_ClienteAdd window = new Vista_ClienteAdd();
			window.setVisible(true);
			Cliente cliente = new Cliente();
			iniciarEventos(window, cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_ClienteAdd vista, Cliente cliente) {
		vista.btnbus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.tipo.setText("Furgoneta");
			}
		});
		vista.btncarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.tipo.setText("Auto");
			}
		});
		vista.btncamioneta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.tipo.setText("Camioneta");
			}
		});
		vista.btnmoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.tipo.setText("Moto");
			}
		});
		vista.btnaceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=vista.nombre.getText();
				String apellido=vista.apellido.getText();
				int telefono=Integer.parseInt(vista.celular.getText());
				String placa=vista.placa.getText();
				String tipo=vista.tipo.getText();		
				cliente.crearCliente(nombre, apellido, telefono, placa, tipo);
				limpiarInputs(vista);
				JOptionPane.showMessageDialog(null, "El cliente "+nombre+" "+apellido+" se ha creado exitosamente");
				vista.dispose();
			}
		});
		vista.btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
			}
		});
		
	}
	public static void limpiarInputs(Vista_ClienteAdd vista) {
		vista.nombre.setText("");
		vista.apellido.setText("");
		vista.celular.setText("");
		vista.placa.setText("");
		vista.tipo.setText("");
	}
}
