import java.time.LocalDate;

public interface Vaccin {
	boolean condition(Personne p, LocalDate dateCourante);
}
