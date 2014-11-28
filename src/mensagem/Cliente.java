package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public Cliente() {
		
	}
	
	public void cadastrarEmail(String remetente, String destinatario, String corpo, String titulo)throws UnknownHostException,
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
		oos.writeObject(m);
		//RESPOSTA DO SERVIDOR
		ois = new ObjectInputStream(socket.getInputStream());
		String retorno = (String) ois.readObject();
		System.out.println(retorno);
/////////////////////////////////////////////////////////////////
		ois.close();
		oos.close();

		Thread.sleep(100);
	}
	
	public void retornarEmail()throws UnknownHostException,
	IOException, ClassNotFoundException, InterruptedException{
		
		
	}
	
}
