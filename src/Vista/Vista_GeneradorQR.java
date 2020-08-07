
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;

import javax.swing.ImageIcon;

import Controlador.Controlador_Caja;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class Vista_GeneradorQR extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    public javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel lblImagen;
    private String texto;
    // End of variables declaration 
    
    public Vista_GeneradorQR(String texto) {
    	this.texto=texto;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

 
    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(Color.PINK);
        btnAceptar = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        btnAceptar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new Font("Arial Narrow", Font.BOLD, 29)); // NOI18N
        jLabel1.setText("Codigo QR");
        
        ByteArrayOutputStream out = QRCode.from(texto).to(ImageType.PNG).stream();
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        Image img = imageIcon.getImage();
        Image newimg = img.getScaledInstance(210,200, java.awt.Image.SCALE_SMOOTH);
        
        ImageIcon icono = new ImageIcon(newimg);
        lblImagen.setIcon(icono);
        
        jTextArea1.setText(texto);
        
        btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();	
			}
		});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(135)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 162, Short.MAX_VALUE)
        			.addGap(127))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(0, 111, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lblImagen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
        			.addGap(103))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(162)
        			.addComponent(btnAceptar)
        			.addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
        			.addGap(34)
        			.addComponent(btnAceptar)
        			.addGap(23))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                                       
}

