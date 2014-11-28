package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ClientLerEmails implements Runnable {

	private ObjectInputStream ois;
	private ArrayList<Mensagem> retorno;

	public ClientLerEmails(ObjectInputStream ois) {
		this.ois = ois;
	}

	@Override
	public void run() {

		try {
			retorno = (ArrayList<Mensagem>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Mensagem> getEmails() {
		return this.retorno;
	}

}
