package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;

public class InterfazTop10 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

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
		DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 3452847024512867294L;

			@SuppressWarnings("rawtypes")
			public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
			    JLabel c = (JLabel) super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus);
			    
			    //Se cambia la fuente y el grosor de todos los elementos
			    list.setFont(new Font("Helvetica",Font.BOLD,12));
			    
			    
			    if(index == 0) {
			    	c.setBackground(new Color(54,114,224));
			    	c.setForeground(Color.WHITE);
			    }
			    
			    else if(index == 1) {
			    	c.setForeground(new Color(212,175,55));
			    }
			    
			    else if(index == 2) {
			    	c.setForeground(new Color(170,169,173));
			    }
			    
			    else if(index == 3) {
			    	c.setForeground(new Color(176,141,87));
			    }
			    	
			    if(isSelected) {
			    	c.setBackground(new Color(35,35,35));
			    }
			    
			    
			    c.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(200,200,200)));
			    
			    return c;
			}
			
		};
		
		//Establecemos el renderizado
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		top10_list.setCellRenderer(renderer);
		
		
		//Determinamos el tamaño de cada celda
		top10_list.setFixedCellHeight(50);
		top10_list.setFixedCellWidth(100);
		
		
		//Hacemos que la lista se pueda scrollear
		JScrollPane scrollPane = new JScrollPane(top10_list);
		
		//Añadimos la lista scrolleable
		add(scrollPane);
		
		
		//Definimos el tamañp del frame
		setTitle("Top 10");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(250,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
