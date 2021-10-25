package uniandes.dpoo.taller4.interfaz;

import java.awt.*;

import javax.swing.*;

public class PanelEstado extends JPanel {

	private static JTextField fJugador= new JTextField();
	private static JTextField fJugadas= new JTextField();
	
	public PanelEstado() {
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setBackground(new Color(228,228,228));
		
		JLabel jugadas = new JLabel("Jugadas:");
		add(jugadas);
		
		fJugadas.setEditable(false);
		fJugadas.setPreferredSize(new Dimension (120,fJugadas.getPreferredSize().height));
		add(fJugadas);
		
		add(new JLabel("                "));
		
		JLabel jugador = new JLabel("Jugador:");
		add(jugador);
		
		fJugador.setEditable(false);
		fJugador.setPreferredSize(new Dimension (120,fJugador.getPreferredSize().height));
		add(fJugador);
	}
	
	public static void cambiarNombre(String nombreJugador) {
		PanelEstado.fJugador.setText(nombreJugador);
	}
	
	public static void establecerJugadas(int jugadas) {
		PanelEstado.fJugadas.setText("" + jugadas);
	}
	
	public static String getNombre() {
		return PanelEstado.fJugador.getText();
	}
	

	
	
	
	
}

