
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
     private Conexion con = new Conexion();
     private Persona persona = new Persona();
     private Vehiculo vehiculo = new Vehiculo();
     private PreparedStatement prepare = null;
    
    public Cliente (){}
    
    public int generarCodigo() {
        int count = 0;
        String sqlTotalCod = "SELECT COUNT (*) FROM CLIENTE";
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
    
    public void crearCliente(String nombre, String apellido, int telefono, String placa, String tipo) {
    	int codPersona=persona.generarCodigo();
    	persona.crearPersona(nombre, apellido, telefono,3);
    	int codVehiculo=vehiculo.generarCodigo();
    	vehiculo.crearVehiculo(placa, tipo);
    	int codCliente= generarCodigo();
        String sqlAgregar = "INSERT INTO CLIENTE VALUES ('" + codCliente + "','" + codPersona + "', '" + codVehiculo + "')";
        prepare = con.prepareStatement(sqlAgregar);
        try {	
            int count = prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public int clientesActivos() {
		int count=0;
		String clientessql="SELECT ID_PERSONA FROM CLIENTE";
		
		
		try {
			prepare=con.prepareStatement(clientessql);
			ResultSet clientes=prepare.executeQuery();
			while(clientes.next()) {
				String estadossql="SELECT * FROM PERSONA WHERE ID_PERSONA = '"+clientes.getInt("ID_PERSONA")+"' AND "
						+ "ESTADO_REGISTRO = 'true' ";
				prepare=con.prepareStatement(estadossql);
				ResultSet estados=prepare.executeQuery();
				if(estados.next()!=false) {
					count++;
				}
		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public String getNombre(int codigo) {
		String sqlcodPerson="SELECT ID_PERSONA FROM CLIENTE WHERE ID_CLIENTE = '"+codigo+"'";
		ResultSet nom_cliente = null;
		String nombre = null;
		try {
			prepare=con.prepareStatement(sqlcodPerson);
			ResultSet cod_person=prepare.executeQuery();
			cod_person.next();
			
			String sqlnombre="SELECT NOMBRE FROM PERSONA WHERE ID_PERSONA = '"+cod_person.getInt("ID_PERSONA")+"'";
			prepare=con.prepareStatement(sqlnombre);
			nom_cliente=prepare.executeQuery();
			nom_cliente.next();
			
			
			nombre=nom_cliente.getString("NOMBRE");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return nombre;
	}
	public String getApellido(int codigo) {
		String sqlcodPerson="SELECT ID_PERSONA FROM CLIENTE WHERE ID_CLIENTE = '"+codigo+"'";
		ResultSet nom_cliente = null;
		String apellido = null;
		try {
			prepare=con.prepareStatement(sqlcodPerson);
			ResultSet cod_person=prepare.executeQuery();
			cod_person.next();
			
			String sqlnombre="SELECT APELLIDO FROM PERSONA WHERE ID_PERSONA = '"+cod_person.getInt("ID_PERSONA")+"'";
			prepare=con.prepareStatement(sqlnombre);
			nom_cliente=prepare.executeQuery();
			nom_cliente.next();
			
			
			apellido=nom_cliente.getString("APELLIDO");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return apellido;
	}
	public String getPlaca(int codigo) {
		String sqlcodVehiculo="SELECT ID_VEHICULO FROM CLIENTE WHERE ID_CLIENTE = '"+codigo+"'";
		ResultSet nom_vehiculo = null;
		String nombre = null;
		try {
			prepare=con.prepareStatement(sqlcodVehiculo);
			ResultSet cod_person=prepare.executeQuery();
			cod_person.next();
			
			String sqlnombre="SELECT PLACA FROM VEHICULO WHERE ID_VEHICULO = '"+cod_person.getInt("ID_VEHICULO")+"'";
			prepare=con.prepareStatement(sqlnombre);
			nom_vehiculo=prepare.executeQuery();
			nom_vehiculo.next();
			
			
			nombre=nom_vehiculo.getString("PLACA");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return nombre;
		
	}
	public ResultSet getRegistros() {
		String registrossql="SELECT * FROM CLIENTE";
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
	public int getVehiculo(int idcliente) {
		String sql="SELECT ID_VEHICULO FROM CLIENTE WHERE ID_CLIENTE='"+idcliente+"';";
		ResultSet registros=null;
		int id=0;
		try {
			prepare=con.prepareStatement(sql);
			registros=prepare.executeQuery();
			id=registros.getInt("ID_VEHICULO");
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return id;
	}
	public ResultSet getClientedePlaca(String placa) {
		String registrossql="SELECT ID_VEHICULO FROM VEHICULO WHERE PLACA='"+placa+"';";
		ResultSet registros=null;
		try {
			prepare=con.prepareStatement(registrossql);
			registros=prepare.executeQuery();
			if(registros.next()!=false) {
				String clientesql="SELECT ID_CLIENTE FROM CLIENTE WHERE ID_VEHICULO='"+registros.getInt("ID_Vehiculo")+"'";
				prepare=con.prepareStatement(clientesql);
				registros=prepare.executeQuery();
				return registros;
			}
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
		return registros;
	}
}
