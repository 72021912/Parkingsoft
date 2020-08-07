package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Vehiculo {
    private Conexion con=new Conexion();
    private PreparedStatement prepare=null;
    private ResultSet result=null;

    public Vehiculo() { }
    
    public int generarCodigo() {
        int count = 0;
        String sqlTotalCod = "SELECT COUNT(*) FROM VEHICULO";
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
    public void crearVehiculo(String placa, String tipo) {
		int codigoTipo=new Tipo_Vehiculo().consultaCodigo(tipo);
        int codigo = generarCodigo();
        String sqlAgregar = "INSERT INTO VEHICULO VALUES('" + codigo + "','" + placa + "','" + codigoTipo + "',true)";
        prepare = con.prepareStatement(sqlAgregar);
        try {
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getTipoVehiculo(int codigo) {
    	String tiposql="SELECT ID_TIPOVEHICULO FROM VEHICULO WHERE ID_VEHICULO = '"+codigo+"'";
		ResultSet registros=null;
		String nombre="";
		int tipo=0;
		try {
			prepare=con.prepareStatement(tiposql);
			registros=prepare.executeQuery();
			registros.next();
			tipo=registros.getInt("id_tipovehiculo");
			nombre=new Tipo_Vehiculo().getNombre(tipo);
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return nombre;
    }
}
