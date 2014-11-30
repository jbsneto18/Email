package mensagem;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class CarregaUsers implements Runnable{

	private ObjectOutputStream oos;
	private String dominio;

	public CarregaUsers(ObjectOutputStream oos, String domin) {
		
		this.oos = oos;
		this.dominio = domin;
	}

	@Override
	public void run() {
		try {
			Requisicoes r = new Requisicoes("carregaUsers", null, null, null, this.dominio);
			oos.writeObject(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
