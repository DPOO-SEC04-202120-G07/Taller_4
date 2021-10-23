package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

public class PanelLuces extends JComponent{
	
	int gridWidth; 
	int gridHeight;
	
	int filas = 5;
	int columnas = 5;
	
	
	public PanelLuces() {
	}
	

	
	
	public void paint( Graphics g )
	 {
		
		this.gridWidth = getSize().width;
		this.gridHeight = getSize().height;
		
		
		 // Se llama el método paint de la superclase
		super.paint( g );
		
		//Se dibuja un cuadrado base de fondo
		g.setColor( new Color( 255, 255, 255 ) );
		g.fillRect( 0, 0, this.gridWidth, this.gridHeight );
		
		
	    //Se dibujan las filas
		g.setColor(Color.BLACK);
		
	    int filaHeight = this.gridHeight / (filas);
	    for (int i = 0; i < filas; i++) {
	      g.drawLine(0, i * filaHeight, this.gridWidth, i * filaHeight);}
	    
	    
	    //Se dibujan las columnas
	    int columnaWidth = this.gridWidth / (columnas);
	    for (int i = 0; i < columnas; i++)
	      g.drawLine(i * columnaWidth, 0, i * columnaWidth, gridWidth);

	
}
	
}
