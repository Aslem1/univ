import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Contient une methode utilitaire **/
public class Utils {
    /** Permet de creer un objet LocalDate a partir d'une chaine au format JJ-MM-AA
     *
     * @param date la chaine de caracteres contenant la date
     * @return une instance de LocalDate correspondant a la date fournie
     */
    public static LocalDate creerDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeException dte) {
            System.err.println(dte);
            return null;
        }
    }
}
