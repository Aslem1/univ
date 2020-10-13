
import java.util.ArrayList;

public class ArrayListEtud extends ArrayList<Personne> {

    public ArrayListEtud () {
        super();
    }

    @Override
    public boolean add (Personne p) {
        super.add(0, p);
        return true;
    }
}
