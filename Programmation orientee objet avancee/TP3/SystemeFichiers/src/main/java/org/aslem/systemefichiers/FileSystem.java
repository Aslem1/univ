package org.aslem.systemefichiers;

public class FileSystem {
    //Variable "racine" de type directory
    private Directory racine;

    // Getter de racine
    public Directory getRacine() {
        return racine;
    }

    // Setter de racine
    public void setRacine(Directory racine) {
        this.racine = racine;
    }

    // Constructeur de FileSystem
    public FileSystem() {
        this.racine = new Directory(""); // Creation automatique lors de l'instanciation de FIleSystem
    }
    
    
    public static void main(String[] args) {
        Directory r1 = new Directory("A");
        Directory r2 = new Directory("B");
        File f1 = new File("f1");
        File f2 = new File("f2");
        r1.addNode(r2);
        r2.addNode(f2);
        r1.addNode(f1);
        r1.explore();
    }
}
