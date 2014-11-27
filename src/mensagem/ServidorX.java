package mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import mensagem.Mensagem;
import Serializador.Serializador;

public class ServidorX {
	private ServerSocket server;
    private int port = 9876;
    private boolean status = true; 
     
    public ServidorX() throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        while(status){
            System.out.println("Aguardando cliente");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Mensagem message = (Mensagem) ois.readObject();
            Serializador.addEmail(message);
            
            System.out.println("Mensagem recebida, remetente: "+message.getRemetente());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Ok");
            ois.close();
            oos.close();
            socket.close();
            //if(message.equalsIgnoreCase("exit")) break;
        }
        //System.out.println("Shutting down Socket server!!");
        //server.close();
   }
    public void setStatus(boolean s){
    	status = s;    	
    }
}
