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

	private JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Window win = new IconWindow(new MacImplementor());
					win.draw();
					//win.drawButton(100, 100, 150, 40, "Hello");
					win.drawLoadButton(50, 50, 150, 40, "Load Image");
					win.drawPreviousButton(50, 300, 50, 50, "");
					win.drawNextButton(1000, 300, 50, 50, "");

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setUndecorated(true);

		
        Image background = getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\background.jpg").getImage(), 1100, 700);
        ImageIcon backgroundResized = new ImageIcon(background);
		
		frame.getContentPane().setLayout(new BorderLayout());
		JLabel label = new JLabel(backgroundResized);
		frame.setContentPane(label);
		frame.getContentPane().setLayout(null);
		
		
		
		
	}
	
	
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

}
