package Proxy;

import java.awt.Dimension;
import java.awt.Image;

public class PictureProxy implements Media {

	Picture Pic;
	String Name;
	
	public PictureProxy(String name) {
		this.Name = name;
	}
	
	@Override
	public Image getMedia() {
		// TODO Auto-generated method stub
		
		if(Pic == null)
			Pic = new Picture(Name);
		
		return Pic.getMedia();
	}

	@Override
	public void Load(String name) {
		// TODO Auto-generated method stub
				
		Pic.Load(name);
		
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		
		if(Pic == null)
			return null;
		else
			return Pic.getDimension();
		
	}
	
	@Override
	public Double getByte() {
		return Pic.getByte();
	}

}
