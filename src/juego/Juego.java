package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {


	private Entorno entorno;
	
	private Mikasa mikasa;
	
	private Kyojines kyojines;
	
	private Kyojines[] titan;
	
	private Image fondo;
	
	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);


		mikasa = new Mikasa(entorno.ancho() /2, entorno.alto() / 2, 0);
		kyojines = new Kyojines();
		
		fondo = Herramientas.cargarImagen("calle.png");
		
		/*
		titan = new Kyojines[4];
		
		for(int i=0; i< titan.length; i++) {
			titan[i] = new Kyojines(Math.random() * entorno.ancho(), Math.random() * entorno.alto(), Math.random());
			
		}
		*/
		

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 1, entorno.alto() / 1, 0);

		mikasa.dibujar(entorno); 	

		
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
