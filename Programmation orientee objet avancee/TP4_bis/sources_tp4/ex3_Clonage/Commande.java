package clonage_pb;

/**
 * Classe representant une commande
 */
public class Commande {
    // compteur du nombre de commandes creees
    private static int nombreCommandes = 0;
    private EnteteCommande entete;

    // le constructeur est inaccessible pour obliger l'utilisateur
    // a utiliser la methode creerCommande pour creer des commandes
    private Commande(String nomClient, int numeroCommande) {
        this.entete = new EnteteCommande(nomClient, numeroCommande);
    }

    // permet la creation de commande
    public static Commande creerCommande(String nomClient) {
        // utilisation de la variable de classe nombreCommandes
        // pour attribuer un nouveau numéro à chaque commande
        return new Commande(nomClient, ++nombreCommandes);
    }

    // permet d'obtenir le nom du client d'une commande
    public String donneNomClient() {
        return this.entete.donneNomClient();
    }

    // permet de modifier le client d'une commande
    public void changeNomClient(String nomClient) {
        this.entete.changeNomClient(nomClient);
    }

    // permet d'obtenir le numero d'une commande
    public int donneNumeroCommande() {
        return this.entete.donneNumeroCommande();
    }

    // permet la copie de commandes
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return ("Commande " + this.entete);
    }
}
