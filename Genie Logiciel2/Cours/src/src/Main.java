import java.util.logging.Level;
import java.util.logging.Logger;

import decorator.Chantilly;
import decorator.Chocolat;
import dessert.Crepe;
import dessert.Dessert;
import dessert.Gaufre;

public class Main 
{
	public static void main(String[] args) 
	{
		Logger log = Logger.getLogger("log");
		
		// Creation d'une gaufre au chocolat
		Dessert gaufreChocolat = new Gaufre();
		gaufreChocolat = new Chocolat(gaufreChocolat);
		log.log(Level.INFO, gaufreChocolat.toString());
		
		// Creation d'une crepe chocolat + chantilly
		Dessert crepeChocolatChantilly = new Crepe();
		crepeChocolatChantilly = new Chocolat(crepeChocolatChantilly);
		crepeChocolatChantilly = new Chantilly(crepeChocolatChantilly);
		log.log(Level.INFO, crepeChocolatChantilly.toString());
	}
}