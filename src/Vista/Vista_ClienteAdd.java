
package Vista;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;


public class Vista_ClienteAdd extends javax.swing.JFrame {
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField apellido;
    public javax.swing.JButton btnaceptar;
    public javax.swing.JButton btnbus;
    public javax.swing.JButton btncamioneta;
    public javax.swing.JButton btncancelar;
    public javax.swing.JButton btncarro;
    public javax.swing.JButton btnmoto;
    public javax.swing.JTextField celular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField nombre;
    public javax.swing.JTextField placa;
    public JTextField tipo;
    // End of variables declaration//GEN-END:variables

    public Vista_ClienteAdd() {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_ClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_ClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_ClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_ClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnbus = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btncarro = new javax.swing.JButton();
        apellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        placa = new javax.swing.JTextField();
        btnmoto = new javax.swing.JButton();
        btncamioneta = new javax.swing.JButton();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 153));
        setMaximumSize(new java.awt.Dimension(773, 642));
        setMinimumSize(new java.awt.Dimension(773, 642));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(773, 642));
        jPanel1.setMinimumSize(new java.awt.Dimension(773, 642));
        jPanel1.setPreferredSize(new java.awt.Dimension(773, 642));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("ELIGE EL TIPO DE AUTO");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("REGISTRO DE VEHICULO");

        btnbus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/bus96.png"))); // NOI18N
        btnbus.setToolTipText("");
        btnbus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbus.setInheritsPopupMenu(true);
        btnbus.setMaximumSize(new java.awt.Dimension(105, 81));
        btnbus.setMinimumSize(new java.awt.Dimension(105, 81));
        btnbus.setPreferredSize(new java.awt.Dimension(105, 81));
        btnbus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/bus96.png"))); // NOI18N
        btnbus.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/bus128.png"))); // NOI18N
        btnbus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        nombre.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NOMBRES :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("APELLIDOS :");

        btncarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/car96.png"))); // NOI18N
        btncarro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncarro.setInheritsPopupMenu(true);
        btncarro.setMaximumSize(new java.awt.Dimension(105, 81));
        btncarro.setMinimumSize(new java.awt.Dimension(105, 81));
        btncarro.setPreferredSize(new java.awt.Dimension(105, 81));
        btncarro.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/car96.png"))); // NOI18N
        btncarro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/car128.png"))); // NOI18N
        btncarro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        apellido.setBackground(new java.awt.Color(255, 204, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CELULAR :");

        celular.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PLACA :");

        placa.setBackground(new java.awt.Color(255, 204, 204));

        btnmoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/moto96.png"))); // NOI18N
        btnmoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnmoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnmoto.setInheritsPopupMenu(true);
        btnmoto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/moto96.png"))); // NOI18N
        btnmoto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/moto128.png"))); // NOI18N
        btnmoto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btncamioneta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/camion96.png"))); // NOI18N
        btncamioneta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncamioneta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncamioneta.setInheritsPopupMenu(true);
        btncamioneta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/camion96.png"))); // NOI18N
        btncamioneta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/camion128.png"))); // NOI18N
        btncamioneta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnaceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/aceptar72.png"))); // NOI18N
        btnaceptar.setContentAreaFilled(false);
        btnaceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnaceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnaceptar.setInheritsPopupMenu(true);
        btnaceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/aceptar72.png"))); // NOI18N
        btnaceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/aceptar96.png"))); // NOI18N
        btnaceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/cancelar72.png"))); // NOI18N
        btncancelar.setContentAreaFilled(false);
        btncancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/cancelar72.png"))); // NOI18N
        btncancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/cancelar96.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("TIPO:");
        
        tipo = new JTextField();
        tipo.setColumns(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(50)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(btncarro, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btncamioneta, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnmoto, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnbus, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
        			.addGap(93)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(btnaceptar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btncancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        						.addGap(90))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        						.addComponent(celular, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jLabel3)
        					.addComponent(tipo, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
        				.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        				.addComponent(apellido, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1)
        				.addComponent(placa, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(24)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel4)
        					.addGap(18)
        					.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(apellido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel8)
        					.addGap(18)
        					.addComponent(celular, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel7))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel2)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnbus, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        							.addGap(157))
        						.addComponent(btncarro, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(4)
        					.addComponent(placa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel3)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(tipo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        					.addGap(24)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnaceptar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btncancelar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(btncamioneta, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnmoto, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
