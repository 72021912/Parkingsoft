
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {

    private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
    public Persona(){}

    public int generarCodigo() {
        int count = 0;
        String sqlTotalCod = "SELECT COUNT (*) FROM PERSONA";
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
    
    public void crearPersona(String nombre, String apellido, int telefono, int rol) {
    	int codigo=generarCodigo();
        String sqlAgregar = "INSERT INTO PERSONA VALUES ('"+codigo+"','" + nombre + "','" 
    	+ apellido + "', '" + telefono + "','"+rol+"','true')";
        prepare = con.prepareStatement(sqlAgregar);
        try {
            int count = prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getNombre(int codigo) {
    	String personasql="SELECT NOMBRE FROM PERSONA WHERE ID_PERSONA = '"+codigo+"'";
		ResultSet registros=null;
		String nombre="";
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			registros.next();
			nombre=registros.getString("nombre");
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return nombre;
    }
    public String getApellido(int codigo) {
    	String personasql="SELECT APELLIDO FROM PERSONA WHERE ID_PERSONA = '"+codigo+"'";
		ResultSet registros=null;
		String apellido="";
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			registros.next();
			apellido=registros.getString("apellido");
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return apellido;
    }
    public int getTelefono(int codigo) {
    	String personasql="SELECT TELEFONO FROM PERSONA WHERE ID_PERSONA = '"+codigo+"'";
		ResultSet registros=null;
		int telefono=0;
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			registros.next();
			telefono=registros.getInt("telefono");
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return telefono;
    }
}
