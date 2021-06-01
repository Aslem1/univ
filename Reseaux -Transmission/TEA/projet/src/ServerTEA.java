
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTEA {

	final static int port = 9632;
	final static List<Socket> sockets = new ArrayList<Socket>();

	public static void main(String[] args) {
		try {
			ServerSocket socketServeur = new ServerSocket(port);
			System.out.println("Lancement du serveur");

			// Thread pour gérer la connexion des clients
			Thread clientHandler = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// boucle infinie pour connecter un nombre indéfini de joueurs
						while (true) {
							// Attente des connexions client
							Socket socketClient = socketServeur.accept();
							System.out.println("Connexion avec : " + socketClient.getInetAddress());

							// Ajoute dans la liste pour partage des messages
							sockets.add(socketClient);

							// Création d'un thread par client pour ne pas avoir d'inter-blocage
							Thread envoi = new Thread(new Runnable() {
								// boolean pour quitter le thread à la déconnexion du client
								boolean exit = false;

								@Override
								public void run() {
									while (!exit) { // tant que le client est connecté
										String message = "";
										try {
											BufferedReader in;
											in = new BufferedReader(
													new InputStreamReader(socketClient.getInputStream()));
											message = in.readLine();

											System.out.println(message);

											// Si le client souhaite se déconnecter, il envoie le mot "fin"
											if ("fin".equals(message)) {
												// retrait du client de la liste des sockets
												sockets.remove(socketClient);
												for (Socket skt : sockets) {
													// prévenir les autres clients
													PrintStream out = new PrintStream(skt.getOutputStream());
													out.println("Un utilisateur s'est déconnecté.");
													out.close();
												}
												exit = true; // passage à true pour arréter le thread
												socketClient.close(); // fermeture du socket
											} else {
												// transmission du message aux autres clients
												for (Socket skt : sockets) {
													if (!socketClient.equals(skt)) {
														PrintStream out = new PrintStream(skt.getOutputStream());
														out.println(message);
														out.close();
													}
												}
											}
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}
							});
							envoi.start();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			clientHandler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}