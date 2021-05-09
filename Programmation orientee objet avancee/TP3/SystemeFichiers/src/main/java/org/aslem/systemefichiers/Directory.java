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
        n.setParent(this);
        this.children.add(n);
    }

    public ArrayList<Node> getChildren()
    {
        return this.children;
    }

    @Override
    public void explore() {
        System.out.println(this.getName());
        ArrayList<Node> content = this.getChildren();
        for (Node n : content) {
            n.explore();
        }
    }

    @Override
    public int getSize() {
        int total = 0;
        for (Node n : children) {
            total += n.getSize();
        }
        return total;
    }
}

