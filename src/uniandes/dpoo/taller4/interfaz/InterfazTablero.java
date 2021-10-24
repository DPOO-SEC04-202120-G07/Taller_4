package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller4.modelo.*;

public class InterfazTablero extends JFrame {
	
	private Tablero tablero = new Tablero(5);
	
	public InterfazTablero() {
		//Obtener dimensiones de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() * 0.848);
		int height = (int) (screenSize.getHeight()* 1.392);
		
		
		//Establecer el tipo de layout de la interfaz
		setLayout(new BorderLayout());
		
		//Componentes
		
		add(new PanelDificultad(), BorderLayout.NORTH);
		PanelLuces panelLuces=new PanelLuces();
		add(panelLuces, BorderLayout.CENTER);
		add(new PanelControlador(), BorderLayout.EAST);
		add(new PanelEstado(), BorderLayout.SOUTH);
		
		
		//Configuraciones de la ventana
		setTitle("LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width/2, height/2);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new InterfazTablero();
	}
	
	public static void top10(){
		Top10 top10= new Top10();
		top10.cargarRecords(new File("./data/top10.csv"));
		new InterfazTop10(top10);
	}

}
