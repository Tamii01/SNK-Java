package juego;

import java.awt.*;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//	private Kyojin kyojin; // sacalo
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
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

<<<<<<< HEAD
		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5, 60, 20, 0); //x(400), y(300), velocidad, alto, ancho, angulo
=======
<<<<<<< HEAD
		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5, 60, 20, 0); //x(400), y(300), velocidad, alto, ancho, angulo
=======
<<<<<<< HEAD
		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5); //x(400), y(300), velocidad
=======
		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5, 60, 20,0); //x(400), y(300), velocidad, alto, ancho
		kyojin = new Kyojin(100, 240, 0.5, 0.15, 0);  //x, y, velocidad, tamaño, angulo
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
		casaDeArriba = new Obstaculo(155,95, "casaDeArriba");
		casaDelMedio = new Obstaculo(643,150, "casaDelMedio");
		casaDeAbajo = new Obstaculo(61,410, "casaDeAbajo");
		arbolPequeño = new Obstaculo(690, 470, "arbolPequeño");
		arbolGrande = new Obstaculo(345, 450, "arbolGrande");
		fondo = Herramientas.cargarImagen("fondo-del-juego.png");
		gameOver = Herramientas.cargarImagen("game-over.png");
<<<<<<< HEAD
=======
//		disparo = null;	
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
		juegoTerminado = false;
		kyojines = new Kyojin[4];	
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
		suero = new Suero(400, 300, 60, 20);
		
=======
		suero = new Suero(400, 300);

>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
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
<<<<<<< HEAD
//		entorno.escribirTexto("Vidas: " + vidas, 320, 30);
=======
<<<<<<< HEAD
//		entorno.escribirTexto("Vidas: " + vidas, 320, 30);
=======
		//		entorno.escribirTexto("Vidas: " + vidas, 320, 30);
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a

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
<<<<<<< HEAD

		//si se presiona la tecla espacio y el disparo está null
		//se genera un nuevo disparo
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && disparo == null) {
			this.disparo = mikasa.disparar();				
		}

		//mientras el disparo sea distinto de null, sigue con las demás instrucciones
		if (this.disparo !=null) {
<<<<<<< HEAD
				this.disparo.dibujar(entorno);
				this.disparo.mover(entorno);
=======
<<<<<<< HEAD
				this.disparo.dibujar(entorno);
				this.disparo.mover(entorno);
=======
			this.disparo.dibujar(entorno);
			this.disparo.mover(entorno);
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
			//si el disparo pasa los limites del 
			//entorno, entonces se vuelve null
			if(disparo.getX() > 800 || disparo.getX() < 20 || disparo.getY() > 580 || disparo.getY() < 10 ) {
				this.disparo = null;
			}
<<<<<<< HEAD
			
			//la idea es que si es true cuando mikasa agarra el suero, este se elimine
			
		if (this.suero != null) {
			suero.dibujar(entorno);
			
			
			if (mikasa.agarroSuero(suero)) {
				this.suero = null;
<<<<<<< HEAD
=======
=======
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
		}
	}


		if (this.suero != null) {

			if (colisionConSuero(suero, mikasa)) {
				suero = null;
			}
			if (suero == null) {
				generarSuero();
			}
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
		}
	}


		//--------------------------CONDICIONES KYOJIN---------------------------------------

		//mientras el kyojin sea distinto de null, sigue con las demás instrucciones
		if (kyojines !=null) { 

=======
		if (kyojines !=null) { 
			
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
			//acá recorro el array de kyojines y voy haciendo que se dibujen, muevan, persigan a mikasa, etc. Lo ideal sería
			//poder usar el array de objetos en vez de poner cada cosa por separado, pero lo del array de objetos, el que 
			//intenté hacer, me tiraba error. Está comentado lo que intenté hacer, arriba de todo.
			for (int i = 0; i < kyojines.length; i++) {
//				kyojines[i].dibujar(entorno);
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
<<<<<<< HEAD
	}
}
<<<<<<< HEAD

		
//------------------------------------TERMINA TICK------------------------------------------------	

	
=======

=======
		//si se presiona la tecla espacio y el disparo está null
		//se genera un nuevo disparo
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && disparo == null) {
			this.disparo = mikasa.disparar();				
		}
		
		//mientras el disparo sea distinto de null, sigue con las demás instrucciones
		if (this.disparo !=null) {	
				this.disparo.dibujarse(entorno);
				this.disparo.avanzar(entorno);	
				
			}
//		int i = colisionaKyojin(disparo.getX(), disparo.getY(), disparo.getTamaño());
//		if (i != -1) {
//			kyojines[i] = null;
//		}
			//si el disparo pasa los limites del 
			//entorno, entonces se vuelve null
			
			
			//la idea es que si es true cuando mikasa agarra el suero, este se elimine
			if (mikasa.agarroSuero(suero)) {
				this.suero = null;
			}
			if(disparo.getX() > 780 || disparo.getX() < 20 || disparo.getY() > 580 || disparo.getY() < 29 ) {
				this.disparo = null;
			}
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
		

<<<<<<< HEAD
	
=======
//--------------------------CONDICIONES KYOJIN---------------------------------------
		
		//mientras el kyojin sea distinto de null, sigue con las demás instrucciones
		
	}

<<<<<<< HEAD
	//------------------------------------TERMINA TICK------------------------------------------------	

=======
	//hay que arreglar la colision, pero la idea es recorrer el array de kyojines, si la X e Y de cada kyojin colisiona
	//con el disparo, este mismo se elimina y se le suman 10 puntos
//	public void disparoMataKyojin() {
//		for (int i = 0; i<kyojines.length; i++) {
//			if(disparo !=null && 
//			   disparo.getX() + disparo.getTamaño() <= kyojines[i].getX() - kyojines[i].getTamaño() / 2 + 20 &&
//			   disparo.getX() - disparo.getTamaño() >= kyojines[i].getX() + kyojines[i].getTamaño() / 2 + 20 &&
//			   disparo.getY() - disparo.getTamaño() <= kyojines[i].getY() - kyojines[i].getTamaño() / 2 + 20 &&
//			   disparo.getY() + disparo.getTamaño() >= kyojines[i].getY() + kyojines[i].getTamaño() / 2 + 20) {
//			   this.kyojines[i] = null;
//			   this.disparo = null;
//			   puntaje +=10;
//			}
//		}
//	}
	private int colisionaKyojin(double x, double y,double tamaño) {
		for (int i = 0; i < kyojines.length; i++) {
			if (kyojines[i] != null
					&& Math.hypot((kyojines[i].getX() - x), (kyojines[i].getY() - y)) <= kyojines[i].getTamaño()-tamaño)
				return i;
		}
		return -1;
	}
	
	//metodo que contiene un contador para simular que este es el tiempo
	//en donde cuando se llega a 200, se genera un nuevo suero en un lugar random entre
	//100 y 500 --> fix
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
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

>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
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
