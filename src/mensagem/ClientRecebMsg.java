package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientRecebMsg implements Runnable {

	private ObjectOutputStream oos;
	private String email;
	private String dominio;

	public ClientRecebMsg(ObjectOutputStream oos, String email, String domin) {
		this.oos = oos;
		this.email = email;
		this.dominio = domin;
	}

	@Override
	public void run() {
		Requisicoes r = new Requisicoes("lerMsg", this.email, null, null, this.dominio);
		try {
			oos.writeObject(r);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
