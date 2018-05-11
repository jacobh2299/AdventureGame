package game.model;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TileBorder 
{
	boolean isTouching;
	public void border(Graphics arg1, int StartX, int StartY, int BorderX, int BorderY )
	{
		//Sets rectangle color
		arg1.setColor(Color.black);
		//creates border
		arg1.fillRect(StartX, StartY, BorderX, BorderY);
	}
	public boolean getIsTouching()
	{
		return isTouching;
	}
	
}
