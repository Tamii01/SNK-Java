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
	private Obstaculos arb1;
	private Obstaculos arb2;
	private Obstaculos arb3;
	private Obstaculos arb4;
	private Obstaculos casa;
	private int puntaje;


	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);


		mikasa = new Mikasa(entorno.ancho() /2, entorno.alto() / 2, 2);;
		kyojines = new Kyojines(entorno.ancho() /2, entorno.alto(), 2);
		arb1 = new Obstaculos(entorno.ancho() /2, entorno.alto());
		arb2 = new Obstaculos(entorno.ancho() /2, entorno.alto());
		arb3 = new Obstaculos(entorno.ancho() /2, entorno.alto());
		arb4 = new Obstaculos(entorno.ancho() /2, entorno.alto());
		casa = new Obstaculos(entorno.ancho()/2, entorno.alto());

		fondo = Herramientas.cargarImagen("grassWstone.png");

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0);

		mikasa.dibujar(entorno);
		kyojines.dibujar(entorno);
		arb1.arb1(entorno);
		arb2.arb2(entorno);
		arb3.arb3(entorno);
		arb4.arb4(entorno);
		casa.casa1(entorno);

		kyojines.mover();


		/*if (kyojines.chocasteCon(arbol)) {
			kyojines.Puntaje(kyojines, arbol);

		}/*

		/*for(int i=0; i<10;i++) {
			if (kyojines.chocasteCon(arbol)) {
				puntajeNuevo = puntaje++;
			}
		}*/


		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		//entorno.escribirTexto("Vidas: " + vida, 320, 30);


		//------------ COLISION -------------

		if (kyojines.chocaEntorno(entorno)) {
			kyojines.cambiarDeDireccion();
		}

		if (kyojines.chocasteCon(arb1)) {
			kyojines.cambiarDeDireccion();
		}

		
		if (kyojines.chocasteCon(casa)) {
			kyojines.cambiarDeDireccion();
		}

		if (mikasa.chocaEntorno(entorno)) {
		}


		//----------- TECLAS -------------

		if (entorno.estaPresionada('a')) {
			mikasa.moverHaciaIzquierda();
			mikasa.mikasaIzq(entorno);
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
		
		if(entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
			
		}
		// -------------------------------

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
