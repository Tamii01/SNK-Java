package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego1 extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa1 mikasa;
	private Kyojin1 kyojines;

	private Image fondo;
	private Obstaculo1 arb1;
	private Obstaculo1 arb2;
	private Obstaculo1 arb3;
	private Obstaculo1 arb4;
	private Obstaculo1 casa;
	private Obstaculo1 casa1;
	private Obstaculo1 suero;
	private int puntaje = 0;
	private int vidas = 5;


	public Juego1() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);

		mikasa = new Mikasa1(390, 300, 5);

		kyojines = new Kyojin1(90, 510, 5);

		arb1 = new Obstaculo1(entorno.ancho(), entorno.alto());
		arb2 = new Obstaculo1(entorno.ancho(), entorno.alto());
		arb3 = new Obstaculo1(entorno.ancho(), entorno.alto());
		arb4 = new Obstaculo1(entorno.ancho(), entorno.alto());
		casa = new Obstaculo1(entorno.ancho(), entorno.alto());
		casa1 = new Obstaculo1(entorno.ancho(), entorno.alto());
		suero = new Obstaculo1(entorno.ancho(), entorno.alto());

		fondo = Herramientas.cargarImagen("grass-pixel.png");

		this.entorno.iniciar();
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0, 2.5);

		mikasa.dibujar(entorno);
		kyojines.dibujar(entorno);
		arb1.arb1(entorno);
		arb2.arb2(entorno);
		arb3.arb3(entorno);
		arb4.arb4(entorno);
		casa.casa(entorno);
		casa1.casa1(entorno);
		suero.suero(entorno);

		kyojines.mover();

		if (kyojines.chocasteCon(arb1)) {
			puntaje = puntaje + 1;
		}

		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vidas, 320, 30);


		//------------ COLISION -------------

		if (kyojines.chocaEntorno(entorno)) {
			kyojines.cambiarDeDireccion();

		}

		if (kyojines.chocasteCon(arb1)) {
			kyojines.cambiarDeDireccion();
		}

		if (kyojines.chocasteCon2(arb2)) {
			kyojines.cambiarDeDireccion();
		}


		if (kyojines.chocasteCon(casa)) {
			kyojines.cambiarDeDireccion();
		}

		/*		if (kyojines.chocasteConMikasa(mikasa)) {
			vidas = vidas - 1;			
		}												todo este bloque comentado está bien, pero se crashea el juego, tengo que arreglarlo

		if (vidas == 0) {
			mikasa = null;
		} */

		if (mikasa.chocaEntorno(entorno)) {
			mikasa.quedarParada();
		}

		//----------- TECLAS -------------

		if (entorno.estaPresionada('a')) {
			mikasa.caminarHaciaIzquierda(entorno);
		}

		if(entorno.estaPresionada('w')) {
			mikasa.caminarHaciaArriba();
		}

		if (entorno.estaPresionada('s')) {
			mikasa.caminarHaciaAbajo();
		}

		if (entorno.estaPresionada('d')) {
			mikasa.caminarHaciaDerecha();
		}

		if(entorno.estaPresionada(entorno.TECLA_ESPACIO)) {

		}
	}
	// -------------------------------

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego1 juego = new Juego1();
	}

}
