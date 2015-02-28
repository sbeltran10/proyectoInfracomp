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
	
	public boolean depositar(){
		
		if(buff.size()==capacidad){

			return false;
		}
	
		return true;
	}
	
	public int responder(){
		
		while(buff.size()==0){
			try {
				System.err.println("Server se durmio");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Mensaje aResponder = buff.get(0);
		synchronized (aResponder) {
			buff.remove(aResponder);
			aResponder.incrementarMensaje();
			aResponder.notify();
			System.out.println("Se respondio el mensaje " + aResponder.darSecuencia() + " del cliente " + aResponder.darcliente());
		}
		return aResponder.darSecuencia();
	}
	
	public void sacarCliente(){
		--totalClientes;
		System.err.println(totalClientes);
	}
	
	public int darTotalClientes(){
		return totalClientes;
	}
	
	public ArrayList<Mensaje> darbuffer(){
		return buff;
	}
}

