package visiteur;

import magasin.Animal;
import magasin.Bricolage;
import magasin.Catalogue;
import magasin.Jardinage;

public class VisiteurStock implements ProduitVisitor{

    @Override
    public void visit(Bricolage e) {
        double stockGlobal = e.getDispo()* e.getPrix();
        System.out.println("Le stock global de cet article de bricolage est de "+stockGlobal);
    }

    @Override
    public void visit(Jardinage e) {
        double stockGlobal = e.getDispo()*e.getPrix();
        System.out.println("Le stock global de cet article de jardinage est de "+stockGlobal);
    }

    @Override
    public void visit(Animal e) {
        double stockGlobal = e.getDispo()*e.getPrix();
        System.out.println("Le stock global de cet article d'animalerie est de "+stockGlobal);
    }

    @Override
    public void visit(Catalogue e) {
        for(int i = 0; i < e.getProduits().size();i++){
            double stockGlobal = e.getProduits().get(i).getDispo()* e.getProduits().get(i).getPrix();
            System.out.println("Le stock global des produits de ce catalogue sont de " + stockGlobal);
        }
    }
    
}
