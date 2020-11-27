public abstract class Fiche 
{
    private int classement;
    private String titre;
    private int annee;
    private String plateforme;
    private double ventes;

    public Fiche(int classement, String titre, int annee, String plateforme, double ventes) {
        this.classement = classement;
        this.titre = titre;
        this.annee = annee;
        this.plateforme = plateforme;
        this.ventes = ventes;
    }

    public int getClassement() {
        return classement;
    }

    public String getTitre() {
        return titre;
    }

    public int getAnnee() {
        return annee;
    }

    public String getPlateforme() {
        return plateforme;
    }

    public double getVentes() {
        return ventes;
    }

    @Override
    public String toString() {
        return "Fiche{" + "classement=" + classement + ", titre=" + titre + ", annee=" + annee + ", plateforme=" + plateforme + ", ventes=" + ventes + '}';
    }
    
    public abstract int compareTo( Fiche f);
 }

class FicheClassement extends Fiche
{

    public FicheClassement(int classement, String titre, int annee, String plateforme, double ventes) {
        super(classement, titre, annee, plateforme, ventes);
    }

    
    
    public int compareTo( Fiche f){
        FicheClassement fc = (FicheClassement) f;
        if (fc.getClassement()> this.getClassement() ) return -1;
        else if (fc.getClassement() == this.getClassement() ) return 0;
             else return 1;
    } 
}

class FicheAnnee extends Fiche
{

    public FicheAnnee(int classement, String titre, int annee, String plateforme, double ventes) {
        super(classement, titre, annee, plateforme, ventes);
    }        
    
    public int compareTo( Fiche f){
        FicheAnnee fv = (FicheAnnee) f;
        if (fv.getAnnee()> this.getAnnee() ) return -1;
        else if (fv.getAnnee() == this.getAnnee() ) return 0;
             else return 1;
    } 
}
