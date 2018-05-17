package game.model;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Enemy1 {

	int EX;
	int EY;
	int Size1;
	int Size2;

	public void Enemy1(Graphics arg1, int EX, int EY, int Size1, int Size2) throws SlickException {
		this.EX = EX;
		this.EY = EY;
		this.Size1 = Size1;
		this.Size2 = Size2;
		// Creates Color of player as a box
		arg1.setColor(Color.red);
		// Creates Enemy as a box [ fillRect(PX = player x position, PY = player y
		// position, 30 = length, 30 = width) ]
		arg1.fillRect(EX, EY, Size1, Size2);
	}

	// Creates the Enemy hitBox
	public boolean EnemyHitBox(int PX, int PY) {
		boolean isTouching = false;
		//Makes hitBox
		if (PX + 25 > EX && PX < EX + Size1 && PY + 25 > EY && PY < EY + Size2) {
			isTouching = true;
		} else {
			isTouching = false;
		}
		if(EX > PX)
		{
			EX = EX - 1;
		}
		if(EX < PX)
		{
			EX = EX + 1;
		}
		if(EY > PY)
		{
			EY = EY - 1;
		}
		if(EY < PY)
		{
			EY = EY + 1;
		}
		return isTouching;
	}

}
