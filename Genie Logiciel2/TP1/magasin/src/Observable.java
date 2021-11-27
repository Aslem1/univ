import magasin.Produit;
import visiteur.visiteurPromo;
import visiteur.visiteurStock;

public class Observable extends Produit {
    public boolean addObserver() {
        return false;
    }
    
    public boolean removeObserver() {
        return false;
    }
    
    public boolean returnObserver() {
        return false;
    }

    @Override
    public void accept(visiteurPromo v) {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    @Override
    public void accept(visiteurStock v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
