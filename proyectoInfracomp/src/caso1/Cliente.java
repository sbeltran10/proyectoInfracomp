package caso1;

public class Cliente extends Thread{

	
	//Atributos
	/**
	 * Numero total de mensajes enviados por el cliente
	 */
	private int msjEnviados;
	
	/**
	 * Buffer al cual se enviaran los mensajes
	 */
	private Buffer buffer;
	
	
	//Constructor
	public Cliente(int nMensajes, Buffer nBuffer){
		msjEnviados = nMensajes;
		buffer = nBuffer;
	}
}
