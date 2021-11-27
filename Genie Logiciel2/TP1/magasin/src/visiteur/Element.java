package visiteur;

public interface Element {
    public void accept(visiteurPromo v);
    public void accept(visiteurStock v);
}
