public class Pin extends Arbre {
    int age;
    
    private Pin (int a) {
        super();
        this.age = a;
    }

    static public Pin getInstance(int a) {
        if (compteur < 4) {
            compteur++;
            return new Pin(a);
        } else {
            return null;
        }
    }
    
    public void afficher() {
        System.out.println("Pin d'age " + age);
    }
}
