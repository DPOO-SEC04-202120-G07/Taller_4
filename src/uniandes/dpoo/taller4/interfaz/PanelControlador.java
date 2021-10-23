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
		nuevo.setBackground(new Color(61,128,250));
		nuevo.setForeground(Color.WHITE);
		add(nuevo);
		
		JButton reiniciar = new JButton("REINICIAR");
		reiniciar.setBackground(new Color(61,128,250));
		reiniciar.setForeground(Color.WHITE);
		add(reiniciar);
		
		JButton top10 = new JButton("TOP-10");
		top10.setBackground(new Color(61,128,250));
		top10.setForeground(Color.WHITE);
		add(top10);
		
		JButton cambiarJugador = new JButton("CAMBIAR JUGADOR");
		cambiarJugador.setBackground(new Color(61,128,250));
		cambiarJugador.setForeground(Color.WHITE);
		add(cambiarJugador);
		
		add(new JLabel(""));
	}
	
}
