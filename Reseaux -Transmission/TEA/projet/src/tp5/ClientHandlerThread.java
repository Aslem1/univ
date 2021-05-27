package tp5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandlerThread extends Thread {
	private List<Socket> sockets;
	private ServerSocket socketServeur;
	
	public ClientHandlerThread(ServerSocket socketServeur) {
		super();
		this.sockets = new ArrayList<Socket>();
		this.socketServeur = socketServeur;
	}


	public void run() {
		try {
			while (true) {
				Socket socketClient = socketServeur.accept();
				System.out.println("Connexion avec : "+socketClient.getInetAddress());
				sockets.add(socketClient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Socket> getSockets() {
		return sockets;
	}


	public void setSockets(List<Socket> sockets) {
		this.sockets = sockets;
	}


	public ServerSocket getSocketServeur() {
		return socketServeur;
	}


	public void setSocketServeur(ServerSocket socketServeur) {
		this.socketServeur = socketServeur;
	}
	
}
