package uniandes.dpoo.taller4.interfaz;


import java.awt.*;
import javax.swing.*;

public class PanelDificultad extends JPanel {
	
	public PanelDificultad() {
		setLayout(new GridLayout(1,8));
		
		add(new JLabel(""));
		
		JLabel tamanio=new JLabel("Tamaño:");
		
		add(tamanio);
		
		JComboBox<String> desplegable= new JComboBox<String>();
		desplegable.addItem("3x3");
		desplegable.addItem("5x5");
		desplegable.addItem("7x7");
		
		add(desplegable);
		
		JLabel dificultad = new JLabel("Dificultad:");
		dificultad.setSize(getPreferredSize());
		add(dificultad);
		
		ButtonGroup grupoDificultad= new ButtonGroup();
		
		JRadioButton facil= new JRadioButton("Facil");
		add(facil);
		
		JRadioButton medio= new JRadioButton("Medio");
		add(medio);
		
		JRadioButton dificil= new JRadioButton("Dificil");
		add(dificil);
		
		grupoDificultad.add(facil);
		grupoDificultad.add(medio);
		grupoDificultad.add(dificil);
		
		add(new JLabel(""));
	}
}
