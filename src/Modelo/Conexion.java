
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
   
public class Conexion {
	//CONEXION PEPE
	/*private static String url="jdbc:postgresql://192.168.43.82:5432/";
    private static String dbName="Estacionamientoss";
    private static String usuario="postgres";
    private static String contraseña="postgres";
    */
    
    
	//CONEXION LOCAL
	private static String url="jdbc:postgresql://localhost:5432/";
    private static String dbName="Estacionamiento";
    private static String usuario="postgres";
    private static String contraseña="1234e";
    
    
    
    public static Connection conection=null;
    private PreparedStatement sentencia=null;
	private ResultSet result=null;
    

	public Conexion(){
		getConexion();
	}
	public static void getConexion() {
		if(conection==null) {
			try {
				Class.forName("org.postgresql.Driver");
				conection= DriverManager.getConnection(url+dbName,usuario,contraseña);	
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public PreparedStatement prepareStatement(String sql) {
		try {
			sentencia=conection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sentencia;
	}
	public ResultSet executeQuery() {
		try {
			result=sentencia.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int executeUpdate() {
		try {
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public boolean execute() {
		
			try {
				return sentencia.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
	}
    public Statement createStatement() {
    	try {
			return conection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
   
}