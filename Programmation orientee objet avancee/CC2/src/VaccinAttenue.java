import java.time.LocalDate;

public class VaccinAttenue implements Vaccin {

	@Override
	public boolean condition(Personne p, LocalDate dateCourante) {
		return true;
	}

}
