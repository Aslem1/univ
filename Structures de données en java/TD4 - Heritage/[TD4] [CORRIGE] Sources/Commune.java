public class Commune {

    protected int nbHabitants;
    protected double superficie;

    Commune (int nbH, double s) {
        this.nbHabitants = nbH;
        this.superficie = s;
    }

    public int getNbH() {
        return this.nbHabitants;
    }

    public double getSuperficie() {
        return this.superficie;
    }

    public double ratio() {
        return this.nbHabitants / this.superficie;
    }
}
