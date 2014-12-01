package mensagem;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientPedeEmails implements Runnable {

	private ObjectOutputStream oos;
	private String email;
	private String dominio;

	public ClientPedeEmails(ObjectOutputStream oos, String email, String domin) {
		this.oos = oos;
		this.email = email;
		this.dominio = domin;
	}

	@Override
	public void run() {
		
		try {
			Requisicoes r = new Requisicoes("lerMsgs", this.email, null, null, this.dominio);
			oos.writeObject(r);//ENVIO P/ SERVIDOR
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
