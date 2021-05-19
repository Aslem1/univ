import java.lang.reflect.Field;
import java.time.LocalDate;

public class TestPatient {

    public static void testAttributsSuperClasse(Personne p, String nom, String prenom, LocalDate naissance) {
        if (!p.donneNom().equals(nom)) {
            throw new Error("Probleme nom patient : " + nom);
        }
        if (!p.donnePrenom().equals(prenom)) {
            throw new Error("Probleme prenom patient : " + prenom);
        }
        if (!p.donneDateNaissance().equals(naissance)) {
            throw new Error("Probleme date de naissance patient : " + nom + ", date = " + naissance);
        }
    }

    public static void testAttributsPatient(Patient patient, String nom, String prenom, LocalDate naissance, long numDossier) {
        testAttributsSuperClasse(patient, nom, prenom, naissance);
        if (patient.donneNumDossier() != numDossier) {
            throw new Error("Probleme sur le numero de dossier : " + nom);
        }
    }

    public static void main(String[] args) {
        Class classePatient = Patient.class;

        // Verification qu'un enseignant est une personne
        if (classePatient.getSuperclass() != Personne.class) {
            throw new Error("Probleme : la classe Patient n'herite pas de Personne");
        }

        // Detection d'attributs non privés dans la classe Personne...
        int nbMethodes = classePatient.getFields().length;
        if (nbMethodes != 0) {
            String noms = "";
            for(Field nomAtt : classePatient.getFields()) {
                noms += nomAtt.getName() + " ";
            }
            throw new Error("Probleme : la classe Soignant contient des attributs publics : " + noms);
        }

        // creation d'instances
        Patient allen = new Patient("Allen", "Paul", Utils.creerDate("21/02/1953"), 1530211234055L);
        Patient gates = new Patient("Gates", "Bill", Utils.creerDate("28/10/1955"), 1551044672134L);

        // verification de ces instances
        testAttributsPatient(allen,"Allen", "Paul", Utils.creerDate("21/02/1953"), 1530211234055L);
        testAttributsPatient(gates, "Gates", "Bill", Utils.creerDate("28/10/1955"), 1551044672134L);

        System.out.println("Classe Patient OK...");
    }
}
