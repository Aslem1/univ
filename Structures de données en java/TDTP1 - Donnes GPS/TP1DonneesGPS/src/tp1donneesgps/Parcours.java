package tp1donneesgps;

import java.util.ArrayList;
import java.io.*;


public class Parcours{
   //-STRUCTURE DE DONNEES "points"-------------------------------------------------------------------
    private String nom;
    private ArrayList <Point> points;
   
   //-CONSTRUCTEUR------------------------------------------------------------------------------------

    public Parcours(String nom) {
        this.nom = nom;
        this.points = new ArrayList();
    }

   //-METHODES---------------------------------------------------------------------------------------

    /**
     *
     * @throws IOException
     * Methode qui permet le chargement des points a partir d'un fichier DonneesGPS.csv
     */

   public void chargement()throws IOException {
   
      double lat, lon, alt, temps;
                  
      FileReader fic = new FileReader("DonneesGPS.csv");
	   StreamTokenizer entree=new StreamTokenizer(fic) ;
      
      entree.quoteChar('"');
   	entree.nextToken();
   	int i =0;
   	while (entree.ttype!=StreamTokenizer.TT_EOF)
   	{
   		lat=entree.nval ;                            // lecture 4 par 4 des donn�es lat , lon, alt et temps
         
         entree.nextToken();
         lon=entree.nval ;
   		
         entree.nextToken();
         alt=entree.nval ;
         
         entree.nextToken();
         temps=entree.nval ;
         
         Point p = new Point( lat, lon, alt, temps ); // creation du point avec les donn�es
         points.add( p );                            // ajout du point au tableau nomm� "points"
         
         entree.nextToken();                          // et on recommence...
   	}
      
      fic.close();
   }
   
   
   
   /*Méthode afficher qui affiche directement à l'écran tous les points**/
   public void afficher() {
       for (int i=0; i< this.points.size(); i++) {
           System.out.println(this.points.get(i));
       }
   }

   /*Méthode altitudeMax qui retourne l'atitude maximum atteinte sur le parcours**/
  public double altitudeMax() {
       double max = this.points.get(0).getAlt();
       for (int i=1; i < this.points.size(); i++){
          if  (max < this.points.get(i).getAlt()){
            max = this.points.get(i).getAlt();
          }
       }
      return max;
   }

   /*public double distance()
   //distance = vitesse * temps
   {
      return 0;
    }**/

   /*Méthode temps qui retourne le temps total en seconde du parcours**/
   public double temps(){
       double tempsTotal = 0;
       for (int i=0; i < points.size(); i++) {
           tempsTotal = tempsTotal + this.points.get(i).getTemps();
       }
       
       return tempsTotal;
   }

   public ArrayList<Double> afficherVitesses(){
       /* vitesse = distance/temps */
       ArrayList <Double> vitesse = new ArrayList <>();
       // Point(0) distance avec Point(1) * 3600 (pour mettre en km/h) / Point(1) temps
       System.out.println(this.points.get(0).distance(this.points.get(1))*3600/(this.points.get(1).getTemps()));
       /*
       1: Généraliser dans une boucle
       2: Stocker les valeurs dans l'ArrayList vitesse
       3: Renvoyer cet ArrayList à la place du Double evolutionVitesse
       */
      return vitesse;
      
   }
   
    //public double vitesseMoy(){
        //Retourne la vitesse moyenne sur tout le parcours
    //}

   public ArrayList <Double> split(double intervalleDist) {
       ArrayList <Double> interDist = new ArrayList <>(0);
       
       return null;
   }

   public void tracerAltitude() {
      
           
   }

   public void tracerVitesse() {
      
   }



}