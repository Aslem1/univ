package magasin;
import java.util.ArrayList;
import visiteur.Element;
import visiteur.visiteurPromo;
import visiteur.visiteurStock;

public class Catalogue implements Element{
    //On crée une ArrayList privé finale qui représente le lien de composition fort entre Produit et Catalogue
    //Il n'y a pas de produit sans catalogue
    private final ArrayList<Produit> produits = new ArrayList();

    public Catalogue() {
        
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    
    //Dans la fonction produit on place en paramètre un produit de type Produit
    public void addProduit(Produit produit){
        //l'ArrayList produits va ajouter l'objet de type Produit
        this.produits.add(produit);
    }
    //Méthode toString()

    @Override
    public String toString() {
        return "Catalogue{" + "produits=" + produits + '}';
    }

    @Override
    public void accept(visiteurPromo v) {
        v.visit(this);
    }

    @Override
    public void accept(visiteurStock v) {
        v.visit(this);
    } 
}