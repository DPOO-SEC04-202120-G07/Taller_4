package uniandes.dpoo.taller4.controlador;
import java.io.File;

import uniandes.dpoo.taller4.interfaz.InterfazTop10;
import uniandes.dpoo.taller4.modelo.*;


public class ControladorTablero {

	private Tablero tablero =  new Tablero(5);
	
	public void AbrirTop10(){
		Top10 top10= new Top10();
		top10.cargarRecords(new File("./data/top10.csv"));
		new InterfazTop10(top10);
	}
	
	public void nuevoTablero(int tamanio) {
		this.setTablero(new Tablero(tamanio));
		System.out.println(tablero.tableroIluminado());
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void jugarTablero(int[] jugada) {
		tablero.jugar(jugada[0], jugada[1]);
	}
	
	public void reiniciarTablero() {
		tablero.reiniciar();
	}
	
	public void establecerDificultad(int dificultad) {
		tablero.desordenar(dificultad);
	}
	


}
