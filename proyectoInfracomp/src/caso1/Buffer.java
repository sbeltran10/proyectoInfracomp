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

	public synchronized boolean depositar(Mensaje msj){

		if(buff.size()==capacidad){
			return false;
		}

		buff.add(msj);
		return true;
	}

	public int responder(){

		while(buff.size()==0 && totalClientes>0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (totalClientes==0) {
			return -1;
		}else{
		Mensaje aResponder = buff.get(0);
		synchronized(aResponder){
			buff.remove(aResponder);
			aResponder.incrementarMensaje();
			System.out.println("Se respondio el mensaje " + aResponder.darSecuencia());
			aResponder.notify();
		}
		return aResponder.darSecuencia();
		}
	}

	public void sacarCliente(){
		--totalClientes;
	}

	public int darTotalClientes(){
		return totalClientes;
	}
	
	public ArrayList<Mensaje> darBuffer(){
		return buff;
	}
}
