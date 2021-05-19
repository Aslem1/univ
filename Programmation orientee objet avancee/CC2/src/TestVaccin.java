import java.time.LocalDate;

public class TestVaccin {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Dupont", "Paul", Utils.creerDate("04/04/1965"), 1530211234055L);
        Patient patient2 = new Patient("Durand", "Albert", Utils.creerDate("28/11/1975"), 1530211234055L);
        Vaccin vaccin1 = new VaccinARN(55);
        Vaccin vaccin2 = new VaccinAttenue();

        // la date courante est fournie pour que la methode puis calculer l'age du patient
        if (! patient1.vaccinCompatible(LocalDate.now(),vaccin1)) {
            throw new Error("Probleme : le vaccin ARN est compatible avec l'age de Dupont");
        }

        if (! patient1.vaccinCompatible(LocalDate.now(),vaccin2)) {
            throw new Error("Probleme : le vaccin attenue est toujours compatible");
        }

        if (patient2.vaccinCompatible(LocalDate.now(),vaccin1)) {
            throw new Error("Probleme : le vaccin ARN est incompatible avec l'age de Durand");
        }

        if (! patient2.vaccinCompatible(LocalDate.now(),vaccin2)) {
            throw new Error("Probleme : le vaccin attenue est toujours compatible");
        }

        System.out.println("Classe TestVaccin OK...");

    }
}
