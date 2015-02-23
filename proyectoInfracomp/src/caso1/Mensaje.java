package caso1;

public class Mensaje {

	//Atributos
	/**
	 * Secuencia de numeros que representa el mensaje
	 */
	private int secuenciaNum;
	
	//Constructor
	public Mensaje(int nNum){
		secuenciaNum = nNum;
	}
	
	//Getters
	public int darSecuencia(){
		return secuenciaNum;
	}
	
	/**
	 * Incrementa la secuencia de numeros en 1 y luego la retorna
	 * @return
	 */
	public int incrementarMensaje(){
		return ++secuenciaNum;
	}
}
