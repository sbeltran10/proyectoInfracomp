package caso1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConsultaGDTS {
	public final static String RUTA_ARCHIVO = "data/info.txt";

	//Main
	public static void main(String[] args){

		int capBuffy = 1;

		Buffer buffy;
		Server[] servers;
		Cliente[] clientes;

		try {

			//Lee el numero de servidores y clientes para inicializar los arreglos y el buffer

			FileReader fr = new FileReader(new File(RUTA_ARCHIVO));
			BufferedReader br = new BufferedReader(fr);

			int nServidores = Integer.parseInt(br.readLine().split("=")[1]);
			int nClientes = Integer.parseInt(br.readLine().split("=")[1]);
			br.readLine();

			servers = new Server[nServidores];
			clientes = new Cliente[nClientes];
			buffy = new Buffer(capBuffy,nClientes);


			//Se inicializan y empiezan a correr los thread servidores
			for(int i = 0; i<nServidores;i++){
				servers[i] = new Server(buffy, i);
				
				servers[i].start();
			}

			//Se inicializan y empiezan a correr los thread clientes junto con el numero de mensajes que enviaran
			for(int i = 0; i<nClientes;i++){

				int nMensajesALeer = Integer.parseInt(br.readLine());

				clientes[i] = new Cliente(nMensajesALeer, buffy, i);
				clientes[i].start();
			}

			br.close();
			fr.close();

		} catch (Exception e) {e.printStackTrace();
		}
		

	}
}
