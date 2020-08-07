
package Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tipo_Vehiculo {
    private Conexion con=new Conexion();
    private PreparedStatement prepare=null;
    private ResultSet result=null;
    
    public int consultaCodigo(String nombre) {
        String sqlCod = "SELECT ID_TIPOVEHICULO FROM TIPO_VEHICULO WHERE NOMBRE = '" + nombre + "'";
        int codigo = 0;
        try {
            prepare = con.prepareStatement(sqlCod);
            ResultSet cod_tipo = prepare.executeQuery();
            cod_tipo.next();
            codigo = cod_tipo.getInt("ID_TIPOVEHICULO");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codigo;
    }
    public String getNombre(int codigo) {
        String sqlNomb = "SELECT * FROM TIPO_VEHICULO WHERE ID_TIPOVEHICULO = '" + codigo + "'";
        String nombre = null;
        try {
            prepare = con.prepareStatement(sqlNomb);
            ResultSet tipo = prepare.executeQuery();
            tipo.next();
            nombre = tipo.getString("NOMBRE");

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return nombre;
    }
    
}
