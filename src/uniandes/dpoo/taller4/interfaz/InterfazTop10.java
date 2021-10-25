package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;

public class InterfazTop10 extends JFrame{
	
	public InterfazTop10(Top10 top) {
		setLayout(new GridLayout(11,1));
		Collection<RegistroTop10> registros = top.darRegistros();
		Iterator<RegistroTop10> iteradorTop=registros.iterator();
		
		JLabel header= new JLabel("# ---- Nombre ---- Puntos",SwingConstants.CENTER);
		header.setOpaque(true);
		header.setBackground(new Color(54,114,224));
		header.setForeground(new Color(255,255,255));
		add(header);
		
		RegistroTop10 actual=iteradorTop.next();
		JLabel first =new JLabel("🏆 1"+" ..... "+actual.toString(),SwingConstants.CENTER);
		Font font = new Font("Courier", Font.BOLD,12);
		first.setFont(font);
		first.setForeground(Color.GREEN);
		add(first);
		
		int i=2;
		while (iteradorTop.hasNext()) {
			actual=iteradorTop.next();
			add(new JLabel(i+" ..... "+actual.toString(),SwingConstants.CENTER));
			i++;
		}
		
		setTitle("Top 10");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(250,400);
		setResizable(false);
		setVisible(true);
	}
}
