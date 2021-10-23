package uniandes.dpoo.taller4.interfaz;

import java.awt.*;

import javax.swing.*;

public class PanelEstado extends JPanel {

	public PanelEstado() {
		setLayout(new GridLayout(1,4));
		
		JLabel jugadas = new JLabel("Jugadas:");
		add(jugadas);
		
		JTextField fJugadas= new JTextField();
		fJugadas.setEditable(false);
		add(fJugadas);
		
		JLabel jugador = new JLabel("Jugador:");
		add(jugador);
		
		JTextField fJugador= new JTextField();
		fJugador.setEditable(false);
		add(fJugador);
	}
	
	
}

