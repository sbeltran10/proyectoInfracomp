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

		System.out.println("llego el cliente "+id);
		while(msjEnviados>0){
			int secuencia = (int) (Math.random()*5);
			Mensaje msj = new Mensaje(secuencia,id);


			while(!buffer.depositar()){
				yield();
			}


			synchronized(msj){
				try {
					synchronized (buffer) {
						buffer.darBuffer().add(msj);
						System.out.println("El cliente " + id + " depositó el mensaje: " + msj.darSecuencia());
						buffer.notify();
						--msjEnviados;
					}
					msj.wait();
				} catch (InterruptedException e) {}
			}
		}
		synchronized(buffer){
			System.err.println("Se retiró el cliente " + id);
			buffer.sacarCliente();
			buffer.notifyAll();
		}
	}
}

