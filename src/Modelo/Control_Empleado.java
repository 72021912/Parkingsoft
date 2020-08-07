package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Modelo.Conexion;

public class Control_Empleado {
	
	private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
    public Control_Empleado() {}
    
    public int generarCodigo() {
    	int count = 0;
		String sqlTotalCod = "SELECT COUNT (*) FROM CONTROL_EMPLEADOS";
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
        String sqlTotalCod = "SELECT COUNT (*) FROM CONTROL_EMPLEADOS";
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
		String registrossql="SELECT * FROM CONTROL_EMPLEADOS";
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
    public void crearRegistro(int empleado) {
    	int codigo = generarCodigo();
    	Calendar fecha=fecha();
    	String hentrada=fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE);
    	int dia=fecha.get(Calendar.DAY_OF_MONTH);
    	int mes=fecha.get(Calendar.MONTH)+1;
    	int ano=fecha.get(Calendar.YEAR);
    	String fentrada=dia+"/"+mes+"/"+ano;
    	String fsalida="1/1/1";
    	String hsalida="00:00";
    	
		String sqlAgregar = "INSERT INTO CONTROL_EMPLEADOS VALUES ('"+codigo+"','"+empleado+"','"+fentrada+"','"+hentrada+"','"+fsalida+"','"+hsalida+"');";
		prepare = con.prepareStatement(sqlAgregar);
		try {
			int count = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public Calendar fecha() {
    	Calendar calendario=new GregorianCalendar();
    	calendario.setTime(new Date());
    	return calendario;
    }
	 public void actualizarRegistro() {
		 	int codigo = contadorRegistros();
	    	Calendar fecha=fecha();
	    	String hsalida=fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE);
	    	int dia=fecha.get(Calendar.DAY_OF_MONTH);
	    	int mes=fecha.get(Calendar.MONTH)+1;
	    	int ano=fecha.get(Calendar.YEAR);
	    	String fsalida=dia+"/"+mes+"/"+ano;
	    	String sqlActualizar="UPDATE CONTROL_EMPLEADOS SET f_salida='"+fsalida+"', h_salida='"+hsalida+"' where id_control='"+codigo+"';";
	    	prepare = con.prepareStatement(sqlActualizar);
	    	
			try {
				int count = prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
}
