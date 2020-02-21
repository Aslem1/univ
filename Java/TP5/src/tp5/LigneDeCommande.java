
package tp5;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;

/**
 * @author P. Rodriguez
 */
public class LigneDeCommande {
// ATTRIBUTS
	private int numero ;
	private int numCommande ;
	private String article ;
	private int quantite ;
	private double prixUnitaire ;
	
	// Variable de classe : donnée partagée par toutes les LigneDeCommande
        // pour numéroter automatiquement les lignes de commande)
	private static int nbLignesCommande = 0 ;
	
// CONSTRUCTEURS
        /**
         * Sans paramètre, crée une ligne de commande "vide" 
         */
	LigneDeCommande()
	{
		nbLignesCommande++ ;
		this.numero = nbLignesCommande ;
	}
	
	/**
         * 
         * @param leNumCommande
         * @param lArticle
         * @param laQuantite
         * @param lePrixUnitaire  : Prix unitaire de l'article commandé
         */
        LigneDeCommande(int leNumCommande, String lArticle, int laQuantite, double lePrixUnitaire)
	{
                this() ;// Fait appel au constructeur sans paramètre défini précédemment
		this.numCommande = leNumCommande ;
		this.article = lArticle ;
		this.quantite = laQuantite ;
		this.prixUnitaire = lePrixUnitaire ;
	}
	
// METHODES	
    // Getters
	public int getNumero(){return this.numero ;}
	public int getNumCommande(){return this.numCommande ;}
	public String getArticle(){return this.article ;}
	public int getQuantite(){return this.quantite ;}
	public double getPrixUnitaire(){return this.prixUnitaire ;}
	
	public double getPrix(){return this.quantite*this.prixUnitaire ;}
	
    // Setters
	public void setNumCommande(int leNumCommande){ this.numCommande = leNumCommande ;}
	public void setArticle(String larticle){ this.article = larticle ;}
	public void setQuantite(int laQte){ this.quantite = laQte ;}
	public void setPrixUnitaire(double lePU){ this.prixUnitaire = lePU ;}
	
    // Préparation à l'affichage
        @Override
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("##.00€ ") ;
		return "Ligne n°" + this.numero + "\tCommande n°" + this.numCommande + "\t" + this.quantite +" x "+ this.article + "\tP.U : " + df.format(this.prixUnitaire)  ;
	}
	
    // Lecture dans un fichier
	public boolean lireDansFichier(FileReader fic) throws IOException
	{
	 	String buffer;	
		StreamTokenizer entree = new StreamTokenizer(fic);
		entree.nextToken() ;
		if (entree.ttype ==  StreamTokenizer.TT_EOF) return false ;
		
		this.numero=(int)entree.nval ;
		
		entree.nextToken() ;
		this.numCommande=(int)entree.nval ;
		
		entree.nextToken() ;
		this.article=entree.sval ;
		
		entree.nextToken() ;
		this.quantite=(int)entree.nval ;
		
		entree.nextToken() ;
		this.prixUnitaire=(double)entree.nval ;
		
		return true ;
	}

    
}
