package caso1;


public class Server extends Thread{
	
	//Atributos
	/**
	 * Buffer del cual retirara mensajes
	 */
	private Buffer buffer;
	
	//Constructor
	public Server(Buffer nBuffer){
		buffer = nBuffer;
	}
}
