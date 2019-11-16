package Bridge;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class WindowsImplementor implements WindowImplementor {

	JFrame frame;
	
	JLabel Close;
	JLabel FullSize;
	JLabel Minimize;
	
	JLabel hello;
	Timer t;
	int fade_time;
	
	public WindowsImplementor()
	{
		init();
	}
	
	public void drawBar() {
		// TODO Auto-generated method stub
		
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\WindowsIcon\\Close.png").getImage(), 50, 30));
		Close = new JLabel(closeImgResized);
		Close.setHorizontalAlignment(SwingConstants.LEFT);
		
        Close.setBounds(frame.getSize().width - 50, 10, 50, 30);

        
		ImageIcon fullImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\WindowsIcon\\Maximize.png").getImage(), 50, 30));
		FullSize = new JLabel(fullImgResized);
		FullSize.setHorizontalAlignment(SwingConstants.LEFT);
        FullSize.setBounds(frame.getSize().width - 100, 10, 50, 30);
        

		ImageIcon minimizeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\WindowsIcon\\Minimize.png").getImage(), 50, 30));
		Minimize = new JLabel(minimizeImgResized);
		Minimize.setHorizontalAlignment(SwingConstants.LEFT);
		Minimize.setBounds(frame.getSize().width - 150, 10, 50, 30);
		
        
        
		Close.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }  
        }); 
		
		FullSize.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	if(frame.getExtendedState() == frame.MAXIMIZED_BOTH)
            	{
                	frame.setExtendedState(frame.NORMAL);
            	}
            	else
            		frame.setExtendedState(frame.MAXIMIZED_BOTH);
            	
            	Close.setBounds(frame.getSize().width - 50, 10, 50, 30);
                FullSize.setBounds(frame.getSize().width - 100, 10, 50, 30);
        		Minimize.setBounds(frame.getSize().width - 150, 10, 50, 30);

            	
            }  
        }); 
		
		Minimize.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	frame.setState(frame.ICONIFIED);
            }  
        }); 
        
		
		
		

		frame.getContentPane().add(Close);
		frame.getContentPane().add(FullSize);
		frame.getContentPane().add(Minimize);

		
	}

	public void drawTitle() {
		// TODO Auto-generated method stub
		
		JLabel Title = new JLabel("Windows 10");
		Title.setHorizontalAlignment(SwingConstants.LEFT);
		int width_title = 150;
		Title.setBounds((frame.getSize().width/2) - (width_title/2), 10, width_title, 15);
		Title.setForeground(Color.WHITE);;
		
		frame.getContentPane().add(Title);

	}
	
	public void drawButton(int x, int y, int width, int height, String text)
	{
		/*
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\Button.png").getImage(), width, height));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.LEFT);
        Button2.setBounds(x, y, width, height);
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setText(text);
        */
		
        
		JButton Button = new JButton(text);
		Button.setHorizontalAlignment(SwingConstants.CENTER);
        Button.setBounds(x, y, width, height);
        
		frame.getContentPane().add(Button);
		
		
		Button.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	            	
            	// Create a JLabel
                hello=new JLabel("Welcome, \n Windows 10");
                
                // Set the text position bottom center relative
                // to the icon so that the icon appears as a
                // a desktop icon
                hello.setVerticalAlignment(SwingConstants.CENTER);
                hello.setHorizontalAlignment(SwingConstants.CENTER);
        		hello.setBounds(frame.getBounds().width/2 - 250, frame.getBounds().height/2 - 75, 500, 150);

                // Set the icon to the JLabel
                //l.setIcon(icon);
                
                // Set foreground
                hello.setForeground(new Color(255,255,255));
                
                hello.setOpaque(true);
                
                // Set some font
                hello.setFont(new Font("KG Always A Good Time", Font.PLAIN,40));
                //hello.setFont(new Font("Myriad Pro",Font.PLAIN,40));

                hello.setBackground(new Color(40,40,40));
                // Add the JLabel
                frame.getContentPane().add(hello);
                frame.repaint();
                
                // Create a Timer with that executes
                // each 1ms
                t=new Timer(10,new ActionListener(){
                
                    public void actionPerformed(ActionEvent ae)
                    {
                        // Increase the alpha value by time
                        // so that transparency decreases for each
                        // actionPerformed() call
                    	hello.setForeground(new Color(255,255,255,fade_time++));
                    	//hello.setBackground(new Color(0,0,0,fade_time));
                        if(fade_time==255) t.stop();
                    }
                });
                
                // Set some initial delay, optional
                t.setInitialDelay(20);
                
                // Start the timer
                t.start();
                
                            
            }  
        }); 
		
		
		//frame.getContentPane().add(Button2);

	}
	
	public void drawLoadButton(int x, int y, int width, int height, String text) {
		
		
	}
	
	public void init()
	{
		
		frame = new JFrame();
		
		frame.getContentPane().setBackground(new Color(40,40,40));
		//frame.setResizable(false);

		int maxWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int maxHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
		frame.setMaximizedBounds(new Rectangle(maxWidth, maxHeight));
		frame.setMinimumSize(new Dimension(1100, 700));
		
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setUndecorated(true);
	    
	    frame.setVisible(true);
	    
		
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
