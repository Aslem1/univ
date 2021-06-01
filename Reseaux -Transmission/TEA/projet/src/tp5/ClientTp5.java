package tp5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTp5 {

	final static int port = 9632;
	
	public static void main(String[] args) {
		try {
			ServerSocket socketServeur = new ServerSocket(port);
			System.out.println("Lancement du serveur");
			ClientHandlerThread clientHandler = new ClientHandlerThread(socketServeur);
			
			while (true) {
				for(Socket s : clientHandler.getSockets()) {
					String message = "";
					// InputStream in = socketClient.getInputStream();
					// OutputStream out = socketClient.getOutputStream();
					
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					message = in.readLine();
					System.out.println(message);
					if ("fin".equals(message)) {
						s.close();
						clientHandler.getSockets().remove(s);
						for(Socket skt : clientHandler.getSockets()) {
							PrintStream out = new PrintStream(skt.getOutputStream());
							out.println("Un utilisateur s'est déconnecté.");
						}
					} else {
						for(Socket skt : clientHandler.getSockets()) {
							if(!s.equals(skt)) {
								PrintStream out = new PrintStream(skt.getOutputStream());
								out.println(message);
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}