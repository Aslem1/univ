public class TestIsolement {
    public static void main(String[] args) {

        Personne dupont = new Soignant("Dupont", "Pierre", Utils.creerDate("11/7/1974"), 17144678);
        if (dupont.dureeIsolement() != 7) {
            throw new Error("Probleme : la duree d'isolement pour les soignants est de 7 jours !...");
        }
        Personne allen = new Patient("Allen", "Paul", Utils.creerDate("21/02/1953"), 1530211234055L);
        if (allen.dureeIsolement() != 10) {
            throw new Error("Probleme : la duree d'isolement pour les patients est de 10 jours !...");
        }
        System.out.println("Classe TestIsolement OK...");

    }
}
