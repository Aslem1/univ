package ampoule;


public class Low extends State 
{
	@Override
	public void up(Light light) 
	{
		light.setState(new Medium());
		System.out.println("   medium brightness");
	} 
	
	@Override
	public void down(Light light)
	{
		light.setState(new Off());
		System.out.println("   turning off");
	}
}
