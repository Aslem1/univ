import java.lang.reflect.Modifier;

public class TestPersonne {

    public static void main(String[] args) {

        Class classePersonne = Personne.class;
        // Verification que la classe Personne est bien abstraite...
        if (! (Modifier.isAbstract(classePersonne.getModifiers()))) {
            throw new Error("Probleme : la classe Personne est concrete !...");
        }
        // Detection d'attributs non privés dans la classe Personne...
        int nbMethodes = classePersonne.getFields().length;
        if (nbMethodes != 0) {
            throw new Error("Probleme : la classe Personne contient des attributs publics !...");
        }

        // Verification des methodes devant etre presentes dans Personne
        try {
            classePersonne.getMethod("donneNom", (Class[])null);
            classePersonne.getMethod("donnePrenom", (Class[])null);
            classePersonne.getMethod("donneDateNaissance", (Class[])null);
        } catch (NoSuchMethodException nse) {
            throw new Error("Probleme : la classe Personne n'a pas de méthode " + nse.getMessage());
        }
        System.out.println("Classe Personne OK...");
    }
}
