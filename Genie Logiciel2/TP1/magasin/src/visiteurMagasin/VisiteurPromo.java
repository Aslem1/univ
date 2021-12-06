package visiteurMagasin;

import magasin.Animal;
import magasin.Bricolage;
import magasin.Catalogue;
import magasin.Jardinage;


public class VisiteurPromo implements ProduitVisitor {

    @Override
    public void visit(Bricolage e) {
        double remise = e.getPrix() * 0.10;
        double prixPromo = e.getPrix() - remise;
        System.out.println("Le prix à -10% est de "+ prixPromo+" €");
    }

    @Override
    public void visit(Jardinage e) {
        double remise = e.getPrix() * 0.10;
        double prixPromo = e.getPrix() - remise;
        System.out.println("Le prix à -10% est de "+ prixPromo+" €");
    }

    @Override
    public void visit(Animal e) {
        double remise = e.getPrix() * 0.10;
        double prixPromo = e.getPrix() - remise;
        System.out.println("Le prix à -10% est de "+ prixPromo+" €");
    }

    @Override
    public void visit(Catalogue e) {
        for(int i = 0; i < e.getProduits().size();i++){
            double remise = e.getProduits().get(i).getPrix()*0.10;
            double prixPromo = e.getProduits().get(i).getPrix() - remise;
            System.out.println("Le prix à -10% est des produits de ce catalogue sont à "+ prixPromo+" €");
        }
    }
    
}
