package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Cliente {

	public Cliente() {

	}

	public void cadastrarEmail(String remetente, String destinatario,
			String corpo, String titulo) throws UnknownHostException,
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
		new Thread(envia).start();
		
		// RESPOSTA DO SERVIDOR
		ois = new ObjectInputStream(socket.getInputStream());
		String x = (String) ois.readObject();
		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();

		Thread.sleep(100);
	}

	public ArrayList<Mensagem> retornarEmails(String email)
			throws UnknownHostException, IOException, ClassNotFoundException,
			InterruptedException {
		
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		socket = new Socket(host.getHostName(), 9876);
		oos = new ObjectOutputStream(socket.getOutputStream());
		
		ClientPedeEmails pede = new ClientPedeEmails(oos, email);
		new Thread(pede).start();

		// RESPOSTA DO SERVIDOR É O ARRAY LIST COM OS EMAIL ESPECIFICOS DO USUARIO LOGADO
		ois = new ObjectInputStream(socket.getInputStream());
		
		//ClientLerEmails ler = new ClientLerEmails(ois);
		
		ArrayList<Mensagem> retorno = (ArrayList<Mensagem>) ois.readObject();
		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();
		
		return retorno;

	}
	
	public Mensagem retornarEmail(String email)
			throws UnknownHostException, IOException, ClassNotFoundException,
			InterruptedException {
		
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		socket = new Socket(host.getHostName(), 9876);
		oos = new ObjectOutputStream(socket.getOutputStream());
		
		ClientRecebMsg pede = new ClientRecebMsg(oos, email);
		new Thread(pede).start();

		// RESPOSTA DO SERVIDOR É O ARRAY LIST COM OS EMAIL ESPECIFICOS DO USUARIO LOGADO
		ois = new ObjectInputStream(socket.getInputStream());
		
		//ClientLerEmails ler = new ClientLerEmails(ois);
		
		Mensagem retorno = (Mensagem) ois.readObject();

		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();
		
		return retorno;

	}

}
