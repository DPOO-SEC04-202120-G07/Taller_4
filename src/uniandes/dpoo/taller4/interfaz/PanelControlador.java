package uniandes.dpoo.taller4.interfaz;


import java.awt.*;
import javax.swing.*;

public class PanelControlador extends JPanel{

	public PanelControlador() {
		
		Color azulBotones = new Color(60,126,250);
		
		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(25);
		setLayout(layout);
		
		setBackground(new Color(235,235,235));
		
		add(new JLabel(""));
		
		JButton nuevo = new JButton("NUEVO");
		nuevo.setBackground(azulBotones);
		nuevo.setForeground(Color.WHITE);
		nuevo.setPreferredSize(new Dimension(2,2));
		add(nuevo);
		
		JButton reiniciar = new JButton("REINICIAR");
		reiniciar.setBackground(azulBotones);
		reiniciar.setForeground(Color.WHITE);
		add(reiniciar);
		
		JButton top10 = new JButton("TOP-10");
		top10.setBackground(azulBotones);
		top10.setForeground(Color.WHITE);
		add(top10);
		
		JButton cambiarJugador = new JButton("CAMBIAR JUGADOR");
		cambiarJugador.setBackground(azulBotones);
		cambiarJugador.setForeground(Color.WHITE);
		add(cambiarJugador);
		
		add(new JLabel(""));
	}
	
}
