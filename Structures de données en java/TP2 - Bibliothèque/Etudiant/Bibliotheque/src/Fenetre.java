import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
import java.util.logging.Level;
import java.util.logging.Logger;
   


public class Fenetre extends JFrame implements ActionListener {
        
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  
    
    private Image im;
    private UnLivre livre;
    private Bibliotheque biblio;
        

// CONSTRUCTEUR 
    
    public Fenetre(String titre, int largeur, int hauteur) {
        super(titre);
        biblio = new Bibliotheque();
        try {
            biblio.chargement("ListeLivres.txt");
        } catch (IOException e) {
            System.out.println("probleme de fichier par exception");
            System.out.println(e);
        }
        
        livre = biblio.getLivre();
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                           
        mise_en_page( largeur, hauteur );    // on place les boutons et la zone de dessin ...
        
        	
              
        repaint();        
    }
    

    public void mise_en_page(int maxX, int maxY) {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
        
        ajouteBouton("Supprimer", p1);
        ajouteBouton("Emprunter", p1);
        ajouteBouton("Rendre", p1);
   	  
  	getContentPane().add(p1,"North");  // on ajoute le panel en haut de la fenetre frame
        
        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("<<<", p2); 
        ajouteBouton(">>>", p2);                       
  	ajouteBouton("Quitter", p2);
		  
	getContentPane().add(p2,"South");  // on ajoute le panel en bas
        
        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
        getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        //--------------------------------------------------------------------

        pack();
        setVisible(true);
    }
   
    // Accesseur au zoneDessin de la fenetre
    public Graphics getzoneDessin() {
        return this.zoneDessin.getGraphics();
    }
    
    
    void quitter() {
        System.exit(0);
    }
    
    
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics(); 
        g.setColor( Color.WHITE );
        g.fillRect(0,0,this.getWidth(),this.getHeight() );
    }
    
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    } 
    
       
    public void paint(Graphics g) { // dessin de la fenetre generale
    
        this.p1.repaint();  // on redessine les boutons hauts
        this.p2.repaint();  // on redessine les boutons bas
        File input = new File(livre.getNomPhoto());
        try {
            im = ImageIO.read(input);
        } catch (IOException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
            
         g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
         effacer();
         g.drawString(livre.getTitre(), 400, 50);
         g.drawString(livre.getTexte(), 400, 70);
         g.drawString("Nombre d'exemplaires : " + livre.getNbExemplaires(), 400, 200);
         g.drawString("Nombre d'emprunts : " + livre.getNbEmprunts(), 400, 220);
         g.drawImage(im, 20, 50, rootPane);
         // c'est ici qu'il faut mettre les elements à afficher
                 
         Font StyleLesTitres = new Font("TimesRoman",Font.BOLD,20); // trois styles d'ecriture
 	 Font StyleMoyen = new Font("TimesRoman", Font.ITALIC,14);
	 Font StyleNormal = new Font("TimesRoman", Font.PLAIN,12);

	 
         
    
    }
    
    // GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declenchee si Un bouton quelconque est appuye
    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();     // on capte l'evenement : nom du bouton !

        if (c.equals("Quitter")) quitter();		

        if (c.equals(">>>")) {
            biblio.suivant();
            livre = biblio.getLivre();
        };

        if (c.equals("<<<")) { 
            biblio.precedent();
            livre = biblio.getLivre();
        };

        if (c.equals("Emprunter")) {
            biblio.emprunter();
        };

        if (c.equals("Rendre")) {  
            biblio.rendre();
        };

        if (c.equals("Supprimer")) {  
            biblio.supprimer();
        };

        repaint();	       
    } 
    
   
}

