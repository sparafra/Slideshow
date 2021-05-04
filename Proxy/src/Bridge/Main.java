package Bridge;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class Main {

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Window win = new IconWindow(new WindowsImplementor());
					win.draw(400, 100);
					win.drawLoadButton(5, 5, 14, 6, "Load Image");
					win.drawPreviousButton(5, 50, 5, 7, "", false);
					win.drawNextButton(91, 50, 5, 7, "", false);
					win.drawLabel(10, 89, 30, 5, "Nome: ", false, "Name");
					win.drawLabel(10, 92, 30, 5, "Risoluzione: ", false, "Resolution");
					win.drawLabel(10, 95, 30, 5, "Size: ", false, "Size");
					

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
}
