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
	private Obstaculos arbol;
	private int puntaje;


	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);


		mikasa = new Mikasa(entorno.ancho() /2, entorno.alto() / 2, 2);;
		kyojines = new Kyojines(entorno.ancho() /2, entorno.alto(), 2);
		arbol = new Obstaculos(entorno.ancho() /2, entorno.alto());

		fondo = Herramientas.cargarImagen("grassWstones.png");

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0);

		mikasa.dibujar(entorno);
		kyojines.dibujar(entorno);
		arbol.dibujar(entorno);

		kyojines.mover();

		int vida =5;
		int puntaje = 0;
		
		if (kyojines.chocasteCon(arbol)) {
			puntaje = puntaje + 1;
			
		}
		
		/*for(int i=0; i<10;i++) {
			if (kyojines.chocasteCon(arbol)) {
				puntajeNuevo = puntaje++;
			}
		}*/


		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("points: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vida, 320, 30);


		//------------ COLISION -------------

		if (kyojines.chocaEntorno(entorno)) {
			kyojines.cambiarDeDireccion();
		}

		if (kyojines.chocasteCon(arbol)) {
			kyojines.cambiarDeDireccion();
		}



		//----------- TECLAS -------------

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

		// -------------------------------

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
