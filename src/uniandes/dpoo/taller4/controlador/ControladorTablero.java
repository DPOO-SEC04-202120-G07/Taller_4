package uniandes.dpoo.taller4.controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import uniandes.dpoo.taller4.interfaz.InterfazTop10;
import uniandes.dpoo.taller4.modelo.*;


public class ControladorTablero {

	private Tablero tablero =  new Tablero(5);
	private Top10 top10= new Top10();
	
	public ControladorTablero(){
	top10.cargarRecords(new File("./data/top10.csv"));
	tablero.desordenar(2);}
	
	public void AbrirTop10(){
		new InterfazTop10(top10);
	}
	
	public void nuevoTablero(int tamanio) {
		this.setTablero(new Tablero(tamanio));
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

	public int getJugadas() {
		return 	tablero.darJugadas();
	}

	public boolean isCompletado() {

		return tablero.tableroIluminado();
	}
	
	public boolean esTop10() {
		return top10.esTop10(tablero.calcularPuntaje());
	}
	
	public void salvarTop10() throws FileNotFoundException, UnsupportedEncodingException {
		top10.salvarRecords(new File("./data/top10.csv"));;
	}

	public void agregarTop10(String nombre) {
		if(nombre != null) {
		top10.agregarRegistro(nombre, tablero.calcularPuntaje());}
	}
	


}
