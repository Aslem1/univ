/**
 * Classe représentant un reptile terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un nom d'habitat (biotope).
 */
public class ReptileTerrestre
{
   private String nomEspece;
   private boolean venimeux;
   private String habitat;

   public ReptileTerrestre(String nom, boolean venimeux, String habitat)
   {
      this.nomEspece = nom;      
      this.venimeux = venimeux;
      this.habitat = habitat;
   }
}
