package caso1;

public class Mensaje {

	//Atributos
	/**
	 * Secuencia de numeros que representa el mensaje
	 */
	private int secuenciaNum;
	
	private int cliente;
	
	//Constructor
	public Mensaje(int nNum, int nCli){
		secuenciaNum = nNum;
		cliente=nCli;
	}
	
	//Getters
	public int darSecuencia(){
		return secuenciaNum;
	}
	
	public int darIdCliente(){
		return  cliente;
	}
	
	/**
	 * Incrementa la secuencia de numeros en 1 y luego la retorna
	 * @return
	 */
	public int incrementarMensaje(){
		return ++secuenciaNum;
	}
}
