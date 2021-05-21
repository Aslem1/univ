package clonage_pb;

public class TestClonageCommandeV1 {
    public static void main(String[] args) throws Exception {
        // création de deux commandes
        Commande cmd1 = Commande.creerCommande("Martin");
        Commande cmd2 = Commande.creerCommande("Durand");

        System.out.println(cmd1);
        System.out.println(cmd2);
        // creation de la commande cmd3 par clonage de la commande cmd2
        Commande cmd3 = (Commande) cmd2.clone();
        // changement du client initial de cette commande
        cmd3.changeNomClient("Dupont");

        System.out.println("Apres la copie de la commande");
        System.out.println(cmd2);
        System.out.println(cmd3);
    }
}
