package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Historial {
	private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
    public Historial() {}
    
    public int generarCodigo() {
    	int count = 0;
		String sqlTotalCod = "SELECT COUNT (*) FROM HISTORIAL";
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
    
    public int contadorRegistros() {
        int count = 0;
        String sqlTotalCod = "SELECT COUNT (*) FROM HISTORIAL";
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
		String registrossql="SELECT * FROM HISTORIAL ORDER BY ID_REGISTRO";
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
    public void crearRegistro(int dia, int mes, int ano, int empleado, int cliente, Calendar entrada,Calendar salida, double monto) {
    	int codigo = generarCodigo();
		String sqlAgregar = "INSERT INTO HISTORIAL VALUES ('"+codigo+"','"+dia+"','"+mes+"','"+ano+"','"+empleado+"','"+cliente+"',"+entrada+"','"+salida+"','"+"','"+monto+"';";
		prepare = con.prepareStatement(sqlAgregar);
		try {
			int count = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void actualizarRegistro(int id,String entrada, int diaI,String tipo) {
    	Calendar fecha=new Vehiculo_Activo().fecha();
    	String salida=fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE);
    	int diaF=fecha.get(Calendar.DAY_OF_MONTH);
    	int horaI=Integer.parseInt(entrada.substring(0, 2));
    	int horaF=fecha.get(Calendar.HOUR);
    	
    	double monto=new Tarifa().calcularTarifa(diaI, diaF, horaI, horaF, tipo);
    	
    	String sqlActualizar="UPDATE HISTORIAL SET hora_salida='"+salida+"', monto='"+monto+"' where id_registro='"+id+"';";
    	prepare = con.prepareStatement(sqlActualizar);
    	
		try {
			int count = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
   
}
