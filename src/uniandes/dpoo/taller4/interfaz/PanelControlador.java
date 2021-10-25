package uniandes.dpoo.taller4.interfaz;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelControlador extends JPanel{
	
	public static int nextFilas=5;
	public static int nextColumnas=5;

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
				PanelLuces.estadoTablero = InterfazTablero.controladorTablero.getTablero().darTablero();
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
			}
		});
	}
	
}
