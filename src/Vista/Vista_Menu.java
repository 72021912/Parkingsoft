
package Vista;

public class Vista_Menu extends javax.swing.JFrame {
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ClientesAfiliados;
    public javax.swing.JButton ControlEmpleados;
    public javax.swing.JButton Caja;
    public javax.swing.JButton historial1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTnombre;
    public javax.swing.JButton login;
    public javax.swing.JButton logout;
    public javax.swing.JButton newcliente;
    public javax.swing.JButton tarivehi;
    public javax.swing.JButton vehiparque;
    // End of variables declaration//GEN-END:variables

    public Vista_Menu() {
        
        
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        tarivehi = new javax.swing.JButton();
        vehiparque = new javax.swing.JButton();
        ControlEmpleados = new javax.swing.JButton();
        newcliente = new javax.swing.JButton();
        ClientesAfiliados = new javax.swing.JButton();
        login = new javax.swing.JButton();
        Caja = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jTnombre = new javax.swing.JTextField();
        historial1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();


        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        getContentPane().setLayout(null);

        tarivehi.setBackground(new java.awt.Color(204, 204, 0));
        tarivehi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tarivehi.setText("Tarifa de Vehiculos");
 
        getContentPane().add(tarivehi);
        tarivehi.setBounds(800, 210, 280, 70);

        vehiparque.setBackground(new java.awt.Color(0, 153, 153));
        vehiparque.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vehiparque.setText("Vehiculos Parqueados");
 
        getContentPane().add(vehiparque);
        vehiparque.setBounds(260, 330, 300, 70);

        ControlEmpleados.setBackground(new java.awt.Color(204, 0, 255));
        ControlEmpleados.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ControlEmpleados.setText("Control de Empleados");

        getContentPane().add(ControlEmpleados);
        ControlEmpleados.setBounds(530, 620, 300, 70);

        newcliente.setBackground(new java.awt.Color(0, 153, 0));
        newcliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        newcliente.setText("Nuevo Cliente");
        getContentPane().add(newcliente);
        newcliente.setBounds(260, 210, 300, 70);

        ClientesAfiliados.setBackground(new java.awt.Color(255, 204, 204));
        ClientesAfiliados.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ClientesAfiliados.setText("Clientes Afiliados");

        getContentPane().add(ClientesAfiliados);
        ClientesAfiliados.setBounds(800, 460, 290, 70);

        login.setBackground(new java.awt.Color(153, 153, 255));
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/user32.png"))); // NOI18N
        getContentPane().add(login);
        login.setBounds(1070, 80, 50, 50);

        Caja.setBackground(new java.awt.Color(0, 102, 153));
        Caja.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Caja.setText("Caja");

        getContentPane().add(Caja);
        Caja.setBounds(270, 460, 300, 70);

        logout.setBackground(new java.awt.Color(255, 51, 51));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/exit32.png"))); // NOI18N

        getContentPane().add(logout);
        logout.setBounds(1150, 80, 60, 50);
        getContentPane().add(jTnombre);
        jTnombre.setBounds(1030, 140, 130, 30);

        historial1.setBackground(new java.awt.Color(153, 0, 0));
        historial1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        historial1.setText("Historial");

        getContentPane().add(historial1);
        historial1.setBounds(800, 330, 280, 70);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("SISTEMA DE PARQUEO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 80, 430, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/imagenes/main.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-130, -90, 1630, 990);

        pack();
    }
   
}