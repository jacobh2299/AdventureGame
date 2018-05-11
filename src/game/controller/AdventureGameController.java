package game.controller;
import game.model.TileBorder;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class AdventureGameController extends BasicGame
{
	//Initialize all of the data members
	
	//Player
	int PX = 470, PY = 270;
	
	//Initialize Border
	TileBorder tileBorder = new TileBorder();

	
	//Makes the window and connects it to the runner class
	public void makeWindow()
	{
		try {
			AppGameContainer app = new AppGameContainer(new AdventureGameController());
			app.setDisplayMode(1000,600,false);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.start();
			}
		catch(Exception e)
		{
			
		}
	}
	

	//Put the Game title here(Thats all)
	public AdventureGameController() 
	{
		super("Adventure");
	}

	//Draw Images Here or Animations
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException 
	{
		//Creates the backGround color of the opening room
		arg1.setColor(new Color(0, 100, 200));
		//Creates the background object
		arg1.fillRect(0, 0, 1000, 600);
		
		//Creates Color of player as a box
		arg1.setColor(Color.white);
		//Creates player as a box [ fillRect(PX = player x position, PY = player y position, 30 = length, 30 = width) ]
		arg1.fillRect(PX, PY, 30, 30);

		//calls rectangle
		//creates top border
		tileBorder.border(arg1, 0, 0, 1000, 10);
		//creates left border
		tileBorder.border(arg1, 0, 0, 10, 600);
		//creates right border
		tileBorder.border(arg1, 990, 0, 10, 600);
		//creates bottom border
		tileBorder.border(arg1, 0, 590, 1000, 10);


				
	}

	//Initialize Images
	@Override
	public void init(GameContainer arg0) throws SlickException 
	{
		
	}

	//Logic, Update, Actual Code (physics and gravity etc...)
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException 
	{
		//gets input from keyboard
		Input input = arg0.getInput();
		//Moves the player using the arrow keys
		//moves player left
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			PX -=7;
		}
		//moves player right
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			PX +=7;
		}
		//moves player up
		if(input.isKeyDown(Input.KEY_UP))
		{
			PY -=7;
		}
		//moves player down
		if(input.isKeyDown(Input.KEY_DOWN))
		{
			PY +=7;
		}
		
		
		//creates borders
		
		
		
		
		
		
		
		
		
	}

}
