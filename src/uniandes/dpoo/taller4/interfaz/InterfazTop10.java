package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;

public class InterfazTop10 extends JFrame{
	
	public InterfazTop10(Top10 top) {
		setLayout(new GridLayout(1,1));
		Collection<RegistroTop10> registros = top.darRegistros();
		Iterator<RegistroTop10> iteradorTop=registros.iterator();
		

		//Instanciamos el modelo
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		
		//Añadimos el encabezaso
		String header= "# ---- Nombre ---- Puntos";
		modelo.addElement(header);
		
		//Añadimos el primer puesto
		RegistroTop10 actual=iteradorTop.next();
		String first = "🏆 1"+" ..... "+actual.toString();
		modelo.addElement(first);
		
		//Añadimos los demás puestos
		int i=2;
		while (iteradorTop.hasNext()) {
			actual=iteradorTop.next();
			modelo.addElement(i+" ..... "+actual.toString());
			i++;
		}
		
	

		//Instanciamos la lista
		JList<String> top10_list = new JList<String>(modelo);
		
		//Modificamos el renderizado
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) top10_list.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//Añadimos la lista al frame
		add(top10_list);
		
		
		//Definimos el tamañp del frame
		setTitle("Top 10");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(250,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
