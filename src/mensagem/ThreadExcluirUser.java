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

public class ThreadExcluirUser implements Runnable {

	
	
	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;

	public ThreadExcluirUser(Requisicoes dados, ObjectOutputStream oos,
			Socket socket, ObjectInputStream ois) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
	}

	@Override
	public void run() {

		String email = dados.getEmail();
		SerializadorUser.carregaUser();
		
		for(int i=0; i < SerializadorUser.user.size(); i++){
			if(SerializadorUser.user.get(i).getEmail().equals(email)){
				SerializadorUser.user.remove(i);
				break;
			}
		}
		
		SerializadorUser.salvarUser();
		
		try{
		oos.writeObject("Ok");
		ois.close();
		oos.close();
		socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
