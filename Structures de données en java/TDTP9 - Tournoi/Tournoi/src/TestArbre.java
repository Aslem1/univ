public class TestArbre {
    public static void main( String [] arg){
        Arbre a1 = new ArbreCons("UN");     // Feuille
        Arbre a2 = new ArbreCons("DEUX");   // Feuille
        
        
        Arbre a3 = new ArbreCons( "TROIS", a1, a2);
        Arbre a4 = new ArbreCons( "QUATRE", a3, new ArbreCons("CINQ"));   
        
    }
}
