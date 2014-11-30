package Serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Savepoint;
import java.util.ArrayList;

import mensagem.Mensagem;

public class Serializador {
	
	public static ArrayList<Mensagem> email = new ArrayList<Mensagem>();
	public static ArrayList<Mensagem> emailB = new ArrayList<Mensagem>();
	
	private static String dominio;
	
	public static void salvarEmail(String domin) {
		
		FileOutputStream arquivo;
		ObjectOutputStream output;
		String nomeArquivo;
		
		if (domin.equals("apocalipse"))
		{
			dominio = "apocalipse"; nomeArquivo = "cadastroEmail.bin";
		}
		else
		{
			dominio = "ikinho"; nomeArquivo = "cadastroEmailB.bin";
		}
		
		File file = new File(nomeArquivo);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			arquivo = new FileOutputStream(nomeArquivo);
			output = new ObjectOutputStream(arquivo);
			
			if (domin.equals("apocalipse"))
				output.writeObject(email);
			else
				output.writeObject(emailB);

			output.close();
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Mensagem> carregaEmails(String domin) {

		FileInputStream arquivoLeitura;
		ObjectInputStream output;
		
		String nomeArquivo;
		
		if (domin.equals("apocalipse"))
			nomeArquivo = "cadastroEmail.bin";
		else
			nomeArquivo = "cadastroEmailB.bin";
		
		File arquivo = new File(nomeArquivo);

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
				if (domin.equals("apocalipse"))
					return email;
				else
					return emailB;
			}
			else
			{
				arquivoLeitura = new FileInputStream(nomeArquivo);
				output = new ObjectInputStream(arquivoLeitura);

				if (domin.equals("apocalipse"))
					return email = (ArrayList<Mensagem>) output.readObject();
				else
					return emailB = (ArrayList<Mensagem>) output.readObject();
			}


		} catch (Exception e) {
			e.getMessage();
		}
		return email;
	}

	public static void addEmail(Mensagem mensagem, String domin) 
	{	
		if (domin.equals("apocalipse"))
			email.add(mensagem);
		else
			emailB.add(mensagem);
	}
	
	public static void excluirTodasMensagens(){
		while(!email.isEmpty()){  
		    System.out.println(email.remove(0));
		}
		salvarEmail(dominio);
	}
	
	public static void listaEmail(){
		for (int i = 0; i < email.size(); i++) { 
			System.out.println(email.get(i).getRemetente()+"\n");
		}
	}

}
