package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {


	private Entorno entorno;
	
	private Mikasa mikasaDer;
	
	/*private Mikasa mikasaIzq;*/
	
	private Kyojines kyojines;
	
	private Image fondo;
	
	private int puntaje;

	private Obstaculos arbol;
	
	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);


		mikasaDer = new Mikasa(entorno.ancho() /2, entorno.alto() / 2, 2);;
		kyojines = new Kyojines(entorno.ancho() /2, entorno.alto() - 15, 2);
		arbol = new Obstaculos(entorno.ancho() /2, entorno.alto());
		
		fondo = Herramientas.cargarImagen("grassWstones.png");
		
		/*obstaculo = new Obstaculos();*/
		
		

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0);

		mikasaDer.dibujar(entorno);
		kyojines.dibujar(entorno);
		arbol.dibujar(entorno);

		kyojines.mover();
		
		
		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("points: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		
		if (kyojines.chocaEntorno(entorno)) {
			kyojines.cambiarDeDireccion();
		}
		
		if (kyojines.chocasteCon(arbol)) {
			kyojines.cambiarDeDireccion();
			
		}
		
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

		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
