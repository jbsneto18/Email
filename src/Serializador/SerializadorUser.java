package Serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import CadastroUser.Cadastro;;

public class SerializadorUser {
	static ArrayList<Cadastro> user = new ArrayList<Cadastro>();

	public static void salvarUser() {

		FileOutputStream arquivo;
		ObjectOutputStream output;

		File file = new File("usuariosCadastrados.bin");

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			arquivo = new FileOutputStream("usuariosCadastrados.bin");
			output = new ObjectOutputStream(arquivo);

			output.writeObject(user);

			output.close();
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Cadastro> carregaUser() {

		FileInputStream arquivoLeitura;
		ObjectInputStream output;

		File arquivo = new File("usuariosCadastrados.bin");

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
				return user;
			}

			arquivoLeitura = new FileInputStream("usuariosCadastrados.bin");
			output = new ObjectInputStream(arquivoLeitura);

			user = (ArrayList<Cadastro>) output.readObject();
		} catch (Exception e) {
			e.getMessage();
		}
		return user;
	}

	public static void addUser(Cadastro cadastro) {
		user.add(cadastro);
	}
	
	public static void listaCadastro(){
		for (int i = 0; i < user.size(); i++) { 
			System.out.println(user.get(i).getNome()+"\n");
		}
	}

}
