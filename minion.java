package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO; 

public class minion {
    static int width = 800;
    static int height = 800;
    
    static Color ama = new Color(255,196,4,255);
    static Color negro = new Color(1,0,0);
    static Color gris = new Color (189,192,190,255);
    static Color azu = new Color(41,2,255,255);  
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
        
        drawHorizontalLine(7, 13, 0, ama);  
        drawHorizontalLine(6, 14, 1, ama);
        drawHorizontalLine(5, 15, 2, ama);
       

        
        
        drawHorizontalLine(5, 15, 3, negro);
        drawHorizontalLine(5, 15, 4, negro);
        drawHorizontalLine(8, 12, 7, negro);
      
        drawHorizontalLine(5, 15, 5, ama);
        drawHorizontalLine(5, 15, 6, ama);
        drawHorizontalLine(5, 7, 7, ama);
        drawHorizontalLine(13, 15, 7, ama);
        drawHorizontalLine(5, 15, 8, ama);
        drawHorizontalLine(5, 15, 9, ama);
        drawHorizontalLine(5, 15, 10, ama);
        drawHorizontalLine(5, 15, 11, ama);
        drawHorizontalLine(5, 15, 12, ama);
        drawHorizontalLine(5, 15, 13, ama);
        drawHorizontalLine(5, 15, 14, ama);
         
        
        drawHorizontalLine(5, 5, 9, azu);
        drawHorizontalLine(15, 15, 9, azu);

        drawHorizontalLine(6, 14, 10, azu);
        drawHorizontalLine(7, 13, 11, azu);
        drawHorizontalLine(7, 13, 12, azu);
        drawHorizontalLine(7, 13, 13, azu);
        drawHorizontalLine(6, 14, 14, azu);
        drawHorizontalLine(6, 14, 15, azu);
        drawHorizontalLine(6, 14, 16, azu);
        
        drawHorizontalLine(4, 5, 14, negro);
        drawHorizontalLine(15, 16, 14, negro); 
        drawHorizontalLine(4, 5, 15, negro); 
        drawHorizontalLine(15, 16, 15, negro);
        drawHorizontalLine(15, 15, 16, negro);
        drawHorizontalLine(5, 5, 16, negro);
        
        
        drawHorizontalLine(8, 9, 17, negro);
        drawHorizontalLine(11, 12, 17, negro);
        drawHorizontalLine(7, 9, 18, negro);
        drawHorizontalLine(11, 13, 18, negro);
        
        
        putPixel(7,3,gris);
        putPixel(7,4,gris);
        putPixel(13,3,gris);
        putPixel(13,4,gris);
        
        putPixel(8,3,blanco);
        putPixel(8,4,blanco);
        putPixel(12,3,blanco);
        putPixel(12,4,blanco);
        
        putPixel(9,2,blanco);
        putPixel(9,5,blanco);
        putPixel(10,2,blanco);
        putPixel(10,5,blanco);
        putPixel(11,2,blanco);
        putPixel(11,5,blanco);
        
        

       
        
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