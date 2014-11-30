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

public class ServidorY {
	private ServerSocket server;
	private int port = 12345;
	private boolean status = true;

	public ServidorY() throws IOException, ClassNotFoundException {
		server = new ServerSocket(port);
		while (status) {
			
			servidorfunfando();
			// if(message.equalsIgnoreCase("exit")) break;
		}
		// System.out.println("Shutting down Socket server!!");
		// server.close();
	}
	
	public void servidorfunfando() throws IOException, ClassNotFoundException{
		
		System.out.println("Aguardando cliente");
		Socket socket = server.accept();
		ObjectInputStream ois = new ObjectInputStream(
				socket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());
		Requisicoes dados = (Requisicoes) ois.readObject();
		
		if (dados.getRequisicao().equals("carregaUsers")) {

			ThreadCarregaUsers  carregaEmails = new ThreadCarregaUsers(dados, oos, socket, ois, dados.getDominio());
			new Thread(carregaEmails).start();
			
		}
		
		if (dados.getRequisicao().equals("enviar")) {

			ThreadEnviar  enviar = new ThreadEnviar(dados, oos, socket, ois);
			new Thread(enviar).start();
			
		}
		
		if (dados.getRequisicao().equals("enviarServer")) {

			ThreadEnviarServer  enviarServer = new ThreadEnviarServer(dados, oos, socket, ois);
			new Thread(enviarServer).start();
			
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
			
		}
	}

	

	public void setStatus(boolean s) {
		status = s;
	}
}
