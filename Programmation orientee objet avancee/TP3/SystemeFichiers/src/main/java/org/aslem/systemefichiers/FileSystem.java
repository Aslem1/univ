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
        this.racine = new Directory(""); // Creation automatique lors de l'instanciation de FileSystem
    }
    
    public int getSize() {
        return this.racine.getSize();
    }
}
