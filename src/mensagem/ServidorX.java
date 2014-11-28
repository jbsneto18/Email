package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import mensagem.Mensagem;
import Serializador.Serializador;

public class ServidorX {
	private ServerSocket server;
	private int port = 9876;
	private boolean status = true;

	public ServidorX() throws IOException, ClassNotFoundException {
		server = new ServerSocket(port);
		while (status) {
			System.out.println("Aguardando cliente");
			Socket socket = server.accept();
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());

			Object dados = ois.readObject();

			if (dados instanceof Mensagem) {

				Mensagem message = (Mensagem) dados;
				Serializador.addEmail(message);

				System.out.println("Mensagem recebida!\n remetente: "
						+ message.getRemetente());
				System.out
						.println("Destinatário: " + message.getDestinatario());
				System.out.println("Titulo: " + message.getTitulo());
				System.out.println("Corpo: " + message.getCorpo());
				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());
				oos.writeObject("Ok");
				ois.close();
				oos.close();
				socket.close();
			}

			if (dados instanceof String) {//Nesta String eu estou recebendo o nome do usuario para consultar e enviar

				String emailUsuario = (String) dados;
				ArrayList<Mensagem> m = new ArrayList<Mensagem>();
				for(int i = 0; i < Serializador.email.size(); i++){
					if(Serializador.email.get(i).getRemetente().equals(emailUsuario)){
						m.add(Serializador.email.get(i));
					}
				}
				
				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());
				oos.writeObject(m);
				ois.close();
				oos.close();
				socket.close();
			}

			// if(message.equalsIgnoreCase("exit")) break;
		}
		// System.out.println("Shutting down Socket server!!");
		// server.close();
	}

	public void setStatus(boolean s) {
		status = s;
	}
}
