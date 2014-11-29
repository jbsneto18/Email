package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientRecebMsg implements Runnable {

	private ObjectOutputStream oos;
	private String email;

	public ClientRecebMsg(ObjectOutputStream oos, String email) {
		this.oos = oos;
		this.email = email;
	}

	@Override
	public void run() {
		Requisicoes r = new Requisicoes("lerMsg", email, null);
		try {
			oos.writeObject(r);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
