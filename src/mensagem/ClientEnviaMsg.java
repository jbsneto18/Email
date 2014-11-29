package mensagem;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientEnviaMsg implements Runnable{

	private Mensagem m;
	private ObjectOutputStream oos;

	public ClientEnviaMsg(ObjectOutputStream oos, Mensagem m) {
		
		this.oos = oos;
		this.m = m;
	}

	@Override
	public void run() {
		try {
			Requisicoes r = new Requisicoes("enviar", null, m,null);
			oos.writeObject(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
