package testheritagearraylist;

import java.util.ArrayList;


public class ArrayListEtud extends ArrayList <Personne> {

    public ArrayListEtud() {
            super();    // lance le constructeur de la super classe
    }

    @Override
    public boolean add( Personne p ) {
            this.add(0, p);     // on appelle de add avec 2 parametres du Arraylist non redefini
            return true;
    }
    
    @Override
    public Personne get( int i) {
        return super.get(i);  // on appelle le get du ArrayList
    }
    
    @Override
    public peuplier get (int taille) {
        return super.get(taille);
    }
    
    public pin get (int age) {
        return super.get(age);
    }
    
    public rosier() {
        return super.get(rosier);
    }

}


