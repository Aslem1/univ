import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter; // Window Event
import java.awt.event.WindowEvent; // Window Event
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Alain BOUJU
 *
 */
public class TPClient extends Frame {

	byte[] etat = new byte[2 * 10 * 10];
	int team;
	int x;
	int y;
	int port = 9632;
	Socket socket = null;
	InputStream in;
	PrintStream out;
	TPPanel tpPanel;
	TPCanvas tpCanvas;
	Timer timer;

	/** Constructeur */
	public TPClient() {
		setLayout(new BorderLayout());
		tpPanel = new TPPanel(this);
		add("North", tpPanel);
		tpCanvas = new TPCanvas(this.etat);
		add("Center", tpCanvas);

		timer = new Timer();
		timer.schedule(new MyTimerTask(), 500, 500);
	}

	/** Action vers droit */
	public synchronized void droit() {
		System.out.println("Droit");
		out.println("droit");
//	try {
//	    tpCanvas.repaint();
//	} catch (IOException ex) {
//	    ex.printStackTrace();
//	}

	}

	/** Action vers gauche */
	public synchronized void gauche() {
		System.out.println("Gauche");
		out.println("gauche");
//	try {
//	    tpCanvas.repaint();
//	} catch (IOException ex) {
//	    ex.printStackTrace();
//	}

	}

	/** Action vers gauche */
	public synchronized void haut() {
		System.out.println("Haut");
		out.println("haut");
		tpCanvas.repaint();

	}

	/** Action vers bas */
	public synchronized void bas() {
		System.out.println("Bas");
		out.println("bas");
//	try {
//	    tpCanvas.repaint();
//	} catch (IOException ex) {
//	    ex.printStackTrace();
//	}

	}

	/** Pour rafraichir la situation */
	public synchronized void refresh() {
//	try {
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
		tpCanvas.repaint();
	}

	/** Pour recevoir l'Etat */
	public void receiveEtat() {
//	try {
//	} catch (IOException ex) {
//	    ex.printStackTrace();
//	}

	}

	/** Initialisations */
	public void minit(int number, int pteam, int px, int py) {
		// Afficher le rond initial
		// graphics = null quoi que je fasse
		// tpCanvas.drawPlayer(tpPanel.getGraphics(), px, py, 2);
		try {
			// connexion au serveur
			socket = new Socket("127.0.0.1", this.port);
			out = new PrintStream(socket.getOutputStream());
			// DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			// Si la connexion echoue, extinction
			System.exit(0);
			ex.printStackTrace();
		}

	}

	/** Initialisations */
	public void deconnexion() {
		// Afficher le rond initial
		out.println("fin");
	}

	public String etat() {
		String result = new String();
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("args :" + args.length);
		// Forcer les valeurs - ça évite d'utiliser les lignes de commandes
		// fin forcer
		if (args.length != 4) {
			System.out.println("Usage : java TPClient number color positionX positionY ");
			System.exit(0);
		}
		try {
			int number = Integer.valueOf(args[0]);
			int team = Integer.valueOf(args[1]);
			int x = Integer.valueOf(args[2]);
			int y = Integer.valueOf(args[3]);

			TPClient tPClient = new TPClient();
			tPClient.minit(number, team, x, y);

			// Pour fermeture
			tPClient.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					tPClient.deconnexion();
					System.exit(0);
				}
			});

			// Create Panel back forward

			tPClient.pack();
			tPClient.setSize(1000, 1000 + 200);
			tPClient.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Pour rafraichir */
	class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("refresh");
			refresh();
		}
	}
}
