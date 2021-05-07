package org.aslem.systemefichiers;

import java.util.ArrayList;

abstract class Node {

    private String name;

    public Node(String nom) {
        this.name = nom;
    }

    public String getName() {
        return this.name;
    }

    public void explore() {
        System.out.println(this.getName());
        if (this instanceof Directory) { // Vérification que l'objet en cours est une instance de Directory
            Directory rep = (Directory) this;
            ArrayList<Node> content = rep.getChildren();
            for (Node n : content) {
                n.explore();
            }
        }
    }
}
