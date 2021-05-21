import java.time.LocalDate;
import java.time.Period;

public class VaccinARN implements Vaccin {
	private int limiteAge;
	
	public VaccinARN(int limiteAge) {
		super();
		this.limiteAge = limiteAge;
	}


	@Override
	public boolean condition(Personne p, LocalDate dateCourante) {
		int age = Period.between(p.donneDateNaissance(), dateCourante).getYears();
		if (age > limiteAge ) {
			return true;
		}
		return false;
	}

}
