package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modelo.*;

public class Controlador_VehiculoActivo {
	private static String[][] registros;
	public Controlador_VehiculoActivo(){
		try {
			Vista_VehiculosActivos window = new Vista_VehiculosActivos();
			window.setVisible(true);
			Cliente cliente = new Cliente();
			Empleado empleado = new Empleado();
			Vehiculo_Activo lista = new Vehiculo_Activo();
			mostrarTodo(window, cliente, empleado, lista);
			iniciarEventos(window, cliente, empleado, lista);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void iniciarEventos(Vista_VehiculosActivos vista, Cliente clientes, Empleado empleado,
			Vehiculo_Activo lista) {
		 vista.btnagregar.addActionListener(new java.awt.event.ActionListener() {
	            @SuppressWarnings("unused")
				public void actionPerformed(java.awt.event.ActionEvent evt) {
	              ResultSet cliente=new Cliente().getClientedePlaca(vista.jtbuscar.getText());
	              try {
					cliente.next();
					if(cliente!=null) {
						CamaraWeb camara=new CamaraWeb(1,cliente.getInt("id_cliente"));
						camara.run();
						mostrarTodo(vista,clientes,empleado,lista);
						vista.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "El cliente no se encuentra Registrado");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	            }
	        });
		 vista.btnretirar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	int seleccionado=vista.tblCliente.getSelectedRow();
	            	int id=Integer.parseInt(registros[seleccionado][3]);
	            	String entrada=registros[seleccionado][6];
	            	int diaI=Integer.parseInt(registros[seleccionado][7]);
	            	String tipo=registros[seleccionado][4];
	            	new Historial().actualizarRegistro(id, entrada, diaI, tipo);
	            	mostrarTodo(vista,clientes,empleado,lista);
	            }
		 });
		  vista.btnsalir.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	              vista.dispose();
	            }
	        });
		  vista.btncaja.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            		double monto=new Caja().montoActual();
		              JOptionPane.showMessageDialog(null, "El monto actual en CAJA es de : "+monto);
		            }
		        });
		  vista.btnverfoto.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	int seleccionado=vista.tblCliente.getSelectedRow();
	            	ImageIcon foto=new Foto().getFoto(Integer.parseInt(registros[seleccionado][3]));
	            	new Vista_Foto(foto);   
	            	
	            }
		  });
		  vista.jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	int seleccionado=vista.tblCliente.getSelectedRow();
	            	String nombre= registros[seleccionado][1]; 
	            	String apellido=registros[seleccionado][2];
	            	String placa=registros[seleccionado][5];
	            	String tipo=registros[seleccionado][4];
	            	String entrada=registros[seleccionado][6];
	            	String dia=registros[seleccionado][7];
	            	String mes=registros[seleccionado][8];
	            	String ano=registros[seleccionado][9];
	            	String fecha=dia+"/"+mes+"/"+ano;
	            	String texto="PARKING SEAL CYPHER"+
	            				"\nNombre: "+nombre+
	            				"\nApellido: "+apellido+
	            				"\nPlaca: "+placa+
	            				"\nTipo Vehiculo: "+tipo+
	            				"\nHora Entrada: "+entrada+
	            				"\nFecha: "+fecha;
	            	
	            	new Vista_GeneradorQR(texto);
	            	
	            }
		  });
		  vista.btnagregar1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	String placa=vista.jtbuscar1.getText();
	            	if(!placa.equals("")) {
	            		busquedaPlaca(vista, clientes, empleado,lista, placa);
	            		vista.jtbuscar1.setText("");
	            	}	
	            }
	      });
		  vista.jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	mostrarTodo(vista, clientes, empleado,lista);
	            }    
	      });
	}

	public static void mostrarTodo(Vista_VehiculosActivos vista, Cliente cliente, Empleado empleado,
			Vehiculo_Activo lista) {

		registros = new String[lista.contadorRegistros()][10];
		ResultSet historialbd = lista.getRegistros();
		for (int i = 0; i < registros.length; i++) {
			try {
				historialbd.next();
				registros[i][0] = String.valueOf(i + 1);
				registros[i][1] = cliente.getNombre((historialbd.getInt("id_cliente")));
				registros[i][2] = cliente.getApellido((historialbd.getInt("id_cliente")));
				registros[i][3] = String.valueOf(historialbd.getInt("id_registro"));
				registros[i][4] = new Vehiculo().getTipoVehiculo(historialbd.getInt("id_cliente"));
				registros[i][5] = new Cliente().getPlaca(historialbd.getInt("id_cliente"));
				registros[i][6] = historialbd.getString("hora_entrada");
				registros[i][7] = String.valueOf(historialbd.getInt("dia"));
				registros[i][8] = String.valueOf(historialbd.getInt("mes"));
				registros[i][9] = String.valueOf(historialbd.getInt("ano"));

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCliente.setModel(new javax.swing.table.DefaultTableModel(registros,  new String [] {
                "Numero", "Nombre", "Apellido", "Id_Registro","Tipo_Vehiculo", "Placa", "Hora Entrada", "Dia", "Mes", "Año"
            }));

	}
	public static void busquedaPlaca(Vista_VehiculosActivos vista, Cliente cliente, Empleado empleado,
			Vehiculo_Activo lista, String placa) {

		registros = new String[lista.contadorRegistros()][10];
		ResultSet historialbd = lista.getRegistros();
		for (int i = 0; i < registros.length; i++) {
			try {
				if(historialbd.next()==false) {break;}
				if (cliente.getPlaca(historialbd.getInt("id_cliente")).equalsIgnoreCase(placa)) {
				registros[i][0] = String.valueOf(i + 1);
				registros[i][1] = cliente.getNombre((historialbd.getInt("id_cliente")));
				registros[i][2] = cliente.getApellido((historialbd.getInt("id_cliente")));
				registros[i][3] = String.valueOf(historialbd.getInt("id_registro"));
				registros[i][4] = new Vehiculo().getTipoVehiculo(historialbd.getInt("id_cliente"));
				registros[i][5] = new Cliente().getPlaca(historialbd.getInt("id_cliente"));
				registros[i][6] = historialbd.getString("hora_entrada");
				registros[i][7] = String.valueOf(historialbd.getInt("dia"));
				registros[i][8] = String.valueOf(historialbd.getInt("mes"));
				registros[i][9] = String.valueOf(historialbd.getInt("ano"));
				} else {
					i--;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		vista.tblCliente.setModel(new javax.swing.table.DefaultTableModel(registros,  new String [] {
                "Numero", "Nombre", "Apellido", "Id_Registro","Tipo_Vehiculo", "Placa", "Hora Entrada", "Dia", "Mes", "Año"
            }));

	}
	

}
