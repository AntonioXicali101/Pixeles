package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;  

public class pollo {
    static int width = 800;
    static int height = 800;
    
    static Color ama = new Color(254,241,2,255);
    static Color na = new Color (250,144,13,255);
    static Color negro = new Color(0,0,3,255);
    

    
    static Graphics2D g;

    static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
    // Definimos el tamaÃ±o del pixel y la matriz de colores
    private final static int PIXEL_SIZE = 40;
    
    private final static Color[][] PIXELS = {
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}
    };
    
    public static void paint() {
    	drawBackground(PIXEL_SIZE, Color.white);     
        
    	drawHorizontalLine(10, 11, 2, ama); 
    	drawHorizontalLine(8, 9, 3, ama); 
    	drawHorizontalLine(5, 14, 4, ama); 
    	drawHorizontalLine(5, 14, 5, ama); 
    	drawHorizontalLine(5, 14, 6, ama); 
    	drawHorizontalLine(5, 14, 7, ama); 
    	drawHorizontalLine(5, 14, 8, ama); 
    	drawHorizontalLine(5, 14, 9, ama); 
    	drawHorizontalLine(2, 17, 10, ama); 
    	drawHorizontalLine(2, 17, 11, ama); 
    	drawHorizontalLine(5, 14, 12, ama); 
    	drawHorizontalLine(5, 14, 13, ama); 
    	drawHorizontalLine(5, 14, 14, ama); 
    	drawHorizontalLine(5, 14, 15, ama);
    	
    	drawHorizontalLine(7, 8, 16, na); 
    	drawHorizontalLine(7, 8, 17, na);
    	drawHorizontalLine(7, 8, 18, na);
    	drawHorizontalLine(11, 12, 16, na); 
    	drawHorizontalLine(11, 12, 17, na);
    	drawHorizontalLine(11, 12, 18, na);
    	
    	drawHorizontalLine(8, 11, 9, na);
    	
    	drawHorizontalLine(6, 7, 7, negro);
    	drawHorizontalLine(6, 7, 8, negro);
    	drawHorizontalLine(12, 13, 7, negro);
    	drawHorizontalLine(12, 13, 8, negro);
        
             
       
        
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("pixel_art.jpg"));
            System.out.println("EXITO !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void drawVerticalLine(int a, int b, int x, Color c){
    	for(int i=a;i<=b;i++){
     	   g.setColor(c);
           g.fillRect(x * PIXEL_SIZE, i * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void drawHorizontalLine(int a, int b, int y, Color c){
        for(int i=a;i<=b;i++){
     	   g.setColor(c);
           g.fillRect(i * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void putPixel(int x, int y, Color c){       
	   g.setColor(c);
	   g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);    
    }
    
    private static void fillRect(int x, int y, int width, int height, Color c){
    	g.setColor(c);
    	g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, width*PIXEL_SIZE, height*PIXEL_SIZE);
    }
    
    private static void drawSquareGrid(int size, Color c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                
                g.setColor(c);
                g.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }
    private static void drawBackground(int size, Color c) {
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.setColor(c);
                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
            }
        }
    }
    
    
    public static void main(String[] args) {
        g = image.createGraphics();        
        paint();
    }
}