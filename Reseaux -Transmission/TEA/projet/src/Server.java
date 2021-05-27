import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
        // Le serveur écoute le port 5056
        ServerSocket ss = new ServerSocket(5056);
          
        // running infinite loop for getting client request
        while (true) {
            Socket s = null;
              
            try {
                // socket object to receive incoming client requests
                s = ss.accept();
                  
                System.out.println("Un nouveau client s'est connecté : " + s);
                  
                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                  
                System.out.println("Attribution d'un nouveau thread pour ce client");
  
                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);
  
                // Invoking the start() method
                t.start();
                  
            }
            catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}
  
// ClientHandler class
class ClientHandler extends Thread {
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
      
  
    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
  
    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) 
        {
            try {
  
                // Ask user what he wants
                dos.writeUTF("Que désirez vous ? [Date | Heure] :\n"+
                            "Ecrivez Fin pour terminer cette connection");
                  
                // receive the answer from client
                received = dis.readUTF();
                  
                if(received.equals("Fin")) { 
                    System.out.println("Client " + this.s + " Fermeture...");
                    System.out.println("Fermeture de la connection.");
                    this.s.close();
                    System.out.println("Connection fermée");
                    break;
                }
                  
                // creating Date object
                Date date = new Date();
                  
                // write on output stream based on the
                // answer from the client
                switch (received) {
                  
                    case "Date" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;
                          
                    case "Time" :
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn);
                        break;
                          
                    default:
                        dos.writeUTF("Entrée non valide");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
          
        try {
            // closing resources
            this.dis.close();
            this.dos.close();
              
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
