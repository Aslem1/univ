/**
 * Classe représentant un mammifere terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore
 * - un nom d'habitat (biotope).
 */
public class MammifereTerrestre
{
   private String nomEspece;   
   private boolean carnivore;
   private String habitat;
   
   public MammifereTerrestre(String nom, boolean carnivore, String habitat)
   {
      this.nomEspece = nom;      
      this.carnivore = carnivore;
      this.habitat = habitat;
   }
}
