package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import uniandes.dpoo.taller4.controlador.ControladorTablero;



public class InterfazTablero extends JFrame {

	//Se crea el controlador
	public static ControladorTablero controladorTablero = new ControladorTablero();
	

	public InterfazTablero() {
		
		//Obtener dimensiones de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() * 0.848);
		int height = (int) (screenSize.getHeight()* 1.392);
		
		//Establecer el tipo de layout de la interfaz
		setLayout(new BorderLayout());
		
		//Componentes
		add(new PanelDificultad(), BorderLayout.NORTH);
		PanelLuces panelLuces=new PanelLuces();
		add(panelLuces, BorderLayout.CENTER);
		add(new PanelControlador(), BorderLayout.EAST);
		add(new PanelEstado(), BorderLayout.SOUTH);
		
		//Configuraciones de la ventana
		setTitle("LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width/2, height/2);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
		//Se dibuja el tablero por default (5x5) de cuando se abre la aplicación
		PanelLuces.estadoTablero = controladorTablero.getTablero().darTablero();
		
		
		//Listener mouse
		panelLuces.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int mouse_xPosition=e.getX();
		        int mouse_yPosition=e.getY();
		        int[] casillaClickeada  = panelLuces.convertirCoordenadasACasilla(mouse_xPosition, mouse_yPosition);
		        controladorTablero.jugarTablero(casillaClickeada);
		    }
		    });
		
	}
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new InterfazTablero();
	}
	

	
	

	
	

	

}
