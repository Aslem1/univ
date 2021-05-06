package org.aslem.systemefichiers;

import java.util.ArrayList;

class Directory extends Node
{

    private ArrayList<Node> children;

    public Directory(String name)
    {
        super(name);
        this.children = new ArrayList<Node>();
    }

    public void addNode(Node n)
    {
        this.children.add(n);
    }

    public ArrayList<Node> getChildren()
    {
        return this.children;
    }
}

