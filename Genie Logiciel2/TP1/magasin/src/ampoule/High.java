
public class High extends State 
{
	@Override
	public void down(Light light)
	{
		light.setState(new Medium());
		System.out.println("   medium brightness");
	}
}