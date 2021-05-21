public class TestTypeCovidTest {
    public static void main(String[] args) {
        if (TypeCovidTest.values().length != 4) {
            throw new Error("Probleme : le nombre de valeurs enumerees est incorrect");
        }
        float sommeTaux = 0.f;
        for(TypeCovidTest typeTest : TypeCovidTest.values()) {
            sommeTaux += typeTest.donneFiabilite();
        }
        float moyenneTaux = sommeTaux / TypeCovidTest.values().length;
        if (moyenneTaux != 85.75) {
            throw new Error("Probleme : le moyenne des taux de fiabilite est incorrecte");
        }

        Patient allen = new Patient("Allen", "Paul", Utils.creerDate("21/02/1953"), 1530211234055L);
        Soignant dupont = new Soignant("Dupont", "Pierre", Utils.creerDate("11/7/1974"), 17144678);

        // modification de la classe Personne
        allen.seFaireDepister(Utils.creerDate("06/05/2021"), dupont, TypeCovidTest.RT_PCR);
        // mais la modification doit etre compatible avec le code deja existant...
        allen.seFaireDepister(Utils.creerDate("16/05/2021"), dupont);

        System.out.println("Classe TestTypeCovidTest OK...");


    }
}
