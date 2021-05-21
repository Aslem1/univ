package clonage_pb;

public class EnteteCommande {
    // nom du client qui a passe la commande
    private String nomClient;
    // numero de la commande
    private int numeroCommande;

    public EnteteCommande(String nomClient, int numero) {
        this.nomClient = nomClient;
        this.numeroCommande = numero;
    }

    public String donneNomClient() {
        return this.nomClient;
    }

    public void changeNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public int donneNumeroCommande() {
        return this.numeroCommande;
    }

    public void changeNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String toString() {
        return ("numero = " + this.numeroCommande
                + " effectu'ee par : " + this.nomClient);
    }
}
