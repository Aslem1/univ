package ampoule;



public abstract class State 
{
	public void up(Light light) 
	{
		light.setState(new Off());
		System.out.println("   turning off");
	} 
	
	public void down(Light light) 
	{
		light.setState(new High());
		System.out.println("   high brightness");
	} 
}
