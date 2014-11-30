package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import mensagem.Mensagem;
import CadastroUser.Cadastro;
import Serializador.Serializador;
import Serializador.SerializadorUser;

public class ServidorX {
	private ServerSocket server;
	private int port = 9876;
	private boolean status = true;

	public ServidorX() throws IOException, ClassNotFoundException {
		server = new ServerSocket(port);
		while (status) {
			
			servidorfunfando();
			// if(message.equalsIgnoreCase("exit")) break;
		}
		// System.out.println("Shutting down Socket server!!");
		// server.close();
	}
	
	public synchronized void servidorfunfando() throws IOException, ClassNotFoundException{
		
		System.out.println("Aguardando cliente");
		Socket socket = server.accept();
		ObjectInputStream ois = new ObjectInputStream(
				socket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());
		Requisicoes dados = (Requisicoes) ois.readObject();

		if (dados.getRequisicao().equals("enviar")) {

			ThreadEnviar  enviar = new ThreadEnviar(dados, oos, socket, ois);
			new Thread(enviar).start();
			
		}

		if (dados.getRequisicao().equals("lerMsgs")) {// Nesta String eu
														// estou recebendo o
														// nome do usuario
														// para consultar e
														// enviar

			ThreadLerMsgs lermsgs = new ThreadLerMsgs(dados, oos, socket, ois);
			new Thread(lermsgs).start();
			
		}

		if (dados.getRequisicao().equals("lerMsg")) {// Nesta String eu
														// estou recebendo o
														// nome do usuario
														// para consultar e
														// enviar
			ThreadLerMsg lermsg = new ThreadLerMsg(dados, oos, socket, ois);
			new Thread(lermsg).start();
			
		}

		 if (dados.getRequisicao().equals("cadastroUser")) {

			ThreadCadastroUser novo = new ThreadCadastroUser(dados, oos, socket, ois);
			new Thread(novo).start();
			

		}

		if (dados.getRequisicao().equals("excluirUser")) {

			ThreadExcluirUser excluir = new ThreadExcluirUser(dados, oos, socket, ois);
			new Thread(excluir).start();
			socket.close();
			
		}
	}

	

	public void setStatus(boolean s) {
		status = s;
	}
}
