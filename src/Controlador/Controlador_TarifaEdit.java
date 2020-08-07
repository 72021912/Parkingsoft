package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Tarifa;
import Modelo.Tipo_Vehiculo;
import Vista.Vista_Tarifa;
import Vista.Vista_TarifaEdit;


public class Controlador_TarifaEdit {
	private static int idEditar;

	public Controlador_TarifaEdit(int idEditar) {
		try {
			Vista_TarifaEdit window = new Vista_TarifaEdit();
			window.setVisible(true);
			this.idEditar=idEditar;
			Tarifa tarifa=new Tarifa();
			iniciarEventos(window, tarifa);
			cargarDatos(window,tarifa);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void iniciarEventos(Vista_TarifaEdit vista, Tarifa tarifa) {
		vista.btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=idEditar;
				String tipo=vista.jtcosto1.getText();
				double costo=Double.parseDouble(vista.jtcosto.getText());
				tarifa.actualizarTarifa(id, tipo, costo);
				limpiarInputs(vista);
				vista.dispose();
				new Controlador_Tarifa();
				
				
			}
		});
		vista.btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.dispose();
				new Controlador_Tarifa();
			}
		});

	}
	public void cargarDatos(Vista_TarifaEdit vista ,Tarifa tarifa) {
		ResultSet datos=tarifa.getTarifa(idEditar);
		try {
			datos.next();
			String tipo=new Tipo_Vehiculo().getNombre(datos.getInt("id_tipovehiculo"));
			String costo=String.valueOf(datos.getDouble("costo"));
			
			vista.jtcosto.setText(costo);
			vista.jtcosto1.setText(tipo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void limpiarInputs(Vista_TarifaEdit vista) {
		vista.jtcosto.setText("");
		vista.jtcosto1.setText("");	
	}
}
