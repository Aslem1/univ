import java.io.IOException;

/**
 *
 * @author P. Rodriguez
 */
public class App {

    public static void main(String[] args) throws IOException {
        Personne marc,paul,marcBis;
        marc = new Personne (5, "Dupond", "Marc", 'h', 1978, "Plongeur", 3);
        paul = new Personne (6,"Durand", "Paul", 'h', 1980, "Surfeur", 4);
        marcBis = new Personne (5,"Dupond", "marcBis", 'h', 1978, "Plongeur", 3);
        Personne marcTer = marc;
    }
}

