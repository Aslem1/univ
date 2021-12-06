package visiteurMagasin;

//Correspond aux use (chaque importation des classes Bricolage, Jardinage,Cataloque et Animal du package magisin
import magasin.Bricolage;
import magasin.Jardinage;
import magasin.Catalogue;
import magasin.Animal;

public interface ProduitVisitor {
    public void visit(Bricolage e);
    public void visit(Jardinage e);
    public void visit(Animal e);
    public void visit(Catalogue e);
    
}
