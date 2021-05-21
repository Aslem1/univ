import java.util.ArrayList;
import java.util.List;

public class TestZoo {
    public static void main (String[] args) {
        // Création d'une liste de mammifères
        List<Mammifere> listeAnimaux = new ArrayList<>();
        
        // Création de nouveaux animaux - Mammiferes
        // Pour MammifereTerrestre : Habitat - Espece - Carnivore (ctrl+mouse hover sur la classe)
        Mammifere cheval = new MammifereTerrestre("Pre", "Equus caballus", false);
        
        // Pour MammifereAquatique : EauDouce - Espece - Carnivore (ctrl+mouse hover sur la classe)
        Mammifere phoque = new MammifereAquatique(false, "Phocidae", true);
        
        
        // Création de nouveaux animaux - Reptiles
        // Pour ReptileAquatique : Venimeux - EauDouce - Espece - Carnivore (ctrl+mouse hover sur la classe)
        Mammifere tortue = new ReptileAquatique(false, false, "Testudines", true);
        
        // Pour ReptileTerrestre : Venimeux - Habitat - Espece - Carnivore (ctrl+mouse hover sur la classe)
        Mammifere dragonDeKomodo = new ReptileTerrestre(true, "îles de Komodo", "Varanus komodoensis", true);
        
        // Ajout des animaux dans le tableau
        listeAnimaux.add(cheval);
        listeAnimaux.add(phoque);
        listeAnimaux.add(tortue);
        listeAnimaux.add(dragonDeKomodo);
        
        // Affichage des animaux
        System.out.println(listeAnimaux);
        
        // for "classique"
        for(int i=0; i<listeAnimaux.size(); i++) {
            System.out.println(listeAnimaux.get(i));
        }
        
        System.out.println("----------------------------");
        
        // foreach
        for (Mammifere m : listeAnimaux) {
            System.out.println(m);
        }
        
        System.out.println("----------------------------");
        
        // foreach java 8+ (stream)
        listeAnimaux.forEach(m -> {
            System.out.println(m);
        });
        
        System.out.println("----------------------------");
        
        // foreach java 8+ (stream - avec référence de méthode)
        listeAnimaux.forEach(System.out::println);
    }
}
