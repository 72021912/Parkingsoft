package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Caja;
import Vista.Vista_CajaAdd;

public class Controlador_CajaAdd {
	public Controlador_CajaAdd() {
		try {
			Vista_CajaAdd window = new Vista_CajaAdd();
			Caja caja=new Caja();
			window.setVisible(true);
			
			iniciarEventos(window,caja);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_CajaAdd vista, Caja caja) {
		vista.btnañadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double monto=Double.parseDouble(vista.jTdinero.getText());
				caja.actualizarCaja(monto);
				vista.dispose();
				new Controlador_Caja();
				
			}
		});
		vista.btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_Caja();
				
			}
		});
	}
}
