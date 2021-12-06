
public class Light 
{
	private State current;

	public Light() 
	{
		current = new Off();
	}

	public void setState(State state) 
	{
		current = state;
	}

	public void incBrightness() 
	{
		current.up(this);
	}

	public void decBrightness() 
	{
		current.down(this);
	}
}
