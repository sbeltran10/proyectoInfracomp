package caso1;


import java.util.ArrayList;

public class Buffer {

	//Atributos
	/**
	 * Lista en donde se guardan los mensajes
	 */
	private ArrayList<Mensaje> buff;
	
	/**
	 * Maximo numero de mensajes que pueden haber en el buffer
	 */
	private int capacidad;
	
	/**
	 * Numero total de clientes
	 * @param nCap
	 */
	private int totalClientes;

	//Constructor
	public Buffer(int nCap, int nTotal){
		capacidad = nCap;
		totalClientes = nTotal;
		buff = new ArrayList<Mensaje>();
	}
	
	//Metodos depositar y responder (Sincronicos)
	public synchronized void depositar(){
		
	}
	
	public synchronized int responder(){
		while(buff.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Mensaje aResponder = buff.remove(0);
		aResponder.incrementarMensaje();
		aResponder.notify();
		return aResponder.darSecuencia();
	}
	
}
