package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class pacman {
    static int width = 800;
    static int height = 800;
    
    static Color amarillo = new Color(250,214,3);
    static Color cafe = new Color(138,72,26);
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
        /*drawHorizontalLine(6, 10, 1, Color.black);
        drawHorizontalLine(5, 12, 2, Color.black);
        drawHorizontalLine(4, 13, 3, Color.black);
        drawHorizontalLine(4, 14, 4, Color.black);
        drawHorizontalLine(4, 15, 5, Color.black);
        drawHorizontalLine(3, 15, 6, Color.black);
        drawHorizontalLine(2, 15, 7, Color.black);
        drawHorizontalLine(1, 14, 8, Color.black);
        fillRect(1, 9, 13, 6, Color.black);
        drawHorizontalLine(2, 7, 15, Color.black);
        fillRect(10, 15, 4, 2, Color.black);
        drawHorizontalLine(4, 7, 16, Color.black);
        drawHorizontalLine(5, 6, 17, Color.black);
        drawHorizontalLine(11, 12, 17, Color.black);*/
        drawHorizontalLine(7, 13, 3, negro);
        drawHorizontalLine(7,13,15,negro);
        drawVerticalLine(6,12,3, negro);
        drawHorizontalLine(5,6,4,negro);
        drawHorizontalLine(16,17,5,negro);
        drawHorizontalLine(4,5,5,negro);
        drawHorizontalLine(4,5,13,negro);
        drawHorizontalLine(5,6,14,negro);
        drawHorizontalLine(14, 15, 4, negro);
        
        
        
        drawHorizontalLine(15,16,6,negro);
        drawHorizontalLine(14,15,7,negro);
        drawHorizontalLine(13,14,8,negro);
        drawHorizontalLine(13,13,9,negro);
        drawHorizontalLine(13,14,10,negro);
        drawHorizontalLine(14,15,11,negro);
        drawHorizontalLine(15,16,12,negro);
        drawHorizontalLine(16,17,13,negro);
        drawHorizontalLine(14,15,14,negro);
        
        
        
        drawHorizontalLine(7,13,4,amarillo);
        drawHorizontalLine(6,15,5,amarillo);
        drawHorizontalLine(4,14,6,amarillo);
        drawHorizontalLine(4,13,7,amarillo);
        drawHorizontalLine(4,13,8,amarillo);
        drawHorizontalLine(4,12,9,amarillo);
        drawHorizontalLine(4,13,10,amarillo);
        
        drawHorizontalLine(4,13,11,amarillo);
        drawHorizontalLine(4,14,12,amarillo);
        drawHorizontalLine(6,15,13,amarillo);
        drawHorizontalLine(7,13,14,amarillo);
        
        
        drawHorizontalLine(9,10,6,negro);
        drawHorizontalLine(11,11,6,blanco);
        drawHorizontalLine(9,11,7,negro);
        
        
        
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