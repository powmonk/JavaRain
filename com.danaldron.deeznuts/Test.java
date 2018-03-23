package com.danaldron.deeznuts;


import java.awt.BorderLayout;
import java.awt.Color;                                                                                                                                        
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;                                                                                                                                    
import javax.swing.JPanel;

                                                                                                                                                              
final public class Test                                                                                                                                       
{                                                                                                                                                             
                                                                                                                                                              
    static JFrame frame;                                                                                                                                             
    DrawPanel drawPanel;        
    static int swayAmount  = 40;
    static int swayDir = 1;
                                        
    static int frameSize = 500; 
    
    static ArrayList<Particle> shower = new ArrayList<Particle>();

    int oneX = 0;                                                                                                                                             
    int oneY = 0;                                                                                                                                             
                                                                                                                                                              
    boolean up = false;                                                                                                                                       
    boolean down = true;                                                                                                                                      
    boolean left = false;                                                                                                                                     
    boolean right = true;                                                                                                                                     
                                                                                                                                                              
    public static void main(String[] args)                                                                                                                    
    {                                 
        System.out.println(shower.size());
        //System.out.println(shower.size());
    	new Test().go();                                                                                                                                      
    }                                                                                                                                                         
                                                                                                                                                              
    private void go()                                                                                                                                         
    {                                                                                                                                                         
        frame = new JFrame("Test");                                                                                                                           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                                                 
                                                                                                                                                              
        drawPanel = new DrawPanel();                                                                                                                          
                                                                                                                                                              
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);                                                                                           
                                                                                                                                                              
        //frame.setResizable(false);                  
        frame.setBackground(Color.BLUE);
        frame.setSize(frameSize, frameSize);                                                                                                                            
        frame.setLocationByPlatform(true);                                                                                                                    
        frame.setVisible(true);                                                                                                                               
        moveIt();                                         
        
    }                                                                                                                                                         
                                                                                                                                                              
    class DrawPanel extends JPanel                                                                                                                            
    {                                                                                                                                                         
        private static final long serialVersionUID = 1L;                                                                                                      
                                                                                                                                                              
        public void paintComponent(Graphics g)                                                                                                                
        {                                                                                                                                                     
        	int ovalSize = 3;                                                                                                                                 
        	//int sizes = 500;
        	
		    //g.setColor(Color.black);  
		    //g.fillOval(50,oneY,50,50);
	        //g.fillOval(frameSize / 2,oneY,ovalSize,ovalSize);                                                                                                        
        	//                                                                                                                                                
        	//                                                                                                                                                
        	//                                                                                                                                                
	        //g.fillOval(frame.getHeight() / 2, frame.getWidth() / 2, 20, 20);                                                                                
	                                                                                                                                                          
        	for(Particle rainDrop: shower){                                                                                                                
//    		    g.setColor(Color.WHITE, 0);
        		g.setColor(new Color(255,255,255,200));
    	        g.fillOval(rainDrop.getX() + rainDrop.getSway(),rainDrop.getY(),ovalSize,ovalSize);                 
    	        System.out.print(rainDrop.getSway() + ", ");
        	}       	
        	System.out.println("");
		     //g.setColor(Color.red);                                                                                                                           
	         //g.fillOval(oneX-sizes/4,oneY+sizes/2,ovalSize,ovalSize);                                                                                         
		     //g.setColor(Color.blue);                                                                                                                          
	         //g.fillOval(oneX-(sizes/4)*2,oneY+sizes/2,ovalSize,ovalSize);                                                                                     
		     //g.setColor(Color.yellow);                                                                                                                        
	         //g.fillOval(oneX-(sizes/4)*3,oneY+sizes/2,ovalSize,ovalSize);                                                                                     
		     //g.setColor(Color.green);                                                                                                                         
	         //g.fillOval(oneX-(sizes/4)*4,oneY+sizes/2,ovalSize,ovalSize);                                                                                     
		     //g.setColor(Color.black);
	         //g.fillOval(oneX,oneY+sizes/2,ovalSize,ovalSize);
        }                                                                                                                                                     
    }                                                                                                                                                         
                                                                                                                                                              
                                                                                        
    private void initRain(){                     
    	/*
    	for(int i=0;i<=shower.length;i++){
    		shower[i].setX(dansRand());
    		shower[i].setY(dansRand());
    	}
    	  */
    	if(shower.size() == 0){
	    	for(int i=0;i<100;i++){
	    		Particle a = new Particle();
	    		a.setX(dansRand("X"));
	    		a.setY(dansRand("Y"));
	    		a.setSway(dansRand("sway"));
	    		shower.add(a);
	    	}
    	}else{
    		for(Particle rainDrop : shower){
    			rainDrop.setX(dansRand("X"));
    			rainDrop.setY(dansRand("Y"));
    		}
    	}
    }                                                                                                                                                         
                                       
    
    static public int dansRand(String dim){
    	int dimension = 0;
    	switch (dim){
    		case "X":
    			dimension = frame.getWidth();
    			break;
    		case "Y":
    			dimension = frame.getHeight();
    			break;
    		case "sway":
    			dimension = swayAmount;
    			break;
    		case "Z":
    			break;
    	}
    	return (int)(Math.random()*dimension);
    		
    }
                                                                                                                                                              
    private void moveIt(){       
    	int prevSize = 0 ;
    	int currSize = frame.getHeight() + frame.getWidth();
	                                                                                                                                                          
//    	initRain();                                                                                                                                           
    	                                                                                                                                                      
	    oneX = 500;                                                                                                                          
        while (true){                                                                                                                                         
        	if(prevSize != currSize){
        		currSize = prevSize;
        		initRain();
        	}
        	
        	oneY++;                                                                                                                                           
        	                                                                                                                                                  
        	if(oneY > frameSize ){                                                                                                                    
        		oneY = 0;                                                                                                                                      
        	}
        	
        	for(Particle rainDrop:shower){         
    
        		if( rainDrop.getY() < frame.getHeight() ){
        			rainDrop.setY(rainDrop.getY() + 1);
        		}else{
        			rainDrop.setY(0);
        			rainDrop.setX(dansRand("X"));
        		}
        		
        		
        		//
        		
        		rainDrop.setSway(rainDrop.getSway() + swayDir);

        		if(rainDrop.getSway() > swayAmount){
        			swayDir = -1;
        		}

        		if(rainDrop.getSway() < 0){
        			swayDir = +1;
        		}
        		
        		
        		
        		//This is the falling bit 
        		rainDrop.setY(rainDrop.getY() + 1 );
        		
        	}
        	
        	try{                                                                                                                                                 
        		Thread.sleep(15);                                                                                                                             
            }                                                                                                                                                 
            catch (Exception e){                                                                                                                                                 
                e.printStackTrace();                                                                                                                          
            }                   
        	
            frame.repaint();         
            
        	prevSize = frame.getHeight() + frame.getWidth();

        }                                                                                                                                                     
    }                                                                                                                                                         
}                                                                                                                                                             
