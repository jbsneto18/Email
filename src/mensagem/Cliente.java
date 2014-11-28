package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public Cliente(String remetente, String destinatario, String corpo, String titulo) throws UnknownHostException,
			IOException, ClassNotFoundException, InterruptedException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		Mensagem m = new Mensagem();
		m.setCorpo(corpo);
		m.setDestinatario(destinatario);
		m.setRemetente(remetente);
		m.setTitulo(titulo);

		socket = new Socket(host.getHostName(), 9876);
		oos = new ObjectOutputStream(socket.getOutputStream());
		System.out.println("Sending request to Socket Server");
		
		ClientEnviaMsg envia = new ClientEnviaMsg(oos, m);
		new Thread(envia).start();;
		
		ois = new ObjectInputStream(socket.getInputStream());
		ClientRecebMsg recebe =  new ClientRecebMsg(ois);
		new Thread(recebe).start();

		socket.close();

		Thread.sleep(100);

	}
}
