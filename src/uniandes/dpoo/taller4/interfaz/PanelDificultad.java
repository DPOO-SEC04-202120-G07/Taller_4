package uniandes.dpoo.taller4.interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;


public class PanelDificultad extends JPanel {
	
	public PanelDificultad() {
		
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);
		
		setBackground(new Color(54,114,224));

		
		// Definición y ubicación de componentes
		JLabel tamanio=new JLabel("Tamaño:");
		tamanio.setForeground(Color.WHITE);
		
		add(tamanio);
		
		JComboBox<String> desplegable= new JComboBox<String>();
		desplegable.addItem("5x5");
		desplegable.addItem("7x7");
		desplegable.addItem("9x9");
		
		add(desplegable);
		
		add(new JLabel("    "));
		
		JLabel dificultad = new JLabel("Dificultad:");
		dificultad.setForeground(Color.WHITE);
		add(dificultad);
		
		ButtonGroup grupoDificultad= new ButtonGroup();
		
		JRadioButton facil= new JRadioButton("Facil");
		facil.setSelected(true);
		add(facil);
		facil.setForeground(Color.WHITE);
		
		JRadioButton medio= new JRadioButton("Medio");
		add(medio);
		medio.setForeground(Color.WHITE);
		
		JRadioButton dificil= new JRadioButton("Dificil");
		add(dificil);
		dificil.setForeground(Color.WHITE);
		
		grupoDificultad.add(facil);
		grupoDificultad.add(medio);
		grupoDificultad.add(dificil);
		

		//Listeners
		
		//Listener ComboBox
		desplegable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(desplegable.getSelectedItem().toString().charAt(0));
				PanelControlador.nextFilas=Integer.parseInt(""+desplegable.getSelectedItem().toString().charAt(0));
				PanelControlador.nextColumnas=Integer.parseInt(""+desplegable.getSelectedItem().toString().charAt(0));
			}
	    });  
	}
	

}
    

