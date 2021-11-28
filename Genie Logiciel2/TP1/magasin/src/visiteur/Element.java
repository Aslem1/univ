package visiteur;

public interface Element {
    public void accept(VisiteurPromo v);
    public void accept(VisiteurStock v);
}
