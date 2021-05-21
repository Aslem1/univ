import java.util.Collections;
import java.util.List;

public class TestRegistreCovid {
    public static void main(String[] args) {
        // creation du registre de tests
        RegistreCovidTest registre = new RegistreCovidTest();

        Patient allen = new Patient("Allen", "Paul", Utils.creerDate("21/02/1953"), 1530211234055L);
        Soignant dupont = new Soignant("Dupont", "Pierre", Utils.creerDate("11/7/1974"), 17144678);

        CovidTest testAllen1 = allen.seFaireDepister(Utils.creerDate("06/05/2021"), dupont);
        // enregistrement du test d'Allen
        boolean enregAllen = registre.enregistrer(testAllen1);
        if (!enregAllen) {
            throw new Error("Probleme : le test d'Allen n'a pas ete enregistre");
        }
        // verification que le meme test ne peut pas etre enregistre 2 fois...
        enregAllen = registre.enregistrer(testAllen1);
        if (enregAllen) {
            throw new Error("Probleme : le meme test ne peut pas etre enregistre plusieurs fois");
        }

        Patient gates = new Patient("Gates", "Bill", Utils.creerDate("28/10/1955"), 1551044672134L);
        CovidTest testGates1 = gates.seFaireDepister(Utils.creerDate("12/05/2021"), dupont);
        // enregistrement du test de Gates
        registre.enregistrer(testGates1);

        Patient bezos = new Patient("Bezos", "Jeffrey", Utils.creerDate("12/01/1964"), 1640144672134L);
        CovidTest testbezos1 = bezos.seFaireDepister(Utils.creerDate("16/05/2021"), dupont);
        // enregistrement du test de Bezos
        registre.enregistrer(testbezos1);

        List<CovidTest> tests = registre.donneListeTests();
        // tris sans que 2 elements soient egaux...
        // premier tri par date
        Collections.sort(tests, new TriTestParDate());
        CovidTest premierTest = tests.get(0);
        // le premier test est celui d'Allen... (date la + ancienne)
        if (! premierTest.donnePersonne().donneNom().equals("Allen") ||
                ! premierTest.donneDate().equals(Utils.creerDate("06/05/2021"))) {
            throw new Error("Probleme : le premier test du tri par date (sans egalite) est incorrect ");
        }
        CovidTest dernierTest = tests.get(tests.size()-1);
        // ... et le dernier celui de Bezos...
        if (! dernierTest.donnePersonne().donneNom().equals("Bezos") ||
                ! dernierTest.donneDate().equals(Utils.creerDate("16/05/2021"))) {
            throw new Error("Probleme : le dernier test du tri par date (sans egalite) est incorrect ");
        }

        // second tri par nom
        Collections.sort(tests, new TriTestParNom());
        premierTest = tests.get(0);
        // le premier test est celui d'Allen... (nom debutant par 'A')
        if (! premierTest.donnePersonne().donneNom().equals("Allen") ||
                ! premierTest.donneDate().equals(Utils.creerDate("06/05/2021"))) {
            throw new Error("Probleme : le premier test du tri par nom (sans egalite) est incorrect ");
        }
        // ... et le dernier celui de Gates...
        dernierTest = tests.get(tests.size()-1);
        if (! dernierTest.donnePersonne().donneNom().equals("Gates") ||
                ! dernierTest.donneDate().equals(Utils.creerDate("12/05/2021"))) {
            throw new Error("Probleme : le dernier test du tri par nom (sans egalite) est incorrect ");
        }

        // tris avec des elements egaux
        CovidTest testAllen2 = allen.seFaireDepister(Utils.creerDate("10/05/2021"), dupont);
        registre.enregistrer(testAllen2);

        Patient zuckerberg = new Patient("Zuckerberg", "Marc", Utils.creerDate("14/05/1984"), 1840544672114L);
        CovidTest testZuck = zuckerberg.seFaireDepister(Utils.creerDate("16/05/2021"), dupont);
        registre.enregistrer(testZuck);

        tests = registre.donneListeTests();
        // premier tri par date
        Collections.sort(tests, new TriTestParDate());
        premierTest = tests.get(0);
        // le premier test est toujours celui d'Allen... (date la + ancienne)
        if (! premierTest.donnePersonne().donneNom().equals("Allen") ||
                ! premierTest.donneDate().equals(Utils.creerDate("06/05/2021"))) {
            throw new Error("Probleme : le premier test du tri par date (avec egalite) est incorrect ");
        }
        dernierTest = tests.get(tests.size()-1);
        // ... et le dernier celui de Zuckerberg... (meme date que Bezos mais apres dans l'ordre alphabetique)
        if (! dernierTest.donnePersonne().donneNom().equals("Zuckerberg") ||
                ! dernierTest.donneDate().equals(Utils.creerDate("16/05/2021"))) {
            throw new Error("Probleme : le dernier test du tri par date (avec egalite) est incorrect : ");
        }

        // second tri par nom
        Collections.sort(tests, new TriTestParNom());
        premierTest = tests.get(0);
        // le premier test est celui d'Allen... (nom debutant par 'A')
        if (! premierTest.donnePersonne().donneNom().equals("Allen") ||
                ! premierTest.donneDate().equals(Utils.creerDate("06/05/2021"))) {
            throw new Error("Probleme : le premier test du tri par nom (avec egalite) est incorrect ");
        }
        // ... et le dernier celui de Zuckerberg...
        dernierTest = tests.get(tests.size()-1);
        if (! dernierTest.donnePersonne().donneNom().equals("Zuckerberg") ||
                ! dernierTest.donneDate().equals(Utils.creerDate("16/05/2021"))) {
            throw new Error("Probleme : le dernier test du tri par nom (avec egalite) est incorrect ");
        }

        System.out.println("TestRegistreCovid OK...");

    }
}
