import java.util.List;

public class TestDepistage {

    public static void main(String[] args) {
        Patient allen = new Patient("Allen", "Paul", Utils.creerDate("21/02/1953"), 1530211234055L);
        Soignant dupont = new Soignant("Dupont", "Pierre", Utils.creerDate("11/7/1974"), 17144678);

        // premier test
        CovidTest testAllen1 = allen.seFaireDepister(Utils.creerDate("06/05/2021"), dupont);
        if (testAllen1.donneResultat()) {
            throw new Error("Probleme : le test d'Allen devrait etre negatif (car non contamine) ");
        }
        if (testAllen1.donnePersonne() != allen) {
            throw new Error("Probleme : le test n'est pas celui d'Allen ");
        }
        if (!testAllen1.donneDate().equals(Utils.creerDate("06/05/2021"))) {
            throw new Error("Probleme : la date du test d'Allen ne correspond pas");
        }
        if (testAllen1.donneTesteur() != dupont) {
            throw new Error("Probleme : le soignant qui a effectue le test d'Allen ne correspond pas");
        }

        // contamination d'Allen
        allen.devientContamine(Utils.creerDate("15/05/2021"));

        // second test
        CovidTest testAllen2 = allen.seFaireDepister(Utils.creerDate("16/05/2021"), dupont);
        if (! testAllen2.donneResultat()) {
            throw new Error("Probleme : le test d'Allen devrait etre positif (car contamine) ");
        }

        List<CovidTest> testsEffectues = allen.donneDepistagesEffectues();
        if (testsEffectues.size() != 2) {
            throw new Error("Probleme : le nombre de tests effectues par Allen devrait etre 2");
        }
        // le premier test de la liste doit etre le dernier effectue...
        if (! testsEffectues.get(0).donneDate().equals(Utils.creerDate("16/05/2021"))) {
            throw new Error("Probleme : le premier test doit etre le dernier effectu'e ");
        }
        if (! testsEffectues.get(1).donneDate().equals(Utils.creerDate("06/05/2021"))) {
            throw new Error("Probleme : le dernier test doit etre le premier effectu'e ");
        }

        System.out.println("Classe TestDepistage OK...");
    }
}
