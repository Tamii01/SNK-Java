package juego;

import java.awt.*;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
	private Kyojin kyojin;
	private Obstaculo casaDeArriba, casaDelMedio, casaDeAbajo, arbolPequeño, arbolGrande;
	private Kyojin[] kyojines;
	private Proyectil disparo;
//	private Obstaculo[] obstaculos = new Obstaculo[5];
	private Suero suero;
	private Image fondo, gameOver;
	private boolean juegoTerminado;

	private int puntaje;
	private int vidas;

	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600); 

		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2, 5, 60, 20,0); //x(400), y(300), velocidad, alto, ancho
		kyojin = new Kyojin(100, 240, 0.5, 0.15, 0);  //x, y, velocidad, tamaño, angulo
		casaDeArriba = new Obstaculo(155,95, "casaDeArriba");
		casaDelMedio = new Obstaculo(643,150, "casaDelMedio");
		casaDeAbajo = new Obstaculo(61,410, "casaDeAbajo");
		arbolPequeño = new Obstaculo(690, 470, "arbolPequeño");
		arbolGrande = new Obstaculo(345, 450, "arbolGrande");
		fondo = Herramientas.cargarImagen("fondo-del-juego.png");
		gameOver = Herramientas.cargarImagen("game-over.png");
//		disparo = null;	
		juegoTerminado = false;
		kyojines = new Kyojin[4];	
		suero = new Suero(500,550);
		
		kyojines[0]= new Kyojin (432, 526, 0.5, 0.15, 0);
		kyojines[1]= new Kyojin (200, 416, 0.5, 0.15, 0);
		kyojines[2]= new Kyojin (340, 316, 0.5, 0.15, 0);
		kyojines[3]= new Kyojin (150, 226, 0.5, 0.15, 0);
		
//		obstaculos[0] = casaDeArriba;
//		obstaculos[1] = casaDelMedio;
//		obstaculos[2] = casaDeAbajo;
//		obstaculos[3] = arbolPequeño;
//		obstaculos[4] = arbolGrande;
//		
//		for (Obstaculo o : obstaculos) {
//			o.dibujar(entorno);
//		} 
		
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
		kyojin.dibujar(entorno);
		kyojin.mover();
		kyojin.perseguirAMikasa(mikasa);
		casaDeArriba.casaDeArriba(entorno);
		casaDelMedio.casaDelMedio(entorno);
		casaDeAbajo.casaDeAbajo(entorno);
		arbolPequeño.arbolPequeño(entorno);
		arbolGrande.arbolGrande(entorno);
		suero.dibujar(entorno);
		mikasa.dibujar(entorno);
		
		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vidas, 320, 30);

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
		int i = colisionaKyojin(disparo.getX(), disparo.getY(), disparo.getTamaño());
		if (i != -1) {
			kyojines[i] = null;
		}
			//si el disparo pasa los limites del 
			//entorno, entonces se vuelve null
			
			
			//la idea es que si es true cuando mikasa agarra el suero, este se elimine
			if (mikasa.agarroSuero(suero)) {
				this.suero = null;
			}
			if(disparo.getX() > 780 || disparo.getX() < 20 || disparo.getY() > 580 || disparo.getY() < 29 ) {
				this.disparo = null;
			}
		

//--------------------------CONDICIONES KYOJIN---------------------------------------
		
		//mientras el kyojin sea distinto de null, sigue con las demás instrucciones
		
	}
		
//------------------------------------TERMINA TICK------------------------------------------------	

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
	
	//en caso de que se maten kyojines, este metodo regenera nuevos kyojines --> fix
	public void regenerarKyojines() {
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
