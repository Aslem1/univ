public class Mot {
   private String leMot;


   public Mot( String UnMot ) {
       this.leMot = UnMot;
   }

   public String getMot() {
       return this.leMot;
   }

   public String toString() {
       return " Nom :"+this.getMot();
   }

   private int nbLettre( char c, String s ) {
       return 0;
   }

   private boolean lettrePresente( char c, String s ) {
       
       return false;
   }

// mot gagnant si les lettreJoueur sont inclues dans le motDico.
// Mais il faut aussi le nombre de lettresJoueur soient en nombre suffisant pour constituer le mot
   private boolean lettresPresentes(String s) {
       return false;	
   }

   public boolean motOK( String proposition) {
       return false;
   }

   public int compareTo( Mot m) {
       return ( this.getMot().compareTo(m.getMot()) );
   }
   
   public boolean equals( Mot m ) {
       return  m.getMot().equalsIgnoreCase(this.getMot());	
   }
}