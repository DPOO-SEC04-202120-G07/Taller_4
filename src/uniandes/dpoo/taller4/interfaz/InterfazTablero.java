package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import uniandes.dpoo.taller4.controlador.ControladorTablero;



public class InterfazTablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
	
		
		//Listener mouse
		panelLuces.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	//Jugar!
		        int mouse_xPosition=e.getX();
		        int mouse_yPosition=e.getY();
		        int[] casillaClickeada  = panelLuces.convertirCoordenadasACasilla(mouse_xPosition, mouse_yPosition);
		        controladorTablero.jugarTablero(casillaClickeada);
		        
		        //Aumentar jugadas
		        int jugadas = controladorTablero.getJugadas();
		        PanelEstado.establecerJugadas(jugadas);
		        
		        //Revisar si se completó el tablero después de la última jugada
		        boolean completado = controladorTablero.isCompletado();
		        if(completado) {
		        	JOptionPane.showMessageDialog(panelLuces, "Felicitaciones, ha completado el juego.");
		        	//Se revisa si es top10 y se agrega el record
		        	if(InterfazTablero.controladorTablero.esTop10()) {
		        		controladorTablero.agregarTop10(PanelEstado.getNombre());
		        	}
		        	
		        	//Se crea un nuevo tablero para volver a jugar
					InterfazTablero.controladorTablero.nuevoTablero(PanelLuces.filas);
					InterfazTablero.controladorTablero.establecerDificultad(PanelControlador.dificultad);
					
			        //Borrar jugadas
			        jugadas = InterfazTablero.controladorTablero.getJugadas();
			        PanelEstado.establecerJugadas(jugadas);
		        	
		        }
		        
		    }
		    });
		
		//Cuando se cierre la ventana se guardara el top10
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
			try {
				InterfazTablero.controladorTablero.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			}
		});

		
	}
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new InterfazTablero();
	}
	

	
	

	
	

	

}
