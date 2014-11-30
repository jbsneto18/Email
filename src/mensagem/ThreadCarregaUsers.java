package mensagem;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import CadastroUser.Cadastro;
import Serializador.Serializador;
import Serializador.SerializadorUser;

public class ThreadCarregaUsers implements Runnable {

	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;
	private String dominio;

	public ThreadCarregaUsers(Requisicoes dados, ObjectOutputStream oos,
			Socket socket, ObjectInputStream ois, String domin) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
		this.dominio=domin;
	}
	
	@Override
	public void run() {

		Cadastro cadst = (Cadastro) dados.getCadastro();
		ArrayList<Cadastro> c = new ArrayList<Cadastro>();
		
		if (this.dominio.equals("apocalipse"))
		{
			for (int i=0; i<SerializadorUser.user.size(); i++)
			{
				SerializadorUser.carregaUser("apocalipse");
				c.add(SerializadorUser.user.get(i));
			}
		}
		
		else
		{
			for (int i=0; i<SerializadorUser.userB.size(); i++)
			{
				SerializadorUser.carregaUser("ikinho");
				c.add(SerializadorUser.userB.get(i));
			}
		}
		
		try {
			oos.writeObject(c);
			ois.close();
			oos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
