package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

public class InterfazTablero extends JFrame {

	public InterfazTablero() {
		//Obtener dimensiones de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() * 0.848);
		int height = (int) (screenSize.getHeight()* 1.392);
		
		
		//Establecer el tipo de layout de la interfaz
		setLayout(new BorderLayout());
		
		//Componentes
		add(new PanelDificultad(), BorderLayout.NORTH);
		add(new PanelLuces(), BorderLayout.CENTER);
		add(new PanelControlador(), BorderLayout.EAST);
		add(new PanelEstado(), BorderLayout.SOUTH);
		
		
		//Configuraciones de la ventana
		setTitle("LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width/2, height/2);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		System.out.println(getSize());
	}
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new InterfazTablero();
	}

}
