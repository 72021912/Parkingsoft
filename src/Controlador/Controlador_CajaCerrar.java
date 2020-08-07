package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Caja;
import Vista.*;

public class Controlador_CajaCerrar {
	public Controlador_CajaCerrar() {
		try {
			Vista_CerrarCaja window = new Vista_CerrarCaja();
			Caja caja=new Caja();
			window.setVisible(true);
			
			iniciarEventos(window,caja);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_CerrarCaja vista, Caja caja) {
		vista.jTtotal.setText(caja.montoActual()+"");
		vista.btnretirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double monto=Double.parseDouble(vista.jTdinero.getText());
				caja.cerrarCaja(monto);
				vista.dispose();
				new Controlador_Caja();
				
			}
		});
		vista.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_Caja();
				
			}
		});
	}
}
