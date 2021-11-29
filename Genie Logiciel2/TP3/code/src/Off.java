
public class Off extends State 
{
	@Override
	public void up(Light light) 
	{
		light.setState(new Low());
		System.out.println( "   low brightness" );
	}
}
