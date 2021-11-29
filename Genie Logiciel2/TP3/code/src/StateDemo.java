import java.io.IOException;
import java.util.Scanner;

public class StateDemo 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner entree = new Scanner(System.in);
		Light light = new Light();
		String c = "";
		while(!c.equals("q"))
		{
			System.out.println("Press 'a' to increase, 'd' for decrease or 'q' for quit (and press 'enter' to valid)");
			c = entree.nextLine();
			if(c.equals("a"))
				light.incBrightness();
			else if(c.equals("d"))
				light.decBrightness();
		}
		System.out.println("Quit");
		entree.close();
	}
}
