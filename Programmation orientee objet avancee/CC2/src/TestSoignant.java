import java.lang.reflect.Field;
import java.time.LocalDate;

public class TestSoignant {

    public static void testAttributsSuperClasse(Personne p, String nom, String prenom, LocalDate naissance) {
        if (!p.donneNom().equals(nom)) {
            throw new Error("Probleme nom soignant : " + nom);
        }
        if (!p.donnePrenom().equals(prenom)) {
            throw new Error("Probleme prenom soignant : " + prenom);
        }
        if (!p.donneDateNaissance().equals(naissance)) {
            throw new Error("Probleme date de naissance soignant : " + nom + ", date = " + naissance);
        }
    }

    public static void testAttributsSoignant(Soignant soignant, String nom, String prenom, LocalDate naissance, int numPS) {
        testAttributsSuperClasse(soignant, nom, prenom, naissance);
        if (soignant.donneNumPS() != numPS) {
            throw new Error("Probleme sur numero professionnel de sante : " + nom);
        }
    }

    public static void main(String[] args) {
        Class classeSoignant = Soignant.class;

        // Verification qu'un enseignant est une personne
        if (classeSoignant.getSuperclass() != Personne.class) {
            throw new Error("Probleme : la classe Soignant n'herite pas de Personne");
        }

        // Detection d'attributs non privés dans la classe Personne...
        int nbMethodes = classeSoignant.getFields().length;
        if (nbMethodes != 0) {
            String noms = "";
            for(Field nomAtt : classeSoignant.getFields()) {
                noms += nomAtt.getName() + " ";
            }
            throw new Error("Probleme : la classe Soignant contient des attributs publics : " + noms);
        }

        // creation d'instances
        Soignant dupont = new Soignant("Dupont", "Pierre", Utils.creerDate("11/7/1974"), 17144678);
        Soignant durand = new Soignant("Durand", "Karine", Utils.creerDate("11/7/1984"), 33654321);

        // verification des instances cr'e'ees
        testAttributsSoignant(dupont, "Dupont", "Pierre", Utils.creerDate("11/7/1974"), 17144678);
        testAttributsSoignant(durand, "Durand", "Karine", Utils.creerDate("11/7/1984"), 33654321);

        System.out.println("Classe Soignant OK...");

    }
}
