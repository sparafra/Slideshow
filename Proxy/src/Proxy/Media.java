package Proxy;

import java.awt.Dimension;
import java.awt.Image;

public interface Media {

	
	public Image getMedia();
	public void Load(String name);
	public Dimension getDimension();
	public Double getByte();
	public String getName();
}
