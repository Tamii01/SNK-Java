package juego;

import java.awt.*;
import java.util.Random;

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
	private int vidas;

	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600); 

		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5); //x(400), y(300), velocidad
		casaDeArriba = new Obstaculo(155,95, "casaDeArriba");
		casaDelMedio = new Obstaculo(643,150, "casaDelMedio");
		casaDeAbajo = new Obstaculo(61,410, "casaDeAbajo");
		arbolPequeño = new Obstaculo(690, 470, "arbolPequeño");
		arbolGrande = new Obstaculo(345, 450, "arbolGrande");
		fondo = Herramientas.cargarImagen("fondo-del-juego.png");
		gameOver = Herramientas.cargarImagen("game-over.png");
		juegoTerminado = false;
		kyojines = new Kyojin[4];	
		suero = new Suero(400, 300);

		kyojines[0]= new Kyojin (432, 526, 0.5, 0.15, 0);
		kyojines[1]= new Kyojin (200, 416, 0.5, 0.15, 0);
		kyojines[2]= new Kyojin (340, 316, 0.5, 0.15, 0);
		kyojines[3]= new Kyojin (150, 226, 0.5, 0.15, 0);

		puntaje = 0;
		vidas = 5;

		this.entorno.iniciar();
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
		mikasa.dibujar(entorno);
		suero.dibujar(entorno);

		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("colision " + mikasa.agarroSuero(suero), 500, 300);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		//		entorno.escribirTexto("Vidas: " + vidas, 320, 30);

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
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && disparo == null) {
			this.disparo = mikasa.disparar();				
		}

		//mientras el disparo sea distinto de null, sigue con las demás instrucciones
		if (this.disparo !=null) {
			this.disparo.dibujar(entorno);
			this.disparo.mover(entorno);
			//si el disparo pasa los limites del 
			//entorno, entonces se vuelve null
			if(disparo.getX() > 800 || disparo.getX() < 20 || disparo.getY() > 580 || disparo.getY() < 10 ) {
				this.disparo = null;
			}
		}

		if (this.suero != null) {

			if (colisionConSuero(suero, mikasa)) {
				suero = null;
			}
			if (suero == null) {
				generarSuero();
			}
		}

		//--------------------------CONDICIONES KYOJIN---------------------------------------

		//mientras el kyojin sea distinto de null, sigue con las demás instrucciones
		if (kyojines !=null) { 

			//acá recorro el array de kyojines y voy haciendo que se dibujen, muevan, persigan a mikasa, etc. Lo ideal sería
			//poder usar el array de objetos en vez de poner cada cosa por separado, pero lo del array de objetos, el que 
			//intenté hacer, me tiraba error. Está comentado lo que intenté hacer, arriba de todo.
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
//
//				if (kyojines[i].teDañaron(disparo)) {
//					eliminarKyojin(i);
//				}

				//si los algun kyojin daña a mikasa, se restan vidas
				//y al llegar a 0, se termina el juego
				if (kyojines[i].dañasteAMikasa(mikasa)) {
					this.vidas--;
					if (vidas == 0) {
						juegoTerminado = true;
					}
				}	
			}
		}
	}

	//------------------------------------TERMINA TICK------------------------------------------------	

	public void generarSuero() {
		Random r = new Random();
		int n1 = r.nextInt(100);
		int n2 = r.nextInt(500);

		int cont = 200;
		if (suero == null) {
			for (int i=0; i<=cont;i++) {
				if (i==cont) {
					suero = new Suero(n1,n2);
				}
			}
		}
	}

	public boolean colisionConSuero(Suero s, Mikasa m) {
		return  m.getX() + m.getAncho() / 2 > s.getX() - s.getAncho() / 2 && 
				m.getX() - m.getAncho() / 2 < s.getX() + s.getAncho() / 2 && 
				m.getY() + m.getAlto()  / 2 > s.getY() - s.getAncho() / 2 && 
				m.getY() - m.getAlto()  / 2 < s.getY() + s.getAncho() / 2;
	}

	public boolean dañarKyojin(Proyectil p, Kyojin k) {
		return  k.getX() + k.getAncho() / 2 > p.getX() - p.getAncho() / 2 && 
				k.getX() - k.getAncho() / 2 < p.getX() + p.getAncho() / 2 && 
				k.getY() + k.getAlto()  / 2 > p.getY() - p.getAncho() / 2 && 
				k.getY() - k.getAlto()  / 2 < p.getY() + p.getAncho() / 2;
	}

	//en caso de que se maten kyojines, este metodo regenera nuevos kyojines --> fix
	public void regenerarKyojines(int pos) {
		//recorremos el array de kyojines, si
		//es null, regeneramos un nuevo kyojin

		for (int i = 0; i<kyojines.length; i++) {
			if (kyojines[i] == null) {

				if(i == 0)
					kyojines[i] = new Kyojin (100, 240, 0.05, 0.15, 0);			//puse lugares random, pero todavía no se generaron

				if(i == 1)
					kyojines[i] = new Kyojin (350, 400, 0.05, 0.15, 0);

				if(i == 3) 
					kyojines[i] = new Kyojin (500, 540, 0.05, 0.15, 0);
			}
		}
	}

	public void eliminarKyojin(int pos) {

		Kyojin[] nuevos = new Kyojin[this.kyojines.length - 1];

		for (int i =0; i < pos; i++) {
			nuevos[i] = this.kyojines[i];
		}

		for (int i = pos; i < this.kyojines.length - 1; i++) {
			nuevos[i] = this.kyojines[i + 1];
		}

		this.kyojines = nuevos;
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
