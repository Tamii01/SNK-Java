package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {


	private Entorno entorno;
	
	private Mikasa mikasa;
	
	private Kyojines kyojines;
	
	private Image fondo;
	
	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);


		mikasa = new Mikasa(entorno.ancho() /2, entorno.alto() / 2, 1);
		kyojines = new Kyojines();
		
		fondo = Herramientas.cargarImagen("calle.png");

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 5, entorno.alto() / 5, 60);
		
		
		if (entorno.estaPresionada('a')) {
			mikasa.moverHaciaIzquierda();
		}
		
		if(entorno.estaPresionada('w')) {
			mikasa.moverHaciaArriba();
			
		}
		
		if (entorno.estaPresionada('s')) {
			mikasa.moverHaciaAbajo();
			
		}
		
		if (entorno.estaPresionada('d')) {
			mikasa.moverHaciaDerecha();
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
