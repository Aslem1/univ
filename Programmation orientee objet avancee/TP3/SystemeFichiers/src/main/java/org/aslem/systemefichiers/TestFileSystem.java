package org.aslem.systemefichiers;

public class TestFileSystem {
    public static void main(String[] args) {
        Directory dirA = new Directory("A");
        Directory dirB = new Directory("B");
        FileSystem fs = new FileSystem();
        fs.getRoot().addNode(dirA);
        File f1 = new File("f1",120);
        File f2 = new File("f2", 340);
        dirA.addNode(dirB);
        dirB.addNode(f2);
        dirA.addNode(f1);
        if (fs.getSize() != 460) {
            throw new Error("Calcul taille repertoire incorrect");
        }
        if (f1.getParent() != dirA || f2.getParent() != dirB || dirB.getParent() != dirA) {
            throw new Error("Mauvaise gestion du lien parent");
        }
        dirA.explore();
        }
}