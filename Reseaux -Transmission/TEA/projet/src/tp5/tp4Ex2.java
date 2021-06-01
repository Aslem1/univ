package tp5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class tp4Ex2 {
	
	final static int port = 9632;
	
	public static void main(String[] args) {
		try {
			ServerSocket socketServeur = new ServerSocket(port);
			System.out.println("Lancement du serveur");
			
			
			Socket socketClient = socketServeur.accept();
			
			System.out.println("Connexion avec : "+socketClient.getInetAddress());
			boolean endless = true;
			while (endless) {
				String message = "";
				// InputStream in = socketClient.getInputStream();
				// OutputStream out = socketClient.getOutputStream();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
				PrintStream out = new PrintStream(socketClient.getOutputStream());
				message = in.readLine();
				System.out.println(message);
				if ("fin".equals(message)) {
					endless = false;
				} else {
					Scanner sc = new Scanner(System.in);
					System.out.println("Entrez votre message : ");
					String send = sc.nextLine();
					out.println(send);
				}
			}
			socketClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}