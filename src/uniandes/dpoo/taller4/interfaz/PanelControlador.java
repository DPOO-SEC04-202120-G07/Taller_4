package uniandes.dpoo.taller4.interfaz;


import java.awt.*;
import javax.swing.*;

public class PanelControlador extends JPanel{

	public PanelControlador() {
		
		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(25);
		setLayout(layout);
		
		add(new JLabel(""));
		
		JButton nuevo = new JButton("NUEVO");
		add(nuevo);
		
		JButton reiniciar = new JButton("REINICIAR");
		add(reiniciar);
		
		JButton top10 = new JButton("TOP-10");
		add(top10);
		
		JButton cambiarJugador = new JButton("CAMBIAR JUGADOR");
		add(cambiarJugador);
		
		add(new JLabel(""));
	}
	
}
