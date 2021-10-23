package uniandes.dpoo.taller4.interfaz;

import java.awt.*;

import javax.swing.*;

public class PanelEstado extends JPanel {

	public PanelEstado() {
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setBackground(new Color(228,228,228));
		
		JLabel jugadas = new JLabel("Jugadas:");
		add(jugadas);
		
		JTextField fJugadas= new JTextField();
		fJugadas.setEditable(false);
		fJugadas.setPreferredSize(new Dimension (120,fJugadas.getPreferredSize().height));
		add(fJugadas);
		
		add(new JLabel("                "));
		
		JLabel jugador = new JLabel("Jugador:");
		add(jugador);
		
		JTextField fJugador= new JTextField();
		fJugador.setEditable(false);
		fJugador.setPreferredSize(new Dimension (120,fJugador.getPreferredSize().height));
		add(fJugador);
	}
	
	
	
	
}

