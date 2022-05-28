package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
	private Kyojin kyojin;
	private Kyojin[] kyojines;
	private Proyectil disparo;
	//	private Obstaculo[] obstaculos;
	private Obstaculo casaDeArriba, casaDelMedio, casaDeAbajo, arbolPequeño, arbolGrande;

	private Image fondo;

	private int puntaje;
	private int vidas;


	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600); 

		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5, 60, 20); //x, y, velocidad, alto, ancho
		kyojin = new Kyojin(100, 280, 5, 0.15);  //x, y, velocidad, tamaño
		kyojines = new Kyojin[4];
		casaDeArriba = new Obstaculo(155,95);
		casaDelMedio = new Obstaculo(643,150);
		casaDeAbajo = new Obstaculo(61,410);
		arbolPequeño = new Obstaculo(690, 470);
		arbolGrande = new Obstaculo(345, 417);
		fondo = Herramientas.cargarImagen("fondo-del-juego.png");

		puntaje = 0;
		vidas = 5;

		this.entorno.iniciar();

	}

	public void tick() {

		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0, 2.5);
		mikasa.dibujar(entorno);
		kyojin.dibujar(entorno);
		kyojin.mover();
		casaDeArriba.casaDeArriba(entorno);
		casaDelMedio.casaDelMedio(entorno);
		casaDeAbajo.casaDeAbajo(entorno);
		arbolPequeño.arbolPequeño(entorno);
		arbolGrande.arbolGrande(entorno);
		
		
		//arreglar
		for(int i=0; i< kyojines.length; i++) {
			kyojines[i] = new Kyojin (Math.random() * entorno.ancho(), Math.random() * entorno.alto(), 0.5, 0.18);
			kyojines[i].dibujar(entorno);
		}

		entorno.cambiarFont("sans", 15, Color.WHITE);
		entorno.escribirTexto("Posicion en x de Mikasa: " + mikasa.getX(), 500, 100);
		entorno.escribirTexto("Posicion en y de Mikasa: " + mikasa.getY(), 500, 150);
		entorno.escribirTexto("Posicion en x del Kyojin: " + kyojin.getX(), 500, 200);
		entorno.escribirTexto("Posicion en y del Kyojin: " + kyojin.getY(), 500, 250);
		entorno.escribirTexto("Posicion en y del Kyojin: " + kyojin.getY(), 500, 250); 
		entorno.escribirTexto("Angulo del Kyojin: " + kyojin.getAngulo(), 500, 300);
		entorno.escribirTexto("Hay colision " + mikasa.chocasteCon(casaDelMedio), 500, 350);

		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vidas, 320, 30);

		if (kyojin.chocaEntorno(entorno)) {
			kyojin.cambiarDeDireccion();
		}

		if (kyojin.dañasteAMikasa(mikasa)) {
			vidas--;
		}

		//		if (vidas == 0) {
		//			mikasa = null;
		//			if (mikasa == null) {
		//				entorno.cambiarFont("sans", 20, Color.WHITE);
		//				entorno.escribirTexto("Game Over!", 500, 400);
		//			}
		//		}

		if (mikasa.chocasteCon(casaDeArriba)) { 
			mikasa.chocasteConObstaculo();
		}
		if (mikasa.chocasteCon(casaDelMedio)) { 
			mikasa.chocasteConObstaculo();
		}
		if (mikasa.chocasteCon(casaDeAbajo)) { 
			mikasa.chocasteConObstaculo();
		}
		if (mikasa.chocasteConArbolPequeño(arbolPequeño)) { 
			mikasa.chocasteConObstaculo();
		}
		if (mikasa.chocasteCon(arbolGrande)) { 
			mikasa.chocasteConObstaculo();
		}
		if (kyojin.chocasteCon(casaDeArriba)) { 
			kyojin.cambiarDeDireccion();
		}
		if (kyojin.chocasteCon(casaDelMedio)) { 
			kyojin.cambiarDeDireccion();
		}
		if (kyojin.chocasteCon(casaDeAbajo)) { 
			kyojin.cambiarDeDireccion();
		}
		if (kyojin.chocasteCon(arbolPequeño)) { 
			kyojin.cambiarDeDireccion();
		}
		if (kyojin.chocasteCon(arbolGrande)) { 
			kyojin.cambiarDeDireccion();
		}																		// Anotación para que puedan entender un poco mejor lo que pensé, les dejo de ejemplo el primero:
		if (kyojin.getX() > mikasa.getX() && kyojin.getY() > mikasa.getY()) {	// Si la X del Kyojin es MAYOR a la X de Mikasa && la Y del Kyojin es MAYOR a la Y de Mikasa
			kyojin.perseguirAMikasaIzqSup(mikasa);							    //              K(x+)                     M(x-)              K(y+)                     M(y-)				
		}																		// Si imaginan un gráfico con coordenadas X e Y (pueden dibujarlo para entender mejor)
																				// el kyojin tiene X+ e Y+, entonces estaría en la DerechaInferior del gráfico
																				// para llegar a Mikasa(IzqSup), su X e Y tienen que disminuir (X- e Y-), ya que mikasa tiene esas coordenadas

		if (kyojin.getX() < mikasa.getX() && kyojin.getY() < mikasa.getY()) {					
			kyojin.perseguirAMikasaDerInf(mikasa);														
		}
		if (kyojin.getX() < mikasa.getX() && kyojin.getY() > mikasa.getY()) {
			kyojin.perseguirAMikasaDerSup(mikasa);
		}
		if (kyojin.getX() > mikasa.getX() && kyojin.getY() < mikasa.getY()) {
			kyojin.perseguirAMikasaIzqInf(mikasa);
		}
		if (entorno.estaPresionada('a') && (mikasa.chocasteConEntornoIzquierdo())) {
			mikasa.rotarHaciaIzquierda(entorno);
			//mikasa.caminarHaciaIzquierda(entorno);
		}
		if (entorno.estaPresionada('w') && (mikasa.chocasteConEntornoSuperior())
				&& (mikasa.chocasteConEntornoDerecho())
				&& (mikasa.chocasteConEntornoInferior())
				&& (mikasa.chocasteConEntornoIzquierdo())) {
			mikasa.avanzar(entorno);
		} if (!mikasa.chocasteConEntornoSuperior()){
			mikasa.retroceder(entorno);
		}if (!mikasa.chocasteConEntornoDerecho()){
			mikasa.retroceder(entorno);
		}if (!mikasa.chocasteConEntornoInferior()) {
			mikasa.retroceder(entorno);
		}if (!mikasa.chocasteConEntornoIzquierdo()) {
			mikasa.retroceder(entorno);
		}

		if (entorno.estaPresionada('d') ) {
			mikasa.rotarHaciaDerecha(entorno);
			//mikasa.caminarHaciaDerecha(entorno);
		}
		//		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && this.disparo == null) {
		//			disparo.disparo(entorno);
		//		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
