package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class fantasma {
    static int width = 800;
    static int height = 800;
    
    static Color rojo = new Color (231,23,30,255);
    static Color negro = new Color(1,0,0);
    static Color blanco = new Color(255,255,255);
    

    
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
    	
        /*drawHorizontalLine(3, 17, 5, negro);
        drawHorizontalLine(3,17,15,negro);
        drawVerticalLine(6,14,2, negro);
        drawVerticalLine(6,14,18,negro);
        
        
        
        drawHorizontalLine(3,17,6,rojo);
        drawHorizontalLine(3,17,7,rojo);
        drawHorizontalLine(3,17,8,rojo);
        drawHorizontalLine(3,17,9,rojo);
        drawHorizontalLine(3,17,10,rojo);
        drawHorizontalLine(3,17,11,rojo);
        drawHorizontalLine(3,17,12,rojo);
        drawHorizontalLine(3,17,13,rojo);
        drawHorizontalLine(3,17,14,rojo);*/
        
    	
    	
        
    	drawVerticalLine(7,16,3, rojo);
        drawVerticalLine(7,16,4, rojo);
        drawVerticalLine(5,14,5, rojo);
        drawVerticalLine(5,14,6, rojo);
        
        drawVerticalLine(3,16,7, rojo);
        drawVerticalLine(3,16,8, rojo);
        drawVerticalLine(3,16,9, rojo);
        drawVerticalLine(3,16,10, rojo);
        drawVerticalLine(3,16,11, rojo);
         
        drawVerticalLine(5,14,12, rojo);
        drawVerticalLine(5,14,13, rojo);
        drawVerticalLine(7,16,14, rojo);
        drawVerticalLine(7,16,15, rojo);
        drawVerticalLine(7,16,16, rojo);
        
        drawVerticalLine(7,9,5, blanco);
        drawVerticalLine(7,9,6, blanco);
        drawVerticalLine(7,9,7, blanco);
        
        drawVerticalLine(7,9,11, blanco);
        drawVerticalLine(7,9,12, blanco);
        drawVerticalLine(7,9,13, blanco);
        
        drawVerticalLine(8,9,5, negro);
        drawVerticalLine(8,9,6, negro);
        
        drawVerticalLine(8,9,11, negro);
        drawVerticalLine(8,9,12, negro); 
        
        
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