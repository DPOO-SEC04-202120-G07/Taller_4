package uniandes.dpoo.taller4.interfaz;
import java.awt.*;
import javax.swing.*;


public class PanelDificultad extends JPanel {
	
	public PanelDificultad() {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);
		
		setBackground(new Color(54,114,224));

		
		
		JLabel tamanio=new JLabel("Tamaño:");
		tamanio.setSize(getPreferredSize());
		tamanio.setForeground(Color.WHITE);
		
		add(tamanio);
		
		JComboBox<String> desplegable= new JComboBox<String>();
		desplegable.addItem("3x3");
		desplegable.addItem("5x5");
		desplegable.addItem("7x7");
		
		add(desplegable);
		
		add(new JLabel("    "));
		
		JLabel dificultad = new JLabel("Dificultad:");
		dificultad.setForeground(Color.WHITE);
		add(dificultad);
		
		ButtonGroup grupoDificultad= new ButtonGroup();
		
		JRadioButton facil= new JRadioButton("Facil");
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
		

	}
	

}
    

