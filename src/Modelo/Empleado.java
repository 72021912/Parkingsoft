package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Empleado {
	
	private Conexion con=new Conexion();
	private PreparedStatement prepare=null;
	private ResultSet result=null;
	private Persona persona=new Persona();
    private Vehiculo vehiculo = new Vehiculo();
	
	public int generarCodigo() {
        int count = 0;
        String sqlTotalCod = "SELECT COUNT (*) FROM EMPLEADO";
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
	
	public void crearEmpleado(String nombre, String apellido, int telefono, String username, String contrasena, int dni, String direccion) {
    	int codPersona=persona.generarCodigo();
    	persona.crearPersona(nombre, apellido, telefono,2);
    	
    	int codigoNuevo= generarCodigo();
        String sqlAgregar = "INSERT INTO EMPLEADO VALUES ('" + codigoNuevo + "','" + codPersona + "','"+username+"','"+contrasena+"','"+
        						dni+"','"+direccion+ "')";
        prepare = con.prepareStatement(sqlAgregar);
        try {
            int count = prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public String getNombre(int codigo) {
		String sqlcodPerson="SELECT ID_PERSONA FROM EMPLEADO WHERE ID_EMPLEADO = '"+codigo+"'";
		ResultSet nom_empleado= null;
		String nombre = null;
		try {
			prepare=con.prepareStatement(sqlcodPerson);
			ResultSet cod_person=prepare.executeQuery();
			cod_person.next();
			
			String sqlnombre="SELECT NOMBRE FROM PERSONA WHERE ID_PERSONA = '"+cod_person.getInt("ID_PERSONA")+"'";
			prepare=con.prepareStatement(sqlnombre);
			nom_empleado=prepare.executeQuery();
			nom_empleado.next();
			
			
			nombre=nom_empleado.getString("NOMBRE");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return nombre;
	}
	 
}
