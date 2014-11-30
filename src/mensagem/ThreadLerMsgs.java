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

public class ThreadLerMsgs implements Runnable {

	
	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;

	public ThreadLerMsgs(Requisicoes dados, ObjectOutputStream oos,
			Socket socket, ObjectInputStream ois) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
	}

	@Override
	public void run() {

		String emailUsuario = (String) dados.getEmail();
		ArrayList<Mensagem> m = new ArrayList<Mensagem>();
		
		if (dados.getDominio().equals("apocalipse"))
		{
			for (int i = 0; i < Serializador.email.size(); i++) 
			{
				if (Serializador.email.get(i).getDestinatario()
						.equals(emailUsuario)) {
					m.add(Serializador.email.get(i));
				}
			}

			for (int i = 0; i < Serializador.email.size(); i++) 
			{
				if (Serializador.email.get(i).getDestinatario()
						.equals(emailUsuario)) {
					Serializador.email.remove(i);
					i = i - 1;
					Serializador.salvarEmail("apocalipse");
					break;
					// i = 0;//poderia ser assim mas nao sei como o array
					// list reorganiza
				}
			}
		}
		else
		{
			for (int i = 0; i < Serializador.emailB.size(); i++) 
			{
				if (Serializador.emailB.get(i).getDestinatario()
						.equals(emailUsuario)) {
					m.add(Serializador.emailB.get(i));
				}
			}

			for (int i = 0; i < Serializador.emailB.size(); i++) 
			{
				if (Serializador.emailB.get(i).getDestinatario()
						.equals(emailUsuario)) {
					Serializador.emailB.remove(i);
					i = i - 1;
					Serializador.salvarEmail("ikinho");
					break;
					// i = 0;//poderia ser assim mas nao sei como o array
					// list reorganiza
				}
			}
		}

		
		try {
			oos.writeObject(m);
			ois.close();
			oos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
