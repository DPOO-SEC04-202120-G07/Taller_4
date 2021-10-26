package uniandes.dpoo.taller4.interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelDificultad extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -767569277953994673L;

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
				PanelControlador.nextFilas=Integer.parseInt(""+desplegable.getSelectedItem().toString().charAt(0));
				PanelControlador.nextColumnas=Integer.parseInt(""+desplegable.getSelectedItem().toString().charAt(0));
			}
	    });  
		
		
		//Listener RadioButtons
		
		//Facil RadioButton
		facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se establece una dificultad fácil de 2
				PanelControlador.dificultad = 2;
			}
	    });  
		
		
		//Medio RadioButton
		medio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se establece una dificultad media de 3
				PanelControlador.dificultad = 3;
			}
	    });  
		

		//Dificil RadioButton
		dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se establece una dificultad dificl de 5
				PanelControlador.dificultad = 5;
			}
	    });  
		
		
		
	}
	

}
    

