package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import Modelo.*;
import javax.swing.JOptionPane;

public class Caja {
	private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
    public Caja() {}
    
    public int generarCodigo() {
    	int count = 0;
		String sqlTotalCod = "SELECT COUNT (*) FROM CAJA";
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
        String sqlTotalCod = "SELECT COUNT (*) FROM CAJA";
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
		String registrossql="SELECT * FROM CAJA";
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
    public void aperturarCaja(double monto) {
    	int codigo = generarCodigo();
    	Calendar fecha=fecha();
    	String hentrada=fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE);
    	int dia=fecha.get(Calendar.DAY_OF_MONTH);
    	int mes=fecha.get(Calendar.MONTH)+1;
    	int ano=fecha.get(Calendar.YEAR);
    	String fentrada=dia+"/"+mes+"/"+ano;
    	String fsalida="1/1/1";
    	String hsalida="00:00";
    	int monto_cierre=0;
    	
		String sqlAgregar = "INSERT INTO CAJA VALUES ('"+codigo+"','"+monto+"','"+fentrada+"','"+hentrada+"','"+monto+"','"
							+fsalida+"','"+hsalida+"','"+monto_cierre+"');";
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
	 public void cerrarCaja(double montoRetirar) {
		 double montocierre=montoActual();
		 if(montocierre-montoRetirar<0) {
			 JOptionPane.showMessageDialog(null, "El monto a retirar es mayor al monto actual");
		 }
		 else {
		 	int codigo = contadorRegistros();
	    	Calendar fecha=fecha();
	    	String hsalida=fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE);
	    	int dia=fecha.get(Calendar.DAY_OF_MONTH);
	    	int mes=fecha.get(Calendar.MONTH)+1;
	    	int ano=fecha.get(Calendar.YEAR);
	    	String fsalida=dia+"/"+mes+"/"+ano;
	    	String sqlActualizar="UPDATE CAJA SET fecha_cierre='"+fsalida+"', hora_cierre='"+hsalida+"', monto_cierre='"+
	    					montoRetirar+"' where id_registro='"+codigo+"';";
	    	prepare = con.prepareStatement(sqlActualizar);
	    	
			try {
				int count = prepare.executeUpdate();
				aperturarCaja(montocierre-montoRetirar);//Se apertura una nueva Caja descontando el monto
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	 }
	 public double montoActual() {
		 int actual=contadorRegistros();
		 String registrossql="SELECT MONTO_ACTUAL FROM CAJA WHERE ID_REGISTRO = '"+actual+"'";
			ResultSet registros=null;
			double monto=0;
			try {
				prepare=con.prepareStatement(registrossql);
				registros=prepare.executeQuery();
				registros.next();
				monto = registros.getDouble("monto_actual");
			}
			catch (SQLException e) {
			
			e.printStackTrace();
			}
			return monto;
	 }
	 public void actualizarCaja(double monto) {
		 int codigo = contadorRegistros();
		 if(codigo==0) {
			 aperturarCaja(monto);
		 }
		 else {
		 double actualizar=montoActual()+monto;
	    String sqlActualizar="UPDATE CAJA SET monto_actual='"+actualizar+"' where id_registro='"+codigo+"';";
	    	prepare = con.prepareStatement(sqlActualizar);
	    	
			try {
				int count = prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	 }
}
