/**
 * Classe représentant un mammifere aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore,
 * - un indicateur booleen precisant si le mammifere evolue dans l'eau douce.
 */
public class MammifereAquatique
{
   private String nomEspece;
   private boolean carnivore;
   private boolean eauDouce;

   public MammifereAquatique(String nom, boolean carnivore, boolean eauDouce)
   {
      this.nomEspece = nom;
      this.carnivore = carnivore;
      this.eauDouce = eauDouce;
   }
}
