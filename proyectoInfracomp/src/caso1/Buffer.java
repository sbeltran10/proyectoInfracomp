package caso1;

import java.util.ArrayList;

public class Buffer {

	//Atributos
	/**
	 * Lista en donde se guardan los mensajes
	 */
	private ArrayList buff;
	
	/**
	 * Maximo numero de mensajes que pueden haber en el buffer
	 */
	private int capacidad;

	//Constructor
	public Buffer(int nCap){
		capacidad = nCap;
	}
}
