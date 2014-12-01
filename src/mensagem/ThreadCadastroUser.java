package mensagem;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import CadastroUser.Cadastro;
import Serializador.Serializador;
import Serializador.SerializadorUser;

public class ThreadCadastroUser implements Runnable {

	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;

	public ThreadCadastroUser(Requisicoes dados, ObjectOutputStream oos,
			Socket socket, ObjectInputStream ois) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
	}

	@Override
	public synchronized void run() {

		try {
			int flag = 0;
			Cadastro c = (Cadastro) dados.getCadastro();

			for (int i = 0; i < SerializadorUser.user.size(); i++) {
				if(SerializadorUser.user.get(i).getEmail().equals(c.getEmail())){
					flag++;
					break;
				}
			}

			for (int i = 0; i < SerializadorUser.userB.size(); i++) {
				if(SerializadorUser.userB.get(i).getEmail().equals(c.getEmail())){
					flag++;
					break;
				}
			}
			
			if(flag == 0){

			SerializadorUser.addUser(c, dados.getDominio());
			SerializadorUser.salvarUser(dados.getDominio());
			oos.writeObject("Ok");
			oos.close();
			ois.close();
			socket.close();
			
			}else{
				
				oos.writeObject("Fail");
				oos.close();
				ois.close();
				socket.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
