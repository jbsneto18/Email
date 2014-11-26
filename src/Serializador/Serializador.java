package Serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mensagem.Mensagem;


public class Serializador {
	static ArrayList <Mensagem> email = new ArrayList<Mensagem> ();
    
    public static void salvarEmail (ArrayList<Mensagem> mensagem){
        
        FileOutputStream arquivo;
        ObjectOutputStream output;
        
        File file = new File ("cadastroEmail.bin");
        
        
        try {
             if (!file.exists()){
               file.createNewFile();
             }
             
             arquivo = new FileOutputStream("cadastroEmail.bin");
             output = new ObjectOutputStream(arquivo);
             
             output.writeObject(mensagem);
             
             output.close();
             arquivo.close();            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList <Mensagem> carregaEmails(){
        
        FileInputStream arquivoLeitura;
        ObjectInputStream output;
        
        File arquivo = new File ("cadastroEmail.bin");
        
        try {
            if (!arquivo.exists()){
                arquivo.createNewFile();
                return email;
            }
            
            arquivoLeitura = new FileInputStream("cadastroEmail.bin");
            output = new ObjectInputStream(arquivoLeitura);
            
            email = (ArrayList<Mensagem>) output.readObject();
        }
        catch(Exception e){
            e.getMessage();
        }
        return email;
    }

}
