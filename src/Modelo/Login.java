package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login {
	private static int conectado=0;//id_persona
	private static int id_usuario;
	private static String nombre;
	private static String apellido;
	private static String rol;
	private static String direccion;
	
	private static Conexion con = new Conexion();
	private static PreparedStatement prepare = null;
	
	public static void conectar(String username, String contraseña){
		buscarEmpleado(username,contraseña);
		if(conectado==0) {buscarAdministrador(username,contraseña);}
		if(conectado==0) {
			JOptionPane.showMessageDialog(null, "El usuario o contrasena no se encuentran registrados");
		}
	}
	public static void buscarEmpleado(String username,String contraseña) {
		String personasql="SELECT * FROM EMPLEADO WHERE USERNAME = '"+username+"' and CONTRASENA ='"
				+ contraseña+"'" ;
		ResultSet registros=null;
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			if(registros.next()) {
				id_usuario=registros.getInt("id_empleado");
				conectado=registros.getInt("id_persona");
				nombre=new Persona().getNombre(conectado);
				apellido=new Persona().getApellido(conectado);
				rol=new Rol().getRol(2);
				direccion=registros.getString("direccion");
			}
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
	}
	public static void buscarAdministrador(String username,String contraseña) {
		String personasql="SELECT * FROM ADMINISTRADOR WHERE USERNAME = '"+username+"' and CONTRASENA ='"
				+ contraseña+"'" ;
		ResultSet registros=null;
		try {
			prepare=con.prepareStatement(personasql);
			registros=prepare.executeQuery();
			if(registros.next()) {
				id_usuario=registros.getInt("id_administrador");
				conectado=registros.getInt("id_persona");
				nombre=new Persona().getNombre(conectado);
				apellido=new Persona().getApellido(conectado);
				rol=new Rol().getRol(conectado);
				direccion=registros.getString("direccion");
			}
					
		}
		catch (SQLException e) {
		
		e.printStackTrace();
		}
	}
	public static String getDireccion() {
		return direccion;
	}
	public static void setDireccion(String direccion) {
		Login.direccion = direccion;
	}
	public static void desconectar() {
		conectado=0;
		id_usuario=0;
		nombre="";
		apellido="";
		rol="";
	}
	public static boolean estaConectado() {
		if(conectado!=0) {
			return true;
		}
		return false;
	}
	public static boolean conexionObligatoria() {
		if(conectado==0) {
			JOptionPane.showMessageDialog(null, "Debe conectarse para realizar cualquier actividad");
			return false;
		}
		return true;
		
	}
	public static int getConectado() {
		return conectado;
	}
	public static void setConectado(int conectado) {
		Login.conectado = conectado;
	}
	public static int getId_usuario() {
		return id_usuario;
	}
	public static void setId_usuario(int id_usuario) {
		Login.id_usuario = id_usuario;
	}
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		Login.nombre = nombre;
	}
	public static String getApellido() {
		return apellido;
	}
	public static void setApellido(String apellido) {
		Login.apellido = apellido;
	}
	public static String getRol() {
		return rol;
	}
	public static void setRol(String rol) {
		Login.rol = rol;
	}
	
	
}
