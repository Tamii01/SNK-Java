package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {   //CLASE (anotacion mia xd sorry;  july)

   // ATRIBUTOS 

	private double x;            //posicion en X -
	private double y;            //posicion en Y |
	private double anchoCasa;    
	private double altoCasa;
	private double anchoArbol;
	private double altoArbol;
	private double angulo;

	private Image casadearriba;
	private Image casadelmedio;
	private Image casadeabajo; 
	private Image arbolgrande;
	private Image arbolpequeño;
	
	
	// METODOS 
	
	// Método Constructor 
	
	public Obstaculo(double x, double y) {  
		this.x = x;
		this.y = y;
		this.anchoCasa = 690;  
		this.altoCasa = 492;    
		this.altoArbol = 350;  
		this.anchoArbol = 600; 
		this.angulo = 0;                                                     // ANOTACION VIEJA = ANOTACION NUEVA  
		this.casadearriba = Herramientas.cargarImagen("casa-de-arriba.png"); // casa invertida = casa de arriba 
		this.casadelmedio = Herramientas.cargarImagen("casa-del-medio.png"); // casa = casa del  medio
		this.casadeabajo = Herramientas.cargarImagen("casa-de-abajo.png");   // nueva casa agregada
		this.arbolgrande = Herramientas.cargarImagen("arbol-grande.png");    // nuevo arbol agregado
		this.arbolpequeño = Herramientas.cargarImagen("arbol-pequeño.png");  // arbol = arbol pequeño
		
	}

	public void generarObstaculo(Entorno e) {
		// CASA DE ARRIBA
		e.dibujarImagen(casadearriba, 155, 95, angulo, 0.40); // posición en X, posición en Y, ángulo, tamaño
		// CASA DEL MEDIO
    	e.dibujarImagen(casadelmedio, 643, 150, angulo, 0.38);
    	// CASA DE ABAJO
    	e.dibujarImagen(casadeabajo, 61, 410, angulo, 0.45);
    	// ARBOL GRANDE
    	e.dibujarImagen(arbolgrande, 345, 317, angulo, 1.5);
    	// ARBOL PEQUEÑO
    	e.dibujarImagen(arbolpequeño, 690, 470, angulo, 1.5);     
	}
	 
/*     ACLARACIÓN MÉTODO ANTERIOR → public void generarObstaculo 
 * 
 *     X = al AUMENTAR el número la imagen se corre más a la DERECHA, al DISMINUIR el número la imagen se corre más a la IZQUIERDA
 *     
       Y = al AUMENTAR el número la imagen se corre más ABAJO, al DISMINUIR el número la imagen se corre más para ARRIBA
       
*/	
	
	
	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public double getAltoCasa() {
		return altoCasa;
	}

	public double getAnchoCasa() {
		return anchoCasa;
	}
	
	public double getAltoArbol() {
		return altoArbol;
	}
	
	public double getAnchoArbol() {
		return anchoArbol;
	}
}

