/** classe de test pour CompteBancaire */
public class TestBanque
{
  public static void main(String[] args)
  {
    Banque banque = new Banque("CLC");

    // test creation intiale
    Particulier durand = banque.creerParticulier("Durand", "Robert", "La Rochelle");
    if (durand == null) {
        System.out.println("Probleme sur creation intiale du client Durand");
        System.exit(-1);        
    }
    // test pour verifier que la creation de doublons n'est pas possible
    durand = banque.creerParticulier("Durand", "Robert", "La Rochelle");
    if (durand != null) {
        System.out.println("Probleme sur creation client : doublon");
        System.exit(-1);        
    }
    Particulier martin = banque.creerParticulier("Martin", "Roger", "Nantes");
    if (martin == null) {
        System.out.println("Probleme sur creation intiale d'un client Martin");
        System.exit(-1);        
    }
    CompteBancaireRemunere c1 = banque.creerCompteRemunere(100,5.5,"Durand");
    if (c1 == null) {
        System.out.println("Probleme sur creation intiale d'un compte");
        System.exit(-1);        
    }  
    CompteBancaireRemunere c2 = banque.creerCompteRemunere(0.,4.5,"Martin");
    if (c2 == null) {
        System.out.println("Probleme sur creation intiale d'un compte");
        System.exit(-1);        
    }
    // test pour verifier que la creation d'un compte n'est pas possible
    // lorsque le client n'existe pas...
    CompteBancaireRemunere c3 = banque.creerCompteRemunere(0.,4.5,"Schtroumpf");
    if (c3 != null) {
        System.out.println("Probleme sur creation intiale d'un compte avec client inconnu");
        System.exit(-1);        
    }   
  }
}