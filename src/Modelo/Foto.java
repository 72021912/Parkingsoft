package Modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Foto {
	private Conexion con=new Conexion();
	private PreparedStatement prepare=null;
	private ResultSet result=null;
	
	public ImageIcon getFoto(int codigo) {
		String sqlcod="SELECT FOTO FROM HISTORIAL WHERE ID_REGISTRO = '"+codigo+"'";
		InputStream icono = null;
		ImageIcon foto=null;
		try {
			prepare=con.prepareStatement(sqlcod);
			ResultSet fotobd=prepare.executeQuery();
			fotobd.next();
			
			icono=fotobd.getBinaryStream("foto");
			foto=convertirFoto(icono);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return foto;
	}
	
	public ImageIcon convertirFoto(InputStream is) {
		
		BufferedImage bi;
		ImageIcon icono=null;
		try {
			bi = ImageIO.read(is);
			
			ImageIcon foto = new ImageIcon(bi);
	        
	        Image img = foto.getImage();
	        Image newimg = img.getScaledInstance(572, 491, java.awt.Image.SCALE_SMOOTH);
	        
	        icono = new ImageIcon(newimg);
	        
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
        return icono;
	}
}
