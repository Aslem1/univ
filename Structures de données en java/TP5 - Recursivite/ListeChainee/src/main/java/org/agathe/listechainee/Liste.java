package org.agathe.listechainee;

public abstract class Liste  {
    
    public abstract boolean estVide();
    public abstract String getPremier();
    public abstract Liste getReste();

    public abstract void afficher();

    //Complétez cette classe avec les nouvelles méthodes ci-dessous
    public abstract boolean trouver (String val);
    public abstract int size();
    public abstract Liste concat(Liste L1);
    public abstract Liste inverser(); //Utilisation de placerFin()
    public abstract Liste inserer (String s, int rang);
    public abstract String somme();
    public abstract Liste copie();

    public abstract Liste intersection( Liste L );
    public abstract Liste union( Liste L );
    public abstract boolean inclus( Liste L );
        
/*

    public abstract Liste placerFin( String val);
*/
    public static void main(String[] args){
        
        Liste lv1 = new ListeVide();
        Liste lv2 = new ListeVide();

        Liste lc3 = new ListeCons("c", lv1);
        Liste lc2 = new ListeCons("b", lc3);
        Liste lc1 = new ListeCons("a", lc2);

        Liste lc6 = new ListeCons("k", lv2);
        Liste lc5 = new ListeCons("2", lc6);
        Liste lc4 = new ListeCons("1", lc5);

        lc1.afficher();
        lc4.afficher();
        
        System.out.println(lc1.size());
        System.out.println(lc1.trouver("k"));
        System.out.println(lc1.concat(lc4).size());
        lc1.afficher();
        System.out.println(lc1.trouver("k"));
    }
}