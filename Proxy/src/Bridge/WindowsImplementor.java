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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Proxy.PictureProxy;


public class WindowsImplementor implements WindowImplementor {

	JFrame frame;
	
	JLabel Close;
	JLabel FullSize;
	JLabel Minimize;
	
	JLabel hello;
	Timer t;
	int fade_time;
	
	ArrayList<PictureProxy> proxyList;
	int indexSelectedImage;
	
	Dimension position;
	Dimension dimension;
	
	int minWidth = 1100;
	int minHeight = 800;
	
	public WindowsImplementor()
	{
		
	}
	public void draw(int x, int y)
	{
		init(x, y);
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
            		refreshPercentage((int)frame.getMinimumSize().getWidth(), (int)frame.getMinimumSize().getHeight());
            		
                	frame.setExtendedState(frame.NORMAL);
            	}
            	else
            	{
            		refreshPercentage((int)frame.getMaximizedBounds().getWidth(), (int)frame.getMaximizedBounds().getHeight());
            		frame.setExtendedState(frame.MAXIMIZED_BOTH);
            	}
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
		Title.setName("Title");
		frame.getContentPane().add(Title);

	}
	
	public void drawButton(int x, int y, int width, int height, String text)
	{

        
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
		
		

	}
	
	public void drawLoadButton(int x, int y, int width, int height, String text) {
		
		position = getPosition(x, y, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		dimension = getPosition(width, height, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		
		
		JButton Button2 = new JButton(text);

		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds((int)position.getWidth(), (int)position.getHeight(), (int)dimension.getWidth(), (int)dimension.getHeight());
        Button2.setIconTextGap(-((int)dimension.getWidth()/2) - (text.length()*2));
        Button2.setText(text);
        Button2.setName("Load");
        
                
        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	loadImages();
            	showNext();
            	refreshDirectionalArrow();

            }  
        }); 
        

		frame.getContentPane().add(Button2);
		
	}
	public void drawPreviousButton(int x, int y, int width, int height, String text, boolean visible) {
		
		
		position = getPosition(x, y, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		dimension = getPosition(width, height, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\sx_white.png").getImage(), (int)dimension.getWidth(), (int)dimension.getHeight()));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds((int)position.getWidth(), (int)position.getHeight(), (int)dimension.getWidth(), (int)dimension.getHeight());
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setText(text);
        Button2.setName("Previous");
        Button2.setVisible(visible);
                
        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	showPrevious();            
            }  
        }); 
        

		frame.getContentPane().add(Button2);
		
	}
	public void drawLabel(int x, int y, int width, int height, String text, boolean visible, String Name) {
	
		position = getPosition(x, y, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		dimension = getPosition(width, height, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		
		JLabel Button2 = new JLabel();
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds((int)position.getWidth(), (int)position.getHeight(), (int)dimension.getWidth(), (int)dimension.getHeight());
        Button2.setText(text);
        Button2.setName(Name);
        Button2.setVisible(visible);
        Button2.setForeground(new Color(255,255,255));
        Button2.setFont(new Font("KG Always A Good Time", Font.PLAIN,15));

        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	          
            }  
        }); 

		frame.getContentPane().add(Button2);
	
	}
	
	public void drawNextButton(int x, int y, int width, int height, String text, boolean visible) {
		
		position = getPosition(x, y, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		dimension = getPosition(width, height, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		
		ImageIcon closeImgResized = new ImageIcon(getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MacIcon\\dx_white.png").getImage(), (int)dimension.getWidth(), (int)dimension.getHeight()));
		JLabel Button2 = new JLabel(closeImgResized);
		Button2.setHorizontalAlignment(SwingConstants.CENTER);
        Button2.setBounds((int)position.getWidth(), (int)position.getHeight(), (int)dimension.getWidth(), (int)dimension.getHeight());
        Button2.setIconTextGap(-(width/2) - (text.length()*2));
        Button2.setText(text);
        Button2.setName("Next");
        Button2.setVisible(visible);

        Button2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	showNext();          
            }  
        }); 
        

		frame.getContentPane().add(Button2);
	
	}
	
	public void showNext()
	{	
		if(indexSelectedImage < proxyList.size()-1)
		{
			indexSelectedImage++;
			showImage(indexSelectedImage);
        	refreshDirectionalArrow();

		}
	}
	
	public void showPrevious()
	{	
		if(indexSelectedImage > 0)
		{
			indexSelectedImage--;
			showImage(indexSelectedImage);
        	refreshDirectionalArrow();

		}
	}
	
	
	public void init(int x, int y)
	{
		indexSelectedImage = -1;

		frame = new JFrame();
		
		frame.getContentPane().setBackground(new Color(40,40,40));
		//frame.setResizable(false);

		int maxWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int maxHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
		
		frame.setMaximizedBounds(new Rectangle(maxWidth, maxHeight));
		frame.setMinimumSize(new Dimension(minWidth, minHeight));
		
		frame.setBounds(x, y, minWidth, minHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setUndecorated(true);
	    
	    frame.setVisible(true);
	    
	    JLabel image =new JLabel();
        image.setName("Preview");           
        
        // Set the text position bottom center relative
        // to the icon so that the icon appears as a
        // a desktop icon
        image.setVerticalAlignment(SwingConstants.CENTER);
        image.setHorizontalAlignment(SwingConstants.CENTER);
        
        position = getPosition(14,16, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
        dimension = getPosition(73, 72, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
        
        image.setBounds((int)position.getWidth(), (int)position.getHeight() , (int)dimension.getWidth(), (int)dimension.getHeight());
                
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

	public Dimension getPosition(int WidthPercentage, int HeightPercentage, int frameWidth, int frameHeight)
	{
		int width = (frameWidth / 100) * WidthPercentage;
		int height = (frameHeight / 100) * HeightPercentage;
		return new Dimension(width, height);
	}
	public Dimension getPercentage(int Width, int Height)
	{

		int PercWidth =(int) Math.round((((double)Width / (double)frame.getBounds().getWidth()) * 100));
		int PercHeight = (int) Math.round((((float)Height / (float)frame.getBounds().getHeight()) * 100));

		return new Dimension(PercWidth, PercHeight);
	}
	public void showImage(int index)
	{
		
		for (Component jc : frame.getContentPane().getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                if(label.getName() != null )
                {
                	if(label.getName().equals("Preview"))
                	{
                        dimension = getPosition(73, 72, (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
                		label.setIcon(new ImageIcon(proxyList.get(index).getMedia().getScaledInstance((int)dimension.getWidth(), (int)dimension.getHeight(), Image.SCALE_DEFAULT)));
                	}
                	else if(label.getName().equals("Name"))
                	{
                		label.setVisible(true);
                		label.setText("Nome: " + proxyList.get(index).getName());
                	}
                	else if(label.getName().equals("Size"))
                	{
                		label.setVisible(true);
                		
                		label.setText("Size: " + String.valueOf((float)Math.round(proxyList.get(index).getByte() * 100)/100) + " Mb");
                	}
                	else if(label.getName().equals("Resolution"))
                	{
                		label.setVisible(true);
                		label.setText("Risoluzione: " + Math.round(proxyList.get(index).getDimension().getWidth()) + "x" + Math.round(proxyList.get(index).getDimension().getHeight()) + " px");
                	}
                }
            }
		}  
        
	}
	private void refreshPercentage(int newWidth, int newHeight)
	{
		for (Component jc : frame.getContentPane().getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                if(label.getName() != null )
                {
                	Dimension percentageDimension = getPercentage((int)label.getBounds().getWidth(), (int)label.getBounds().getHeight());
                	Dimension percentagePosition = getPercentage((int)label.getBounds().getX(), (int)label.getBounds().getY());

                	
                	Dimension newDimension = getPosition((int)percentageDimension.getWidth(), (int)percentageDimension.getHeight(), newWidth, newHeight);
                	Dimension newPosition = getPosition((int)percentagePosition.getWidth(), (int)percentagePosition.getHeight(), newWidth, newHeight);
                	
                	System.out.println(label.getName());
                	System.out.println("Position: " + newPosition.getWidth() + "x" + newPosition.getHeight());
                	System.out.println("Dimension: " + newDimension.getWidth() + "x" + newDimension.getHeight());

                	label.setBounds((int)newPosition.getWidth(), (int)newPosition.getHeight(), (int)newDimension.getWidth(), (int)newDimension.getHeight());
                	
                	
                }
            }
		}  
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
	public void refreshDirectionalArrow()
	{
		
		for (Component jc : frame.getContentPane().getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                //System.out.println(label.getName());
                if(label.getName() != null )
                {
                	if(label.getName().equals("Next"))
                	{
                		if(indexSelectedImage == proxyList.size()-1)
                			label.setVisible(false);
                		else
                			label.setVisible(true);
                	}
                	else if(label.getName().equals("Previous"))
                	{
                		if(indexSelectedImage == 0)
                			label.setVisible(false);
                		else
                			label.setVisible(true);
                	}
                }
            }
		}
		
        
	}
}
