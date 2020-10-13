
package testheritagearraylist;


public class TestHeritageArrayList {

    
    public static void main(String[] args) {
        ArrayListEtud t = new ArrayListEtud();
        t.add( new Personne("toto"));
        t.add( new Personne("titi"));
        t.add( new Personne("tutu"));
        
        System.out.println ( t.get(0).getNom());  // sur un arraylist normal c'est "toto" mais là....
    }
    
}
