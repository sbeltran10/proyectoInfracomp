package caso1;

public class Cliente extends Thread{


	//Atributos
	/**
	 * Numero total de mensajes enviados por el cliente
	 */
	private int msjEnviados;

	/**
	 * Identificador del cliente
	 */
	private int id;
	/**
	 * Buffer al cual se enviaran los mensajes
	 */
	private Buffer buffer;

	//Constructor
	public Cliente(int nMensajes, Buffer nBuffer, int nId){
		msjEnviados = nMensajes;
		buffer = nBuffer;
		id = nId;
	}

	//Run
	public void run(){

		
		while(msjEnviados>0){
			int secuencia = (int) (Math.random()*5);
			Mensaje msj = new Mensaje(secuencia);

			synchronized (buffer) {

				while(!buffer.depositar(msj)){
					yield();
				}
				
				System.out.print("El cliente " + id + " deposito el mensaje: " + msj.darSecuencia());
				msjEnviados--;
				
				try {
					msj.wait();
				} catch (InterruptedException e) {}
			}
		}
		
//		buffer.sacarCliente();
	}
}

