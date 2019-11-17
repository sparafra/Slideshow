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
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Proxy.PictureProxy;


public class MacImplementor implements WindowImplementor {

	JFrame frame;
	
	JLabel hello;
	//JLabel image;

	Timer t;
	int fade_time;
	
	ArrayList<PictureProxy> proxyList;
	int indexSelectedImage;
	
	public MacImplementor()
	{
		init();
	}
	
	public void drawBar() {
		// TODO Auto-generated method stub
		
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\Red.png").getImage(), 15, 15));
		JLabel Close = new JLabel(closeImgResized);
		Close.setHorizontalAlignment(SwingConstants.LEFT);
        Close.setBounds(13, 10, 15, 15);

        
		ImageIcon fullImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\Yellow.png").getImage(), 15, 15));
		JLabel FullSize = new JLabel(fullImgResized);
		FullSize.setHorizontalAlignment(SwingConstants.LEFT);
        FullSize.setBounds(40, 10, 15, 15);
        

		ImageIcon minimizeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\Green.png").getImage(), 15, 15));
		JLabel Minimize = new JLabel(minimizeImgResized);
		Minimize.setHorizontalAlignment(SwingConstants.LEFT);
		Minimize.setBounds(67, 10, 15, 15);
        
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
		
		JLabel Title = new JLabel("Mac Window");
		Title.setHorizontalAlignment(SwingConstants.LEFT);
		Title.setBounds(94, 10, 150, 15);
		Title.setForeground(Color.WHITE);;
		
		frame.getContentPane().add(Title);

	}
	
	public void drawButton(int x, int y, int width, int height, String text)
	{
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\Button.png").getImage(), width, height));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds(x, y, width, height);
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setFont(new Font(Font.SERIF, Font.PLAIN,40));
        Button2.setText(text);
        
        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	            	
            	// Create a JLabel
                hello=new JLabel("hello");
                
                // Set the text position bottom center relative
                // to the icon so that the icon appears as a
                // a desktop icon
                hello.setVerticalAlignment(SwingConstants.CENTER);
                hello.setHorizontalAlignment(SwingConstants.CENTER);
        		hello.setBounds(frame.getBounds().width/2 - 100, frame.getBounds().height/2 - 75, 200, 150);

                // Set the icon to the JLabel
                //l.setIcon(icon);
                
                // Set foreground
                hello.setForeground(new Color(255,255,255));
                
                hello.setOpaque(true);
                
                // Set some font
                hello.setFont(new Font("KG Always A GoodTime", Font.PLAIN,40));
                //hello.setFont(new Font("Across the Road",Font.PLAIN, 40));

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
        
        
     
        
        
        
        /*
		JButton Button = new JButton(text);
		Button.setHorizontalAlignment(SwingConstants.LEFT);
        Button.setBounds(x, y, width, height);
        
		frame.getContentPane().add(Button);
		*/
		frame.getContentPane().add(Button2);

	}

	public void drawLoadButton(int x, int y, int width, int height, String text)
	{
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\Button.png").getImage(), width, height));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds(x, y, width, height);
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setText(text);
        
                
        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	loadImages();            
            }  
        }); 
        

        /*
		JButton Button = new JButton(text);
		Button.setHorizontalAlignment(SwingConstants.LEFT);
        Button.setBounds(x, y, width, height);
        
		frame.getContentPane().add(Button);
		*/
		frame.getContentPane().add(Button2);

	}

	public void drawNextButton(int x, int y, int width, int height, String text)
	{
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\dx_white.png").getImage(), width, height));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds(x, y, width, height);
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setText(text);
        
                
        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	showNext();          
            }  
        }); 
        

        /*
		JButton Button = new JButton(text);
		Button.setHorizontalAlignment(SwingConstants.LEFT);
        Button.setBounds(x, y, width, height);
        
		frame.getContentPane().add(Button);
		*/
		frame.getContentPane().add(Button2);

	}
	
	public void drawPreviousButton(int x, int y, int width, int height, String text)
	{
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\sx_white.png").getImage(), width, height));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds(x, y, width, height);
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setText(text);
        
                
        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	showPrevious();            
            }  
        }); 
        

        /*
		JButton Button = new JButton(text);
		Button.setHorizontalAlignment(SwingConstants.LEFT);
        Button.setBounds(x, y, width, height);
        
		frame.getContentPane().add(Button);
		*/
		frame.getContentPane().add(Button2);

	}
	
	public void showNext()
	{	
		if(indexSelectedImage < proxyList.size()-1)
		{
			indexSelectedImage++;
			showImage(indexSelectedImage);
		}
	}
	
	public void showPrevious()
	{	
		if(indexSelectedImage > 0)
		{
			indexSelectedImage--;
			showImage(indexSelectedImage);
		}
	}
	
	public void init()
	{
		indexSelectedImage = -1;
		
		frame = new JFrame();
		
		frame.getContentPane().setBackground(new Color(40,40,40));
		//frame.setResizable(false);

		int maxWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int maxHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
		int minWidth = 1100;
		int minHeight = 700;
		frame.setMaximizedBounds(new Rectangle(maxWidth, maxHeight));
		frame.setMinimumSize(new Dimension(minWidth, minHeight));
		
		frame.setBounds(100, 100, minWidth, minHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setUndecorated(true);
	    
	    frame.setVisible(true);
	    
	    
	 // Create a JLabel
    	JLabel image =new JLabel();
        image.setName("Preview");           
        
        // Set the text position bottom center relative
        // to the icon so that the icon appears as a
        // a desktop icon
        image.setVerticalAlignment(SwingConstants.CENTER);
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setBounds(frame.getBounds().width/7, frame.getBounds().height/6 , 800, 500);
                
        image.setOpaque(true);
        
        // Set some font

        image.setBackground(new Color(40,40,40));
        // Add the JLabel
        frame.getContentPane().add(image);
        frame.repaint();
		
	}

	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

	private void loadImages()
	{
		ArrayList<String> files = getFilesName(System.getProperty("user.dir")+"\\Images\\Media");
		
		System.out.println(files.size());
		
		proxyList = new ArrayList<>();
		for(int k=0; k<files.size(); k++)
			proxyList.add(new PictureProxy(files.get(k)));
		
		System.out.println("End");

    	
	}
	
	private static ArrayList<String> getFilesName(String Path)
	{
		ArrayList<String> files = new ArrayList<>();
		File directory = new File(Path);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList)
        {
        	if (file.isFile())
            {
        		files.add(file.getName());
        		System.out.println(file.getName());
            }
        }
        return files;
	}
	
	
	
	public void showImage(int index)
	{
		
		for (Component jc : frame.getContentPane().getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                //System.out.println(label.getName());
                if(label.getName() != null )
                {
                	if(label.getName().equals("Preview"))
                	{
                		label.setIcon(new ImageIcon(proxyList.get(index).getMedia().getScaledInstance(800, 500, Image.SCALE_DEFAULT)));
                	}
                }
            }
		}  
        
	}
	
	
	public Dimension getPosition(int WidthPercentage, int HeightPercentage)
	{
		int width = (frame.getWidth() / 100) * WidthPercentage;
		int height = (frame.getHeight() / 100) * HeightPercentage;
		return new Dimension(width, height);
	}
	
	
}
