package pixels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO; 

public class bmo {
    static int width = 800;
    static int height = 800;
    
    static Color rojo = new Color(218,47,91,255);
    static Color az = new Color (91,197,211,255);
    static Color ver = new Color(102,230,83,255);
    static Color azu = new Color(34,57,49); 
    static Color ama = new Color(229,203,80);
    static Color verde = new Color(206,252,212);
    static Color azul = new Color(113,164,152);
    static Color negro = new Color(1,0,0);
    static Color a = new Color(29,6,158,255);
    

    
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
        
        drawHorizontalLine(6, 14, 4, negro); 
        drawVerticalLine(5, 17, 5, negro);
        drawVerticalLine(5, 17, 15, negro);
        drawHorizontalLine(6, 14, 18, negro);
        
        drawHorizontalLine(6, 14, 5, azul);
        drawHorizontalLine(6, 14, 6, azul);
        drawHorizontalLine(6, 14, 7, azul);
        drawHorizontalLine(6, 14, 8, azul);
        drawHorizontalLine(6, 14, 9, azul);
        drawHorizontalLine(6, 14, 10, azul);
        drawHorizontalLine(6, 14, 11, azul);
        drawHorizontalLine(6, 14, 12, azul);
        drawHorizontalLine(6, 14, 13, azul);
        drawHorizontalLine(6, 14, 14, azul);
        drawHorizontalLine(6, 14, 15, azul);
        drawHorizontalLine(6, 14, 16, azul);
        drawHorizontalLine(6, 14, 17, azul);
        
        
        drawHorizontalLine(7, 13, 6, verde);
        drawHorizontalLine(7, 13, 7, verde);
        drawHorizontalLine(7, 13, 8, verde);
        drawHorizontalLine(7, 13, 9, verde);
        drawHorizontalLine(7, 13, 10, verde);
        
        drawHorizontalLine(7, 11, 12, azu);
        
        putPixel(8,14,ama); 
        putPixel(8,16,ama);
        drawHorizontalLine(7, 9, 15, ama);
        
        putPixel(11,15,az);
        putPixel(13,15,ver);
        putPixel(12,16,rojo);
        putPixel(13,12,a);
        
        putPixel(8,7,negro);
        putPixel(12,7,negro);
        drawHorizontalLine(9, 11 , 9, negro);
       
        
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