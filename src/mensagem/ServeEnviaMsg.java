package mensagem;

import java.io.InputStream;

public class ServeEnviaMsg implements Runnable {

	private InputStream cliente;
	private ServidorX servidor;
	
	public ServeEnviaMsg (InputStream cliente, ServidorX servidor){
		this.cliente = cliente;
		this.servidor = servidor;
	}
	
	@Override
	public void run() {

		
		
	}

	
	
}
