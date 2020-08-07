package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Permiso {
	private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
    public Permiso() {}
    
    public int generarCodigo() {
    	int count = 0;
		String sqlTotalCod = "SELECT COUNT (*) FROM PERMISOS";
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
        String sqlTotalCod = "SELECT COUNT (*) FROM PERMISOS";
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
		String registrossql="SELECT * FROM PERMISOS";
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
    public int getIdPermiso(String permiso) {
		String sql="SELECT ID_PERMISO FROM PERMISOS WHERE PERMISO = '"+permiso+"';";
		ResultSet registros=null;
		int id=0;
		try {
			prepare=con.prepareStatement(sql);
			registros=prepare.executeQuery();
			if(registros.next()) {
				id=registros.getInt("id_permiso");
			}
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return id;
	}
}
