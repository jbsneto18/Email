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

public class ThreadLerMsg implements Runnable {

	private Requisicoes dados;
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;

	public ThreadLerMsg(Requisicoes dados, ObjectOutputStream oos,
			Socket socket, ObjectInputStream ois) {
		this.dados = dados;
		this.oos = oos;
		this.socket = socket;
		this.ois = ois;
	}

	@Override
	public void run() {
		
		int flag = 0;
		int indice = 0;
		String emailUsuario = (String) dados.getEmail();
		ArrayList<Mensagem> m = new ArrayList<Mensagem>();
		
		if (dados.getDominio().equals("apocalipse"))
		{
			
			for (int i = 0; i < Serializador.email.size(); i++) 
			{
				if (Serializador.email.get(i).getDestinatario()
						.equals(emailUsuario)) {
					m.add(Serializador.email.get(i));
					flag = 1;
					indice = i;
				}
			}
			
			if (flag == 1) 
			{
				Serializador.email.remove(indice);
				Serializador.salvarEmail(dados.getDominio());
			}
		}
		else
		{
			for (int i = 0; i < Serializador.emailB.size(); i++) 
			{
				if (Serializador.emailB.get(i).getDestinatario()
						.equals(emailUsuario)) {
					m.add(Serializador.emailB.get(i));
					flag = 1;
					indice = i;
				}
			}
			
			if (flag == 1) 
			{
				Serializador.emailB.remove(indice);
				Serializador.salvarEmail(dados.getDominio());
			}
		}

		try {
			if (m.size() - 1 == -1) {
				oos.writeObject(null);
				ois.close();
				oos.close();
				socket.close();
				Serializador.salvarEmail(dados.getDominio());
			} else {
				oos.writeObject(m.get(m.size() - 1));
				ois.close();
				oos.close();
				socket.close();
				Serializador.salvarEmail(dados.getDominio());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
