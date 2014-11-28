package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientRecebMsg implements Runnable {

	private ObjectInputStream ois;

	public ClientRecebMsg(ObjectInputStream ois) {
		this.ois = ois;
	}

	@Override
	public void run() {
		
		String retorno;
		try {
			retorno = (String) ois.readObject();
			System.out.println(retorno);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
