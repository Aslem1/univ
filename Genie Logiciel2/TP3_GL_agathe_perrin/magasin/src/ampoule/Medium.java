package ampoule;


public class Medium extends State 
{
	@Override
	public void up(Light light) 
	{
		light.setState(new High());
		System.out.println("   high brightness");
	} 
	
	@Override
	public void down(Light light)
	{
		light.setState(new Low());
		System.out.println("   low brightness");
	}
}
