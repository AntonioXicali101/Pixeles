package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO; 

public class fin {
    static int width = 800;
    static int height = 800;
    
    static Color carne = new Color(239,227,175,255);
    static Color negro = new Color(1,0,0);
    static Color azu = new Color(0,163,232,255);  
    static Color blanco = new Color(255,255,255,255); 
    static Color azul = new Color(64,72,202,255);  
    
    
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
        
        drawHorizontalLine(5, 7, 1, negro);  
        drawHorizontalLine(12, 14, 1, negro);
        drawHorizontalLine(8, 11, 2, negro);
             
        drawVerticalLine(2, 8, 4, negro);
        drawVerticalLine(2, 8, 15, negro);
        drawVerticalLine(9, 12, 3, negro);
        drawVerticalLine(9, 12, 16, negro);
        
        
        drawHorizontalLine(6, 13, 4, carne);
        drawHorizontalLine(6, 13, 5, carne);
        drawHorizontalLine(6, 13, 6, carne);
        drawHorizontalLine(6, 13, 7, carne);
        
        
        drawHorizontalLine(7, 8, 5, negro);
        drawHorizontalLine(7, 8, 6, negro);
        drawHorizontalLine(11, 12, 5, negro);
        drawHorizontalLine(11, 12, 6, negro);

        putPixel(12,5,blanco);
        putPixel(8,5,blanco);
        
        putPixel(4,13,negro);
        putPixel(15,13,negro);
        drawHorizontalLine(5, 14, 13, azul);
        drawHorizontalLine(6, 13, 14, azul);
        drawHorizontalLine(6, 13, 15, azul);
        drawHorizontalLine(6, 13, 16, azul);
        drawHorizontalLine(6, 13, 17, azul);
        
        putPixel(4,9,azul);
        putPixel(15,9,azul);
        drawVerticalLine(10, 12,4, carne);
        drawVerticalLine(10, 12, 15, carne);
        
        drawHorizontalLine(5, 14, 9, azu);
        drawHorizontalLine(5, 14, 10, azu);
        drawHorizontalLine(5, 14, 11, azu);
        drawHorizontalLine(5, 14, 12, azu);
        
        putPixel(5,14,negro);
        putPixel(5,15,negro); 
        putPixel(14,14,negro);
        putPixel(14,15,negro);
        putPixel(5,16,negro);
        putPixel(5,17,negro);
        putPixel(14,16,negro);
        putPixel(14,17,negro);
        
        drawHorizontalLine(6, 13, 18, negro);
        
         
        
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