package commun;

import java.util.ArrayList;
import java.util.List;
import magasin.Produit;
import visiteur.VisiteurPromo;
import visiteur.VisiteurStock;

public class Observable {
    
    List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }
    
    public void addObserver(Observer observerAdd) {
        observers.add(observerAdd);
    }
    
    public void removeObserver(Observer observerRem) {
        observers.remove(observerRem);
    }
    
    public void notifyObserver() {
        for (Observer obs: observers) { //for each
            obs.update();
        }
    }
}
