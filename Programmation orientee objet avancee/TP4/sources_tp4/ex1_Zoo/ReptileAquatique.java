/**
 * Classe représentant un reptile aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un indicateur booleen precisant si le reptile evolue dans l'eau douce.
 */
public class ReptileAquatique
{
   private String nomEspece;   
   private boolean venimeux;
   private boolean eauDouce;
   
   public ReptileAquatique(String nom, boolean venimeux, boolean eauDouce)
   {
      this.nomEspece = nom;      
      this.venimeux = venimeux;
      this.eauDouce = eauDouce;
   }
}
