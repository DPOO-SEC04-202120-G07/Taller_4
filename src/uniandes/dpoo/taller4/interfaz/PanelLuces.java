package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelLuces extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8966071394950680365L;
	int gridWidth; 
	int gridHeight;
	
	int filaHeight;
	int columnaWidth;
	
	
	public static int filas=5;
	public static int columnas=5;
	
	private BufferedImage bombillo_encendido=null;
	
	private BufferedImage bombillo_apagado=null;
	
	
	

	public PanelLuces() {
		

		try {
			bombillo_encendido = ImageIO.read(new File("./data/luz.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			bombillo_apagado = ImageIO.read(new File("./data/luz_apagada.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	    		
	    			
		    	

		    	//Se revisa el estado actual de la casilla para decidir de que color pintarla
		    	if(estadoTablero[j][i] == false) {
		    	    g.setColor(new Color(35,35,35));
		    	}
		    	else {
		    		g.setColor(new Color(250,211,78));
		    	}
		    	g.fillRoundRect(pixelInicioCasilla.x,  pixelInicioCasilla.y, columnaWidth,filaHeight, 50, 50);
		    	
		    	
		    	//Se revisa el estado actual para decidir que tipo de bombillo debe ser dibujado
		    	if(estadoTablero[j][i] == false) {
		    		g.drawImage(bombillo_apagado,(int) (pixelInicioCasilla.x+(filaHeight*0.16)),(int) (pixelInicioCasilla.y+(filaHeight*0.16)),(int) (columnaWidth-(columnaWidth*0.3)),(int)(filaHeight-(filaHeight*0.3)),this);
		    	}
		    	
		    	else {
		    		g.drawImage(bombillo_encendido,(int) (pixelInicioCasilla.x+(filaHeight*0.16)),(int) (pixelInicioCasilla.y+(filaHeight*0.16)),(int) (columnaWidth-(columnaWidth*0.3)),(int)(filaHeight-(filaHeight*0.3)),this);
		    	}
		    	
		    	
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
