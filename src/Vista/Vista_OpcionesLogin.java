
package Vista;

public class Vista_OpcionesLogin extends javax.swing.JFrame {

	 // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBcancelar;
    public javax.swing.JButton jBcerrarsesion;
    public javax.swing.JButton jBchangeturno;
    public javax.swing.JButton jBiniciarsesion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
    public Vista_OpcionesLogin() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_OpcionesLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_OpcionesLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_OpcionesLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_OpcionesLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBiniciarsesion = new javax.swing.JButton();
        jBchangeturno = new javax.swing.JButton();
        jBcerrarsesion = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setMinimumSize(new java.awt.Dimension(433, 309));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(433, 309));
        jPanel1.setMinimumSize(new java.awt.Dimension(433, 309));
        jPanel1.setPreferredSize(new java.awt.Dimension(433, 309));

        jBiniciarsesion.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jBiniciarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/login32.png"))); // NOI18N
        jBiniciarsesion.setText("INICIAR SESION");

        jBchangeturno.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jBchangeturno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/changeuser32.png"))); // NOI18N
        jBchangeturno.setText("CAMBIO DE TURNO");

        jBcerrarsesion.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jBcerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/Logout32.png"))); // NOI18N
        jBcerrarsesion.setText("CERRAR SESION");

        jBcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recurso/imagenes/boton/cancel32.png"))); // NOI18N
        jBcancelar.setText("cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBiniciarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBchangeturno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBcerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBcancelar)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jBiniciarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBchangeturno, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBcerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jBcancelar)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
   
}
