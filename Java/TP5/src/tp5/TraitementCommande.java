
package tp5;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author P. Rodriguez
 */
public class TraitementCommande {

    private ArrayList<LigneDeCommande> lesLignesCommande;
    
    
    public TraitementCommande() {
       try{ 
        this.lesLignesCommande = lectureFichier("lignesDeCommande.txt") ;
       } catch(IOException e){ 
           System.out.println("ERREUR CHARGEMENT"); 
       }
    }

	
	public ArrayList<LigneDeCommande> lectureFichier(String lignesDeCommande) throws IOException
	{
		ArrayList<LigneDeCommande> resultat ;
		resultat = new ArrayList() ;
		
		FileReader fr = new FileReader(lignesDeCommande) ;
		
		LigneDeCommande li = new LigneDeCommande() ;
		while(li.lireDansFichier(fr))
		{
				resultat.add(li) ;
				li = new LigneDeCommande() ;	
		}
		return resultat ;
	}
        
        //Ex - B.2: Affichage
        public void afficher (){
            for (LigneDeCommande l: lesLignesCommande){
                System.out.println(l); //affiche lignes de commande présentes dans lesLignesCommande
            }
        } 
        
        //B.3 - Calcul du montant total des lignes de commande
        public double prixTotal (){
            double somme = 0; //declarer variables AVANT for
            for (LigneDeCommande l: lesLignesCommande){
               somme = somme + l.getPrix();
            }   
        return somme;
        }
        
        //Ex - B.4: Calcul du montant total d'une commande
        public String prixTotalDeLaCommande (int n){
            double somme = 0;
            for (LigneDeCommande l : lesLignesCommande){
                if (l.getNumCommande() == n){
                    somme = somme + l.getPrix();
                }
            }
        return "Le prix total de votre commande " + n + " est: " + somme;
        }
        
        //Ex - B.5: Affichage des données concernant une commande
        public String afficherLaCommande (int n){
            int nbelements = 0;
            double total = 0;
            for (LigneDeCommande l : lesLignesCommande){
                if (l.getNumCommande() == n){
                    System.out.println(n);
                    nbelements ++;
                    total = total + l.getPrix();
                }
            }
            return "Le montant total de cette commande est: " + total + "et le nombre total d'articles est :" + nbelements;
        }
        
        //Ex - B.6: Regroupement des lignes de commande
        public ArrayList<LigneDeCommande> lignesDeLaCommande (int n){
            ArrayList<LigneDeCommande> commande = new ArrayList();
            for (LigneDeCommande l : lesLignesCommande){
                if (l.getNumCommande() == n)
                    commande.add(l);
            }
        return commande;
        }
        
        //Ex - B.7: Suppression des lignes d'une commande
        //Eviter remove utiliser add
        public ArrayList<LigneDeCommande> lignesSansLaCommande (int n){
            ArrayList<LigneDeCommande> SansCommande = new ArrayList ();
            for (LigneDeCommande l : lesLignesCommande){
                if (l.getNumCommande()!= n)
                    SansCommande.add(l);
            }
        return SansCommande;
        }
        
        //Ex - B.8: Construction du tableau des numéros de commande
        public ArrayList<LigneDeCommande> listeNumerosCommande (){
            ArrayList<Integer> TabNumCommandes = new ArrayList();
            
        }
}
