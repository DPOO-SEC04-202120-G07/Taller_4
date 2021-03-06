package uniandes.dpoo.taller4.interfaz;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanelControlador extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int nextFilas=5;
	public static int nextColumnas=5;
	
	public static int dificultad = 2;

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
		
		
		
		//Listeners
		
		//Listener nuevo button
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelLuces.filas=PanelControlador.nextFilas;
				PanelLuces.columnas=PanelControlador.nextColumnas;
				InterfazTablero.controladorTablero.nuevoTablero(PanelLuces.filas);
				InterfazTablero.controladorTablero.establecerDificultad(dificultad);
				
		        //Borrar jugadas
		        int jugadas = InterfazTablero.controladorTablero.getJugadas();
		        PanelEstado.establecerJugadas(jugadas);
			}
		});
		
		//Listener top10 button
		top10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazTablero.controladorTablero.AbrirTop10();
			}
		});
		
		
		//Listener reiniciar button
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazTablero.controladorTablero.reiniciarTablero();
				
		        //Reiniciar jugadas
		        int jugadas = InterfazTablero.controladorTablero.getJugadas();
		        PanelEstado.establecerJugadas(jugadas);
			}
		});
		
		//Listener Cambiar Jugador
		cambiarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador actual: ");
				PanelEstado.cambiarNombre(nombreJugador);
				
			}
		});
		
		
	}
	
}
