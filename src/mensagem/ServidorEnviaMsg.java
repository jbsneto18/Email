package mensagem;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServidorEnviaMsg implements Runnable{

	private Mensagem m;
	private ObjectOutputStream oos;
	private String dominio;

	public ServidorEnviaMsg(ObjectOutputStream oos, Mensagem m, String domin) {
		
		this.oos = oos;
		this.m = m;
		this.dominio = domin;
	}

	@Override
	public void run() {
		try {
			Requisicoes r = new Requisicoes("enviarServer", null, m,null, dominio);
			oos.writeObject(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
