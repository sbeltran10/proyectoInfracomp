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

		System.out.println("Cliente llego");
		while(msjEnviados>0){
			int secuencia = (int) (Math.random()*30);
			Mensaje msj = new Mensaje(secuencia, id);

			synchronized (buffer) {

				while(!buffer.depositar()){
					yield();
				}

				System.out.println("El cliente " + id + " deposito el mensaje: " + msj.darSecuencia());
				buffer.darbuffer().add(msj);
				buffer.notifyAll();
				--msjEnviados;
			}

			synchronized (msj) {
				try {
					msj.wait();
				} catch (InterruptedException e) {}
			}

		}

		synchronized (buffer) {
			System.err.println("Se largo un cliente " + id );
			buffer.sacarCliente();
		}
	}
}

