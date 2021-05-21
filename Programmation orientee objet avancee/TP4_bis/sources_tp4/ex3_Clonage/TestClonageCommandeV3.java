package clonage_ok;

public class TestClonageCommandeV3 {
    public static void main(String[] args) {
        Commande cmd1 = Commande.creerCommande("Martin");
        Commande cmd2 = Commande.creerCommande("Durand");
        Commande cmd3 = null;

        System.out.println(cmd1);
        System.out.println(cmd2);
        try {
            cmd3 = (Commande) cmd2.clone();
            // Apres clonage, les noms des clients doivent être
            // deux objets différents :
            if (cmd2.donneNomClient() == cmd3.donneNomClient()) {
                throw new Error("Probleme clonage...");
            }

            cmd3.changeNomClient("Dupont");
            System.out.println("Après la copie de la commande");
            // les noms des clients doivent être différents :
            // - pour cmd2 ce doit être Durand
            // - pour cmd3 ce doit être Dupont
            if (!cmd2.donneNomClient().equals("Durand") ||
                    !cmd3.donneNomClient().equals("Dupont")) {
                throw new Error("Probleme clonage...");
            }
            // les commandes doivent toutes avoir des numéros différents
            if (cmd1.donneNumeroCommande() == cmd2.donneNumeroCommande() ||
                    cmd1.donneNumeroCommande() == cmd3.donneNumeroCommande() ||
                    cmd2.donneNumeroCommande() == cmd3.donneNumeroCommande()) {
                throw new Error("Probleme clonage...");
            }
            System.out.println(cmd2);
            System.out.println(cmd3);
        } catch (CloneNotSupportedException e) {
            System.out.println("Duplication de commande interdite");
        }
    }
}
