package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import CadastroUser.Cadastro;

public class Cliente {
	
	private String dominio;
	private int port;
	
	public Cliente() {

	}

	public void cadastrarEmail(String remetente, String destinatario,
			String corpo, String titulo, String domin)
			throws UnknownHostException, IOException, ClassNotFoundException,
			InterruptedException {
		
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		this.dominio = domin;
		
		//Se o dominio for apocalipse, as requisições serão direcionadas para a porta do servidorX, 
		//Caso seja ikinho, será direcionada para porta do servidorY
		
		if (dominio.equals("apocalipse"))
			this.port = 9876;
		else
			this.port = 12345;
		
		Mensagem m = new Mensagem();
		m.setCorpo(corpo);
		m.setDestinatario(destinatario);
		m.setRemetente(remetente);
		m.setTitulo(titulo);

		socket = new Socket(host.getHostName(), port);
		oos = new ObjectOutputStream(socket.getOutputStream());
		System.out.println("Sending request to Socket Server");

		ClientEnviaMsg envia = new ClientEnviaMsg(oos, m, dominio);
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

	public ArrayList<Mensagem> retornarEmails(String email, String domin)
			throws UnknownHostException, IOException, ClassNotFoundException,
			InterruptedException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		String dominio = domin;
		
		if (dominio.equals("apocalipse"))
			this.port = 9876;
		else
			this.port = 12345;
		
		socket = new Socket(host.getHostName(), port);
		oos = new ObjectOutputStream(socket.getOutputStream());

		ClientPedeEmails pede = new ClientPedeEmails(oos, email, dominio);
		new Thread(pede).start();

		// RESPOSTA DO SERVIDOR É O ARRAY LIST COM OS EMAIL ESPECIFICOS DO
		// USUARIO LOGADO
		ois = new ObjectInputStream(socket.getInputStream());

		// ClientLerEmails ler = new ClientLerEmails(ois);

		ArrayList<Mensagem> retorno = (ArrayList<Mensagem>) ois.readObject();
		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();

		return retorno;

	}

	public Mensagem retornarEmail(String email, String domin) throws UnknownHostException,
			IOException, ClassNotFoundException, InterruptedException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		this.dominio = domin;
		
		if (dominio.equals("apocalipse"))
			this.port = 9876;
		else
			this.port = 12345;
		
		socket = new Socket(host.getHostName(), port);
		oos = new ObjectOutputStream(socket.getOutputStream());

		ClientRecebMsg pede = new ClientRecebMsg(oos, email, dominio);
		new Thread(pede).start();

		// RESPOSTA DO SERVIDOR É O ARRAY LIST COM OS EMAIL ESPECIFICOS DO
		// USUARIO LOGADO
		ois = new ObjectInputStream(socket.getInputStream());

		// ClientLerEmails ler = new ClientLerEmails(ois);

		Mensagem retorno = (Mensagem) ois.readObject();

		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();

		return retorno;

	}

	public String cadastrarUsuario(Cadastro user, String domin) throws UnknownHostException,
			IOException, ClassNotFoundException, InterruptedException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		this.dominio = domin;
		
		if (dominio.equals("apocalipse"))
			this.port = 9876;
		else
			this.port = 12345;
		
		socket = new Socket(host.getHostName(), port);
		oos = new ObjectOutputStream(socket.getOutputStream());

		Requisicoes r = new Requisicoes("cadastroUser", null, null, user, dominio);
		oos.writeObject(r);

		// RESPOSTA DO SERVIDOR É O ARRAY LIST COM OS EMAIL ESPECIFICOS DO
		// USUARIO LOGADO
		ois = new ObjectInputStream(socket.getInputStream());

		// ClientLerEmails ler = new ClientLerEmails(ois);

		String retorno = (String) ois.readObject();

		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();

		return retorno;

	}

	public String excluirUsuario(String email, String domin) throws UnknownHostException,
			IOException, ClassNotFoundException, InterruptedException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		this.dominio = domin;
		
		if (dominio.equals("apocalipse"))
			this.port = 9876;
		else
			this.port = 12345;
		
		socket = new Socket(host.getHostName(), port);
		oos = new ObjectOutputStream(socket.getOutputStream());

		Requisicoes r = new Requisicoes("excluirUser", email, null, null, dominio);
		oos.writeObject(r);

		// RESPOSTA DO SERVIDOR É O ARRAY LIST COM OS EMAIL ESPECIFICOS DO
		// USUARIO LOGADO
		ois = new ObjectInputStream(socket.getInputStream());

		// ClientLerEmails ler = new ClientLerEmails(ois);

		String retorno = (String) ois.readObject();

		// ///////////////////////////////////////////////////////////////
		ois.close();
		oos.close();
		socket.close();

		return retorno;

	}

}
