import java.util.ArrayList;

abstract class Node
{

    private String name;

    public Node(String nom)
    {
        this.name = nom;
    }

    public String getName()
    {
        return this.name;
    }

    public void explore()
    {
        System.out.println(this.getName());
        if (this.getClass() == Directory.class)
        {
            Directory rep = (Directory) this;
            ArrayList<Node> content = rep.getChildren();
            for (Node n : content)
            {
                n.explore();
            }
        }
    }
}

class File extends Node
{

    public File(String name)
    {
        super(name);
    }
}

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

public class FileSystem
{
    public static void main(String[] args)
    {
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
