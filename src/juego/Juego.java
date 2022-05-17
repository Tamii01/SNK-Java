package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
	private Kyojin kyojin;

	private Image fondo;
	private Obstaculo arb1;
	private Obstaculo arb2;
	private Obstaculo arb3;
	private Obstaculo arb4;
	private Obstaculo casa;
	private Obstaculo casa1;
	private Obstaculo suero;
	private int puntaje = 0;
	private int vidas = 5;


	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);

		mikasa = new Mikasa(390, 300, 5);

		kyojin = new Kyojin(90, 510, 5);

		arb1 = new Obstaculo(entorno.ancho(), entorno.alto());
		arb2 = new Obstaculo(entorno.ancho(), entorno.alto());
		arb3 = new Obstaculo(entorno.ancho(), entorno.alto());
		arb4 = new Obstaculo(entorno.ancho(), entorno.alto());
		casa = new Obstaculo(entorno.ancho(), entorno.alto());
		casa1 = new Obstaculo(entorno.ancho(), entorno.alto());
		suero = new Obstaculo(entorno.ancho(), entorno.alto());

		fondo = Herramientas.cargarImagen("grass-pixel.png");

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0, 2.5);

		mikasa.dibujar(entorno);
		kyojin.dibujar(entorno);
		kyojin.mover();

		Obstaculo[] obstaculos = {arb1, arb2, arb3, arb4, casa, casa1, suero};

		for (Obstaculo i : obstaculos) {
			i.obstaculos(entorno);
		}

		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vidas, 320, 30);


		//------------ COLISION -------------

		if (kyojin.chocaEntorno(entorno)) {
			kyojin.cambiarDeDireccion();
		}

		if (kyojin.chocasteCon(arb1)) {
			kyojin.cambiarDeDireccion();
		}

		if (kyojin.chocasteCon2(arb2)) {
			kyojin.cambiarDeDireccion();
		}

		if (kyojin.chocasteCon(casa)) {
			kyojin.cambiarDeDireccion();
		}

		if (kyojin.dañasteAMikasa(mikasa)) {
			vidas = vidas - 1;			
		}												

//		if (vidas == 0) {
//			mikasa = null;
//		} 
//		
//		if (mikasa == null) {
//			then termina el juego (mostrar por pantalla game over)
//		}

		if (mikasa.chocaEntorno(entorno)) {
			mikasa.quedarParada();
		}
		//----------- TECLAS -------------

		if (entorno.estaPresionada('a')) {
			mikasa.caminarHaciaIzquierda(entorno);
		}

		if(entorno.estaPresionada('w')) {
			mikasa.caminarHaciaArriba(entorno);
		}

		if (entorno.estaPresionada('s')) {
			mikasa.caminarHaciaAbajo(entorno);
		}

		if (entorno.estaPresionada('d')) {
			mikasa.caminarHaciaDerecha(entorno);
		}

		if(entorno.estaPresionada(entorno.TECLA_ESPACIO)) {

		}
		
		if(mikasa.getX() == suero.getX() - 20 && mikasa.getY() == suero.getY() - 20) {
			suero = null;
		}
		
	}
	// -------------------------------

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
