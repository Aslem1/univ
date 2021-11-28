package magasin;
import commun.Observer;
import java.util.ArrayList;
import visiteur.Element;
import visiteur.VisiteurPromo;
import visiteur.VisiteurStock;

public class Catalogue implements Element, Observer{
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
        produit.addObserver(this); //Ajoute le catalogue en tant qu'Observer du produit
        //l'ArrayList produits va ajouter l'objet de type Produit
        this.produits.add(produit);
    }
    //Méthode toString()

    @Override
    public String toString() {
        return "Catalogue{" + "produits=" + produits + '}';
    }

    @Override
    public void accept(VisiteurPromo v) {
        v.visit(this);
    }

    @Override
    public void accept(VisiteurStock v) {
        v.visit(this);
    } 

    @Override
    public void update() {
        // Do something ...
    }
}