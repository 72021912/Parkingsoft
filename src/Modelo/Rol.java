package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Rol {
	private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
    public Rol() {}
    
	public String getRol(int codigo) {
    	String personasql="SELECT ROL FROM ROLES WHERE ID_ROL = '"+codigo+"'";
		ResultSet registros=null;
		String rol="";
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			registros.next();
			rol=registros.getString("rol");
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return rol;
    }
	public int getIdRol(String rol) {
    	String personasql="SELECT ID_ROL FROM ROLES WHERE ROL = '"+rol+"'";
		ResultSet registros=null;
		int idrol=0;
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			registros.next();
			idrol=registros.getInt("id_rol");
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return idrol;
    }
}
