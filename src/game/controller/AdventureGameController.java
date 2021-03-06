package game.controller;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import game.model.Enemy1;
import game.model.TileBorder;

public class AdventureGameController extends BasicGame {
	// Initialize all of the data members

	// Player
	int PX = 270, PY = 270, EX = 500, EY = 500;

	// Initialize Border
	TileBorder tileBorder = new TileBorder();

	// Initialize Enemies Here
	Enemy1 enemy = new Enemy1();
	Enemy1 enemy1 = new Enemy1();

	// Create DeathScreen
	Image DeathScreen;
	boolean drawDeathScreen;
	boolean isTouching = false;


	// Makes the window and connects it to the runner class
	public void makeWindow() {
		try {
			AppGameContainer app = new AppGameContainer(new AdventureGameController());
			app.setDisplayMode(1000, 600, false);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.start();
		} catch (Exception e) {

		}
	}

	// Put the Game title here(Thats all)
	public AdventureGameController() {
		super("Adventure");
	}

	// Draw Images Here or Animations
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// Creates the backGround color of the opening room
		arg1.setColor(new Color(0, 100, 200));
		// Creates the background object
		arg1.fillRect(0, 0, 1000, 600);

		// Creates Color of player as a box
		arg1.setColor(Color.white);
		// Creates player as a box [ fillRect(PX = player x position, PY = player y
		// position, 30 = length, 30 = width) ]
		arg1.fillRect(PX, PY, 30, 30);

		// Creates Enemy
		arg1.setColor(Color.red);
		arg1.fillRect(EX, EY, 50, 50);


		if (drawDeathScreen == true) {
			DeathScreen.draw(0, 0);
		}

		// creates top border
		tileBorder.border(arg1, 0, 0, 1000, 10);
		// creates left border
		tileBorder.border(arg1, 0, 0, 10, 600);
		// creates right border
		tileBorder.border(arg1, 990, 0, 10, 600);
		// creates bottom border
		tileBorder.border(arg1, 0, 590, 1000, 10);

	}

	// Initialize Images
	@Override
	public void init(GameContainer arg0) throws SlickException {
		DeathScreen = new Image("res/DeathScreen.png");
	}

	// Logic, Update, Actual Code (physics and gravity etc...)
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		EX = enemy.moveX(PX);
		EY = enemy.moveY(PY);
		
		// gets input from keyboard
		Input input = arg0.getInput();
		// Moves the player using the arrow keys
		// moves player left

		// Makes hitBox for Enemy
		if (PX + 25 > EX && PX < EX + 50 && PY + 25 > EY && PY < EY + 50) {
			isTouching = true;
		} else {
			isTouching = false;
		}
		
		if (drawDeathScreen != true) {
			if (input.isKeyDown(Input.KEY_LEFT)) {
				PX -= 7;
			}
			// moves player right
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				PX += 7;
			}
			// moves player up
			if (input.isKeyDown(Input.KEY_UP)) {
				PY -= 7;
			}
			// moves player down
			if (input.isKeyDown(Input.KEY_DOWN)) {
				PY += 7;
			}
			
		}

		// creates borders
		PX = tileBorder.borderHitBoxX(PX);
		PY = tileBorder.borderHitBoxY(PY);

		// If player touches Enemy
		if (isTouching) {
			drawDeathScreen = true;
		}
		if (drawDeathScreen == true) {
			if (input.isKeyDown(Input.KEY_SPACE)) {
				drawDeathScreen = false;
				PX = 270;
				PY = 270;
				EX = 500;
				EY = 500;
				EX = enemy.moveX(PX);
				EY = enemy.moveY(PY);
			}
		}

	}

}
