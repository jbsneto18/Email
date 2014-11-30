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

public class ThreadCadastroUser implements Runnable {

	
	
	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;


	public ThreadCadastroUser(Requisicoes dados, ObjectOutputStream oos, Socket socket, ObjectInputStream ois) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
	}


	@Override
	public synchronized void run() {

		try {
			Cadastro c = (Cadastro) dados.getCadastro();
			SerializadorUser.addUser(c, dados.getDominio());
			SerializadorUser.salvarUser(dados.getDominio());
			oos.writeObject("Ok");
			oos.close();
			ois.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
