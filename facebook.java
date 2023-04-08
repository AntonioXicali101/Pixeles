package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO; 

public class facebook {
    static int width = 800;
    static int height = 800;
    
    static Color negro = new Color(1,0,0);
    static Color azu = new Color(20,133,208,255);  
    static Color blanco = new Color(255,255,255,255); 
      
    
    
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
        
        drawHorizontalLine(2, 17, 3, negro);  
        drawHorizontalLine(2, 17, 16, negro);
             
        drawVerticalLine(3, 15, 2, negro);
        drawVerticalLine(3, 15, 17, negro);
        
        drawHorizontalLine(3, 16, 4, azu);  
        drawHorizontalLine(3, 16, 5, azu);  
        drawHorizontalLine(3, 16, 6, azu);  
        drawHorizontalLine(3, 16, 7, azu);  
        drawHorizontalLine(3, 16, 8, azu);  
        drawHorizontalLine(3, 16, 9, azu);  
        drawHorizontalLine(3, 16, 10, azu);  
        drawHorizontalLine(3, 16, 11, azu); 
        drawHorizontalLine(3, 16, 12, azu);  
        drawHorizontalLine(3, 16, 13, azu);  
        drawHorizontalLine(3, 16, 14, azu);  
        drawHorizontalLine(3, 16, 15, azu); 

        
        drawHorizontalLine(8, 15, 10, blanco);  
        drawHorizontalLine(8, 15, 11, blanco);  
        drawHorizontalLine(13, 15, 5, blanco);  
        drawHorizontalLine(12, 15, 6, blanco);  
        
        drawHorizontalLine(10, 12, 12, blanco);  
        drawHorizontalLine(10, 12, 13, blanco);  
        drawHorizontalLine(10, 12, 14, blanco);  
        drawHorizontalLine(10, 12, 15, blanco);
        
        
        drawHorizontalLine(11, 12, 7, blanco);  
        drawHorizontalLine(10, 12, 8, blanco);  
        drawHorizontalLine(10, 12, 9, blanco);  
        drawHorizontalLine(10, 12, 10, blanco);
        
         
        
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