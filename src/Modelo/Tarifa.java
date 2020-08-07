package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Tarifa {
	
	private Conexion con = new Conexion();
	private PreparedStatement prepare = null;

	public Tarifa() {
	}

	public int generarCodigo() {
		int count = 0;
		String sqlTotalCod = "SELECT COUNT (*) FROM TARIFA";
		try {
			prepare = con.prepareStatement(sqlTotalCod);
			ResultSet result = prepare.executeQuery();
			result.next();
			count = result.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count + 1;
	}

	public void crearTarifa(String tipoVehiculo, double costo) {
		int codigo = generarCodigo();
		int tipo = new Tipo_Vehiculo().consultaCodigo(tipoVehiculo);
		String sqlAgregar = "INSERT INTO TARIFA VALUES ('" + codigo + "','" + tipo + "','" + costo + "')";
		prepare = con.prepareStatement(sqlAgregar);
		try {
			int count = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void actualizarTarifa(int id, String tipoVehiculo, double costo) {
		int tipo = new Tipo_Vehiculo().consultaCodigo(tipoVehiculo);
		System.out.println(tipo);
		String sqlAgregar = "UPDATE TARIFA SET id_tipovehiculo='"+tipo+"', costo='"+costo+"' WHERE id_tarifa ='"+id +"';";
		prepare = con.prepareStatement(sqlAgregar);
		try {
			int count = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int contadorRegistros() {
		int count = 0;
		String sqlTotalCod = "SELECT COUNT (*) FROM TARIFA";
		try {
			prepare = con.prepareStatement(sqlTotalCod);
			ResultSet result = prepare.executeQuery();
			result.next();
			count = result.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ResultSet getRegistros() {
		String registrossql = "SELECT * FROM TARIFA ORDER BY ID_TARIFA";
		ResultSet registros = null;
		try {
			prepare = con.prepareStatement(registrossql);
			registros = prepare.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return registros;
	}
	  public ResultSet getTarifa(int id) {
			String registrossql="SELECT * FROM TARIFA WHERE ID_TARIFA = '"+id+"'";
			ResultSet registros=null;
			try {
				prepare=con.prepareStatement(registrossql);
				registros=prepare.executeQuery();
			}
			catch (SQLException e) {
			
			e.printStackTrace();
			}
			return registros;
		}
	  public double getTarifaDeTipo(String tipo) {
		  int id_tipo=new Tipo_Vehiculo().consultaCodigo(tipo);
		  String tarifasql="SELECT COSTO FROM TARIFA WHERE ID_TIPOVEHICULO = '"+id_tipo+"'";
		  ResultSet registros=null;
		  double precio=0;
			try {
				prepare=con.prepareStatement(tarifasql);
				registros=prepare.executeQuery();
				registros.next();
				precio=registros.getDouble("COSTO");
			}
			catch (SQLException e) {
			
			e.printStackTrace();
			}
			return precio;
	  }
	  public boolean eliminar(int id) {
			String registrossql="DELETE FROM tarifa WHERE ID_TARIFA = '"+id+"';";
			boolean eliminado=false;
			try {
				Statement statement=con.createStatement();
				statement.execute(registrossql);
			}
			catch (SQLException e) {
			
			e.printStackTrace();
			}
			return eliminado;
		}
	public double calcularTarifa(int diaI , int diaF , int horaI , int horaF , String tipo) {
		double tarifa=getTarifaDeTipo(tipo);
		int dias=0;
		int horas=0;
		
		while(diaI!=diaF) {
			if(diaI==31) {
				diaI=0;
			}
			diaI++;
			dias++;
		}
		while(horaI!=horaF) {
			if(horaI==24) {
				horaI=0;
			}
			horaI++;
			horas++;
		}
		if(horas==0) {
			horas++;
		}
		double cobro=((dias*24)+horas)*tarifa;
		JOptionPane.showMessageDialog(null, "El monto a cancelar es: S/."+cobro);
		return cobro;
		
	}
}
