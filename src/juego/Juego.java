package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {


	private Entorno entorno;
	
	private Mikasa mikasaDer;
	
	private Mikasa mikasaIzq;
	
	private Kyojines kyojines;
	
	private Kyojines[] titan;
	
	private Image fondo;
	
	private int puntaje;

	private Obstaculos obstaculo;
	
	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);


		mikasaDer = new Mikasa(entorno.ancho() /2, entorno.alto() / 2, 2);;
		kyojines = new Kyojines(entorno.ancho() /2, entorno.alto() - 1, 2);
		
		fondo = Herramientas.cargarImagen("grassWstones.png");
		
		/*obstaculo = new Obstaculos();*/
		
		titan = new Kyojines[4];
		
		for(int i=0; i< titan.length; i++) {
			titan[i] = new Kyojines(Math.random() * entorno.ancho(), Math.random() * entorno.alto(), Math.random());
			
		}
		
		

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0);

		mikasaDer.dibujar(entorno);
		kyojines.dibujar(entorno);

		
		
		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("points: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		
		if (entorno.estaPresionada('a')) {
			
			mikasaDer.moverHaciaIzquierda();
		}
		
		if(entorno.estaPresionada('w')) {
			mikasaDer.moverHaciaArriba();
			
		}
		
		if (entorno.estaPresionada('s')) {
			mikasaDer.moverHaciaAbajo();
			
		}
		
		if (entorno.estaPresionada('d')) {
			mikasaDer.moverHaciaDerecha();
		}
		
		if (mikasaDer.chocasteConElEntorno(entorno)) {
			mikasaDer.cambiarDeDireccion();
			
		}

		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
