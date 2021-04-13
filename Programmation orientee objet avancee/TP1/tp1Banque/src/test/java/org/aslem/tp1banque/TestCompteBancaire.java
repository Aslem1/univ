package org.aslem.tp1banque;

/** classe de test pour CompteBancaire */
public class TestCompteBancaire
{
  public static void main(String[] args)
  {
      Client durand = new Client("Durand", "La Rochelle");
    Client martin = new Client("Martin", "Nantes");

      CompteBancaire c1 = new CompteBancaire(1,100,durand);
    // necessaire pour associer Client -> Compte
    if (!durand.ajouteCompte(c1)) {
        System.out.println("Probleme sur l'attribution du compte a : " + durand);
        System.exit(-1);                
    }
    // test pour verifier qu'on ne peut pas attribuer 2 fois le meme compte
    if (durand.ajouteCompte(c1)) {
        System.out.println("Probleme compte attribue deux fois a : " + durand);
        System.exit(-1);                
    }
    
    CompteBancaire c2 = new CompteBancaire(2,0,martin);
    martin.ajouteCompte(c2);
   
    double solde_c1 = c1.consulter();
    final int montantDebit = 50;
    c1.debiter(montantDebit);
    if (c1.consulter() != solde_c1 - montantDebit) {
        System.out.println("Probleme sur debit de " + c1);
        System.exit(-1);
    }
    double solde_c2 = c2.consulter();
    final int montantCredit = 30;
    c2.crediter(montantCredit);
    if (c2.consulter() != solde_c2 + montantCredit) {
        System.out.println("Probleme sur credit de " + c2);
        System.exit(-1);
    }
    
    final int montantTransfert = 50;
    solde_c1 = c1.consulter();
    solde_c2 = c2.consulter();
    c1.transferer(c2,montantTransfert);
    if ((c1.consulter() != solde_c1 - montantTransfert) || (c2.consulter() != solde_c2 + montantTransfert)) {
        System.out.println("Probleme sur transfert entre " + c1 + " et " + c2);
        System.exit(-1);        
    }          
  }
}