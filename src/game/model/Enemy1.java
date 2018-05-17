package game.model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Enemy1 {

	int EX;
	int EY;
	int Size1;
	int Size2;


	
	public int moveX(int PX)
	{
		if (EX > PX) {
			EX = EX - 1;
		}
		if (EX < PX) {
			EX = EX + 1;
		}
		return EX;
	}
	public int moveY(int PY)
	{
		if (EY > PY) {
			EY = EY - 1;
		}
		if (EY < PY) {
			EY = EY + 1;
		}
		return EY;
	}

}
