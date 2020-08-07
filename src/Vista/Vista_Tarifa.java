package Vista;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Vista_Tarifa extends javax.swing.JFrame {
    public javax.swing.JButton btneditar;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
    
    public Vista_Tarifa() {
    	  try {
              for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                      javax.swing.UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          } catch (ClassNotFoundException ex) {
              java.util.logging.Logger.getLogger(Vista_Tarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              java.util.logging.Logger.getLogger(Vista_Tarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              java.util.logging.Logger.getLogger(Vista_Tarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
              java.util.logging.Logger.getLogger(Vista_Tarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        
        jScrollPane1.setViewportView(tblVehiculos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tarifa de Vehiculos");

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/cancel32.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btneliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btneditar.setBackground(new java.awt.Color(255, 255, 255));
        btneditar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/edit32.png"))); // NOI18N
        btneditar.setText("Editar");
        btneditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btneditar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnregresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/regresar (2).png"))); // NOI18N
        btnregresar.setText("Salir");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(51, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(109)
        					.addComponent(btneditar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btneliminar)
        					.addGap(77)
        					.addComponent(btnregresar)
        					.addGap(37))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(233))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))
        			.addGap(93))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(jLabel1)
        			.addGap(40)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
        			.addGap(68)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnregresar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btneditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btneliminar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }
    
}