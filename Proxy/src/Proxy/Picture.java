package Proxy;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Picture implements Media {

	Image img;
	String Name;
	Dimension Resolution;
	Double Byte;
	
	public Picture(String Name) {
		this.Name = Name;
	}
	
	@Override
	public Image getMedia() {
		// TODO Auto-generated method stub
		
		if(img == null)
		{
			Load(Name);
		}
		return img;

	}

	@Override
	public void Load(String name) {
		// TODO Auto-generated method stub
		BufferedImage bi;
		try {
			File f = new File(System.getProperty("user.dir")+"\\Images\\Media\\" + name);
			bi = ImageIO.read(f);
			Resolution = new Dimension(bi.getWidth(), bi.getHeight());
			double bytes = f.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			Byte = megabytes;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		img =  new ImageIcon(System.getProperty("user.dir")+"\\Images\\Media\\" + name).getImage();
		
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub

		return Resolution;
		
	}
	
	@Override
	public Double getByte() {
		return Byte;
	}
	
	@Override
	public String getName() {
		return Name;
	}

}
