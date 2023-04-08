package pixels;

import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;   
import java.io.File;
import javax.imageio.ImageIO;  
 
public class perro {
    static int width = 800;
    static int height = 800;
    
    static Color rojo = new Color(188,27,25,255);
    static Color cafe = new Color (146,81,35,255);
    static Color blanco = new Color(247,247,247,255);
    static Color negro = new Color(44,44,42,255);
    

    
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
    	drawBackground(PIXEL_SIZE, Color.yellow);     
        
    	drawHorizontalLine(7, 13, 3, cafe); 
        drawHorizontalLine(6, 14, 4, cafe);
        drawHorizontalLine(5, 15, 5, cafe);
        drawHorizontalLine(4, 16, 6, cafe);
        
        drawHorizontalLine(3, 17, 7, cafe);
        drawHorizontalLine(3, 17, 8, cafe);
        drawHorizontalLine(3, 17, 9, cafe);
        drawHorizontalLine(3, 17,10, cafe);
        drawHorizontalLine(3, 17, 11, cafe);
        drawHorizontalLine(3, 17, 12, cafe);
        drawHorizontalLine(3, 17, 13, cafe);
        drawHorizontalLine(3, 17, 14, cafe);
        drawHorizontalLine(4, 6, 15, cafe);
        drawHorizontalLine(4, 6, 16, cafe);
        drawHorizontalLine(14, 16, 15, cafe);
        drawHorizontalLine(14, 16, 16, cafe);
        
        drawHorizontalLine(9, 11, 9, blanco);
        drawHorizontalLine(9, 11, 10, blanco);
        drawHorizontalLine(7, 13, 11, blanco);
        drawHorizontalLine(7, 13, 12, blanco);
        drawHorizontalLine(7, 13, 13, blanco);
        drawHorizontalLine(7, 13, 14, blanco);
        drawHorizontalLine(8, 12, 15, blanco);
        drawHorizontalLine(8, 12, 16, blanco);
        
        drawHorizontalLine(9, 11, 17, rojo);
        drawHorizontalLine(9, 11, 18, rojo);
        
        drawHorizontalLine(9, 11, 12, negro);
        drawHorizontalLine(9, 11, 13, negro);
        drawHorizontalLine(9, 11, 14, negro);
        
        drawHorizontalLine(7, 8, 7, negro);
        drawHorizontalLine(7, 8, 8, negro);
        drawHorizontalLine(7, 8, 9, negro);
        drawHorizontalLine(7, 8, 10, negro);
        
        drawHorizontalLine(12, 13, 7, negro);
        drawHorizontalLine(12, 13, 8, negro);
        drawHorizontalLine(12, 13, 9, negro);
        drawHorizontalLine(12, 13, 10, negro);
        
        drawHorizontalLine(7, 7, 7, blanco);
        drawHorizontalLine(7, 7, 8, blanco);
        drawHorizontalLine(12, 12, 7, blanco);
        drawHorizontalLine(12, 12, 8, blanco);
       
       
        
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