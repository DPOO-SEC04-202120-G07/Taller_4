package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelLuces extends JComponent{
	
	int gridWidth; 
	int gridHeight;
	
	int filaHeight;
	int columnaWidth;
	
	
	public static int filas=5;
	public static int columnas=5;
	

	public PanelLuces() {
	}
	
	
	
	public void paint( Graphics g )
	 {		
		
		boolean[][] estadoTablero = InterfazTablero.controladorTablero.getTablero().darTablero();
		
		this.gridWidth = getSize().width;
		this.gridHeight = getSize().height;
		
		 // Se llama el método paint de la superclase
		super.paint( g );
		
		
		//Dibujo fondo negro
		g.fillRect(0, 0, gridWidth, gridHeight);
		
		
		//////// Variables dibujo recursivo tablero ///////
	    this.filaHeight = this.gridHeight / (filas);
	    this.columnaWidth = this.gridWidth / (columnas);
		
	   
	    //Se dibujan las casillas del tablero prendidas o apagadas
	    Point pixelInicioCasilla = new Point(0,0);

	    for(int i = 0; i < filas; i++) {
	    	for(int j = 0; j < columnas; j++) {
	    		
	    			
		    	
	    		g.setColor(new Color(250,211,78));
		    	//Se revisa el estado actual de la casilla para decidir de que color pintarla
		    	if(estadoTablero[j][i] == false) {
		    	    g.setColor(new Color(35,35,35));
		    	}
		    	
		    	
		    		
		    	
		    	g.fillRoundRect(pixelInicioCasilla.x,  pixelInicioCasilla.y, columnaWidth,filaHeight, 50, 50);
		    	
		    	BufferedImage image=null;
				try {
					image = ImageIO.read(new File("./data/luz.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		
		    	g.drawImage(image,(int) (pixelInicioCasilla.x+(filaHeight*0.16)),(int) (pixelInicioCasilla.y+(filaHeight*0.16)),(int) (columnaWidth-(columnaWidth*0.3)),(int)(filaHeight-(filaHeight*0.3)),this);
		    	
		    	pixelInicioCasilla.setLocation(pixelInicioCasilla.x, pixelInicioCasilla.y + filaHeight);
		    	
		    	

	    	}
	    	pixelInicioCasilla.setLocation(pixelInicioCasilla.x + columnaWidth, 0);

	    }
	    
	    // Dibujo lineas guia (Uso de graphics 2D para hacerlas más gruesas)
	    Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
	 
	    //Se dibujan las filas
	    for (int i = 0; i < filas+1; i++) {
	      g2.drawLine(0, i * filaHeight, this.gridWidth, i * filaHeight);
	    }
	    
	    //Se dibujan las columnas
	    for (int i = 0; i < columnas+1; i++) {
	     g2.drawLine(i * columnaWidth, 0, i * columnaWidth, gridWidth);}

	   repaint();
	
}
	
	public int[] convertirCoordenadasACasilla(int x, int y)
	{
	int fila = (int) (y / filaHeight);
	int columna = (int) (x / columnaWidth);
	return new int[] { fila, columna };
	}

	
	
	
}
