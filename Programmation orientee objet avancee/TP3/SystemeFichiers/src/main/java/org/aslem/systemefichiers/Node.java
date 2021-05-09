package org.aslem.systemefichiers;

import java.util.ArrayList;

abstract class Node {

    private String name;
    private Directory parent;

    public Node(String nom) {
        this.name = nom;
    }

    public String getName() {
        return this.name;
    }

    public abstract void explore();
    
    public Directory getParent() {
        return parent;
    }
    
    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public abstract int getSize();
}
