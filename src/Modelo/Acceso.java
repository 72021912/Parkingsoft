package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Acceso {
	private Conexion con = new Conexion();
    private PreparedStatement prepare = null;
    
	    public int contadorRegistros() {
	        int count = 0;
	        String sqlTotalCod = "SELECT COUNT (*) FROM ACCESOS";
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
	    public boolean validar(String permiso) {
	    	int idPermiso=new Permiso().getIdPermiso(permiso);
	    	int idRol=new Rol().getIdRol(Login.getRol());
	    	String sql="SELECT ID_ACCESO FROM ACCESOS WHERE ID_ROL = '"+idRol+"' and ID_PERMISO = '"+
	    	+idPermiso+"';";
			ResultSet registros=null;
			int id=0;
			try {
				prepare=con.prepareStatement(sql);
				registros=prepare.executeQuery();
				if(registros.next()) {
				id=registros.getInt("id_acceso");
				}
			}
			catch (SQLException e) {
			e.printStackTrace();
			}
			
			if(id!=0) {
				return true;
			}
			JOptionPane.showMessageDialog(null, "Lo sentimos, usted no tiene Acceso a esta Funcionalidad");
			return false;
	    }
	    
}
