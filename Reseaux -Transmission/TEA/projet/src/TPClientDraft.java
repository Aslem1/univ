import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter; // Window Event
import java.awt.event.WindowEvent; // Window Event

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.BufferedReader;

/**
 * @author Alain BOUJU
 *
 */
public class TPClient extends Frame {

	byte [] etat = new byte [2*10*10];
	int team;
	int x;
	int y;
	int port = 2000;
	Socket socket = null;
	InputStream in;
	DataOutputStream out;
	TPPanel tpPanel;
	TPCanvas tpCanvas;
	Timer timer;

	/** Constructeur */
	public TPClient(int number,int team, int x, int y)
	{
		setLayout(new BorderLayout());
		tpPanel = new TPPanel(this);
		add("North", tpPanel);
		tpCanvas = new TPCanvas(this.etat);
		add("Center", tpCanvas);
		
		timer = new Timer();
		timer.schedule ( new MyTimerTask (  ) , 500,500) ;

	}
	
	/** Action vers droit */
	public synchronized void droit()
	{
		System.out.println("Droit");
		try{
			
			tpCanvas.repaint();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	/** Action vers gauche */
	public synchronized void gauche()
	{
		System.out.println("Gauche");
		try{
			
			tpCanvas.repaint();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	/** Action vers gauche */
	public synchronized void haut()
	{
		System.out.println("Haut");
		try{
			
			tpCanvas.repaint();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	
	}
	/** Action vers bas */
	public synchronized void bas ()
	{
		System.out.println("Bas");
		try{
			
			tpCanvas.repaint();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	/** Pour rafraichir la situation */
	public synchronized void refresh ()
	{
		try {
		} catch (IOException e) {
			e.printStackTrace();
		}

		tpCanvas.repaint();
	}
	/** Pour recevoir l'Etat */
	public void receiveEtat()
	{
		try{

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	/** Initialisations */
	public void minit(int number, int pteam, int px, int py)
	{
		try{
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	public String etat()
	{
		String result = new String();
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("args :"+args.length);
		if (args.length != 4) {
			System.out.println("Usage : java TPClient number color positionX positionY ");
			System.exit(0);
		}
		try {
			TPClient tPClient = new TPClient(number,team,x,y);
			tPClient.minit(number, team, x, y);
			

			// Pour fermeture
			tPClient.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

			// Create Panel back forward
			
			tPClient.pack();
			tPClient.setSize(1000, 1000+200);
			tPClient.setVisible(true);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/** Pour rafraichir */
	class MyTimerTask extends TimerTask{
		
		public void run ()
		{
			System.out.println("refresh");
          		refresh();
		}
	}
	
}
