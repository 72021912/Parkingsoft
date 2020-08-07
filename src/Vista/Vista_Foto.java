package Vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Vista_Foto {

	public JFrame frame;
	private ImageIcon foto;

	public Vista_Foto(ImageIcon foto) {
		this.foto=foto;
		initialize();
		frame.setLocationRelativeTo(null);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(100, 100, 572, 491);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lbl_foto = new JLabel("");
		lbl_foto.setIcon(foto);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(lbl_foto, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(lbl_foto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
		);
		
		panel.setLayout(gl_panel);
	}
}
