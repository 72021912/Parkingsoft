package Modelo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Vehiculo_Activo {
	
    private PreparedStatement prepare = null;
    
    public Vehiculo_Activo() {}
    
    public int generarCodigo() {
    	Conexion con = new Conexion();
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
    	Conexion con = new Conexion();
        int count = 0;
        String sqlTotalCod = "SELECT COUNT (*) FROM HISTORIAL WHERE MONTO = '0'";
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
    	Conexion con = new Conexion();
		String registrossql="SELECT * FROM HISTORIAL WHERE MONTO = '0'";
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
    public void crearRegistro(int empleado, int cliente, byte[] foto, int tamano) {
    	Conexion con = new Conexion();
    	int codigo = generarCodigo();
    	Calendar fecha=fecha();
    	String entrada=fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE);
    	int dia=fecha.get(Calendar.DAY_OF_MONTH);
    	int mes=fecha.get(Calendar.MONTH)+1;
    	int ano=fecha.get(Calendar.YEAR);
    	String salida="00:00";
    	double monto=0;
		String sqlAgregar = "INSERT INTO public.historial(\r\n" + 
				"	id_registro, dia, mes, ano, id_empleado, id_cliente, hora_entrada, hora_salida, monto, foto)\r\n" + 
				"	VALUES (?, ?, ?, ?, ?, ?,'"+entrada+"','"+salida+"', ?, ?);";
		prepare = con.prepareStatement(sqlAgregar);
		
		InputStream is = new ByteArrayInputStream(foto);
		try {
			prepare.setInt(1, codigo);
			prepare.setInt(2,dia);
			prepare.setInt(3, mes);
			prepare.setInt(4, ano);
			prepare.setInt(5, empleado);
			prepare.setInt(6, cliente);
			prepare.setDouble(7, monto);
			prepare.setBinaryStream(8, is, tamano);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
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
   
}
