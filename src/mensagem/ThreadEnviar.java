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

public class ThreadEnviar implements Runnable {

	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;

	public ThreadEnviar(Requisicoes dados, ObjectOutputStream oos,
			Socket socket, ObjectInputStream ois) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
	}
	
	@Override
	public void run() {

		Mensagem message = (Mensagem) dados.getMensagem();
		Serializador.addEmail(message, dados.getDominio());
		Serializador.salvarEmail(dados.getDominio());
		
		System.out.println("Mensagem recebida!\n remetente: "
				+ message.getRemetente());
		System.out
				.println("Destinatário: " + message.getDestinatario());
		System.out.println("Titulo: " + message.getTitulo());
		System.out.println("Corpo: " + message.getCorpo());
		
		try {
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
