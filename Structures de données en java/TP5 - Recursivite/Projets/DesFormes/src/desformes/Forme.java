package desformes;

import java.awt.*;

public class Forme
{


	Forme(int x, int y, Graphics g )
	{
		Figure( x,y,100,4,g);
	}

	private int Aleatoire(int min, int max)
	{
		return  min +(int)(Math.random()*(max - min + 1));
	}
	
	public void Attendre()
	{
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
			}
	}
	
	public Color AleaCouleur()
	{
		return new Color( Aleatoire(0,255) , Aleatoire(0,255), Aleatoire(0,255)); 
	}


	public void Figure( int x, int y, int largeur, int profondeur, Graphics g )
	{
	
			g.setColor( AleaCouleur() );
			g.fillRect( x-(largeur/2),y-(largeur/2), largeur, largeur);
						
	}

}