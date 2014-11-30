package Serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import CadastroUser.Cadastro;

;

public class SerializadorUser {

	public static ArrayList<Cadastro> user = new ArrayList<Cadastro>();
	public static ArrayList<Cadastro> userB = new ArrayList<Cadastro>();

	public static void salvarUser(String domin) {

		FileOutputStream arquivo;
		ObjectOutputStream output;
		String nomeArquivo;

		if (domin.equals("apocalipse"))
			nomeArquivo = "usuariosCadastrados.bin";
		else
			nomeArquivo = "usuariosCadastradosB.bin";

		File file = new File(nomeArquivo);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			arquivo = new FileOutputStream(nomeArquivo);
			output = new ObjectOutputStream(arquivo);

			if (domin.equals("apocalipse"))
				output.writeObject(user);
			else
				output.writeObject(userB);

			output.close();
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Cadastro> carregaUser(String domin) {

		FileInputStream arquivoLeitura;
		ObjectInputStream output;
		
		String nomeArquivo;

		if (domin.equals("apocalipse"))
			nomeArquivo = "usuariosCadastrados.bin";
		else
			nomeArquivo = "usuariosCadastradosB.bin";
		
		File arquivo = new File(nomeArquivo);

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
				
				if (domin.equals("apocalipse"))
					return user;
				else
					return userB;
			}
			else
			{
				
				arquivoLeitura = new FileInputStream(nomeArquivo);
				
				output = new ObjectInputStream(arquivoLeitura);
				
				if (domin.equals("apocalipse"))
				{
					user = (ArrayList<Cadastro>) output.readObject();
					return user;
				}
				else
					userB = (ArrayList<Cadastro>) output.readObject();
					return userB;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return user;
	}

	public static void addUser(Cadastro cadastro, String domin) {
		if (domin.equals("apocalipse"))
			user.add(cadastro);
		else
			userB.add(cadastro);
	}
}
