package juego;

import java.awt.*;

import java.util.concurrent.ThreadLocalRandom;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
	private Obstaculo casaDeArriba, casaDelMedio, casaDeAbajo, arbolPequeño, arbolGrande;
	private Kyojin[] kyojines;
	private Proyectil disparo;
	private Suero suero;
	private Image fondo, gameOver;
	private boolean juegoTerminado;
	private int puntaje;

	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Pucheta Tamara", 800, 600); 

		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5, 60, 20); //x(400), y(300), velocidad, alto, ancho
		suero = new Suero(500,550);
		casaDeArriba = new Obstaculo(155,95, "casaDeArriba");
		casaDelMedio = new Obstaculo(643,150, "casaDelMedio");
		casaDeAbajo = new Obstaculo(61,410, "casaDeAbajo");
		arbolPequeño = new Obstaculo(690, 470, "arbolPequeño");
		arbolGrande = new Obstaculo(345, 450, "arbolGrande");
		fondo = Herramientas.cargarImagen("fondo-del-juego.png");
		gameOver = Herramientas.cargarImagen("game-over.png");
		juegoTerminado = false;
		disparo = new Proyectil(mikasa.getX(), mikasa.getY(), mikasa.getAngulo());
		puntaje = 0;	
		generarKyojines();
		this.entorno.iniciar();
	}

	public void generarKyojines() {

		int x = ThreadLocalRandom.current().nextInt(520, 780);
		int y = ThreadLocalRandom.current().nextInt(400, 580);
		kyojines = new Kyojin[6];	

		kyojines[0] = new Kyojin (x, y, 0.5, 0.15, 0);
		kyojines[1] = new Kyojin (x, y, 0.5, 0.15, 0);
		kyojines[2] = new Kyojin (x, y, 0.5, 0.15, 0);
		kyojines[3] = new Kyojin (x, y, 0.5, 0.15, 0);
		kyojines[4] = new Kyojin (x, y, 0.5, 0.15, 0);
		kyojines[5] = new Kyojin (x, y, 0.5, 0.15, 0);
	}
	public void tick() {

		if (juegoTerminado == true) {
			perdiste();
		}
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0, 2.5);
		mikasa.dibujar(entorno);
		casaDeArriba.casaDeArriba(entorno);
		casaDelMedio.casaDelMedio(entorno);
		casaDeAbajo.casaDeAbajo(entorno);
		arbolPequeño.arbolPequeño(entorno);
		arbolGrande.arbolGrande(entorno);
		suero.dibujar(entorno);
		mikasa.dibujar(entorno);

		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);

		if (entorno.estaPresionada('a') && (mikasa.chocasteConEntornoIzquierdo())) {
			mikasa.rotarHaciaIzquierda(entorno);
		}

		if (entorno.estaPresionada('w') && (mikasa.chocasteConEntornoSuperior())
				&& (mikasa.chocasteConEntornoDerecho())
				&& (mikasa.chocasteConEntornoInferior())
				&& (mikasa.chocasteConEntornoIzquierdo())) {
			mikasa.avanzar(entorno);
		} 

		if (entorno.estaPresionada('d') ) {
			this.mikasa.rotarHaciaDerecha(entorno);
		}

		if (!mikasa.chocasteConEntornoSuperior()){
			this.mikasa.noAvanzar(entorno);
		}

		if (!mikasa.chocasteConEntornoDerecho()){
			this.mikasa.noAvanzar(entorno);
		}

		if (!mikasa.chocasteConEntornoInferior()) {
			this.mikasa.noAvanzar(entorno);
		}

		if (!mikasa.chocasteConEntornoIzquierdo()) {
			this.mikasa.noAvanzar(entorno);
		}

		if (mikasa.chocasteCon(casaDeArriba)) { 
			this.mikasa.chocasteConObstaculo();
		}

		if (mikasa.chocasteCon(casaDelMedio)) { 
			this.mikasa.chocasteConObstaculo();
		}

		if (mikasa.chocasteCon(casaDeAbajo)) { 
			this.mikasa.chocasteConObstaculo();
		}

		if (mikasa.chocasteCon(arbolGrande)) { 
			this.mikasa.chocasteConObstaculo();
		}
		
		//si se presiona la tecla espacio y el disparo está null
		//se genera un nuevo disparo
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && disparo==null) {
			this.disparo = mikasa.disparar();			
		}
		//mientras el disparo sea distinto de null, sigue con las demás instrucciones
		if (this.disparo !=null) {	
			this.disparo.dibujarse(entorno);
			this.disparo.avanzar(entorno);	

			//Si el disparo se sale de los limites del entorno, se elimina
			if(disparo.getX() > 800 || disparo.getX() < 20 || disparo.getY() > 580 || disparo.getY() < 10) {
				this.disparo = new Proyectil(mikasa.getX(), mikasa.getY(), mikasa.getAngulo());
			}	
		}
		//mientras el suero exista
		if (this.suero != null) {
			//si mikasa colisiona con el suero, este mismo se elimina
			if (mikasa.agarroSuero(suero)) {
				this.suero = null;
			} 
			//y se genera en otro lugar del entorno
			if (suero==null) {
				generarSuero();
			}
		}
		// -------------------------------CONDICIONES KYOJIN-------------------------
		if (kyojines !=null) { 

			//acá recorro el array de kyojines y voy haciendo que se dibujen, muevan, persigan a mikasa, etc.
			for (int i = 0; i < kyojines.length; i++) {
				kyojines[i].dibujar(entorno);
				kyojines[i].mover();
				kyojines[i].perseguirAMikasa(mikasa);

				if (kyojines[i].estasDentroDelLimiteDerecho())
					kyojines[i].cambiarDeDireccion();					

				if (kyojines[i].estasDentroDelLimiteIzquierdo())
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].estasDentroDelLimiteInferior())
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].estasDentroDelLimiteSuperior())
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].chocasteCon(casaDeArriba)) 
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].chocasteCon(casaDelMedio))
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].chocasteCon(casaDeAbajo))
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].chocasteCon(arbolPequeño))  
					kyojines[i].cambiarDeDireccion();

				if (kyojines[i].chocasteCon(arbolGrande))
					kyojines[i].cambiarDeDireccion();

				if (colision() == true) {
					kyojines[0] = null;
					puntaje+=10;
				}
				if (kyojines[i] == null) {
					this.kyojines = regenerarKyojin(kyojines[i]);
				}
			}
		}
	}
	
	//-----------------------------------------TERMINA EL TICK------------------------------------------------------------------------

	
	//metodo que regenera kyojines en un lugar random, si el kyojin de la posicion 0 es null, este mismo se regenera de nuevo
	private Kyojin[] regenerarKyojin(Kyojin kyojin) {
		int x = ThreadLocalRandom.current().nextInt(20, 780);
		int y = ThreadLocalRandom.current().nextInt(29, 580);

		for (int i=0; i<kyojines.length;i++) {
			if (kyojines[i] == null)
				if (i==0)
					kyojines[0] = new Kyojin (x, y, 0.5, 0.15, 0);
			if (i==1)
				kyojines[1] = new Kyojin (x, y, 0.5, 0.15, 0);
			if (i==2)
				kyojines[2] = new Kyojin (x, y, 0.5, 0.15, 0);
			if (i==3)
				kyojines[3] = new Kyojin (x, y, 0.5, 0.15, 0);
			if (i==4)
				kyojines[4] = new Kyojin (x, y, 0.5, 0.15, 0);
			if (i==5)
				kyojines[5] = new Kyojin (x, y, 0.5, 0.15, 0);
		}
		return kyojines;
	}

	//genera el suero en una posicion random entre los limites del entorno
	public void generarSuero() {
		int x = ThreadLocalRandom.current().nextInt(20, 780);
		int y = ThreadLocalRandom.current().nextInt(29, 580);
		if (suero == null) {
			suero = new Suero(x,y);
		}
	}
	//comprueba si hubo colision entre el kyojin y el disparo
	public boolean colision() {
		for (int i=0; i<kyojines.length;i++) {
			if (kyojines[i].getX() + kyojines[i].getAncho() + 20 / 2 > disparo.getX() - disparo.getAncho() / 2 && 
					kyojines[i].getX() - kyojines[i].getAncho() + 20 / 2 < disparo.getX() + disparo.getAncho() / 2 && 
					kyojines[i].getY() + kyojines[i].getAlto()  + 20 / 2 > disparo.getY() - disparo.getAlto()  / 2 && 
					kyojines[i].getY() - kyojines[i].getAlto()  + 20 / 2 < disparo.getY() + disparo.getAlto()  / 2) {
	//				this.disparo = null;  ---> en teoria, si se descomenta, funciona, pero tira el error de que disparo es null.
				return true;
			}
		}
		return false;
	}
	//Si juegoTerminado es true, llama a perdiste
	//y en la pantalla se muestra la imagen de gameOver
	public void perdiste() {
		entorno.dibujarImagen(gameOver, 400, 300, 0);							
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
