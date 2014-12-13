package bdt.android.eggfly.character;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.scene.Scene;

/*
 * Manage Eggs
 */
public class Eggs implements IUpdateHandler {
	Sprite mEgg;
	private static int MAX_WIDTH = 480;
	private static int MAX_HEIGHT = 1024;

	public static Eggs INSTANCE = new Eggs();

	// position Eggs
	public float floatX = 0;
	public float floatY = 0;
	
	public float velocityX = 0;
	public float velocityY = 0;
	public float gravity = 0.5f;
	boolean onGround = false;

	public Eggs() {
		// TODO Auto-generated constructor stub
		// initial Eggs
		
	}

	@Override
	public void onUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}
	
	public float getIntX() {
		floatX = mEgg.getX();
		return floatX;
	}

	public void setIntXY(int floatX, int floatY) {
		this.floatX = floatX;
		this.floatY = floatY;
		mEgg.setPosition(floatX, floatY);
	}

	public float getIntY() {
		floatY = mEgg.getY();
		return floatY;
	}

	// generate random position
	public void generatePosition() {

	}

	// move Egg
	public void move(int mode) {
		switch (mode) {
		case 1: //Bay thẳng
			this.velocityX = 0;
			this.velocityY = 1;
			break;
		case 2: //Bay xiên
			
			break;
		default:
			break;
		}
	}

	// reset Position
	public void resetPosition() {

	}
	
	public void updatePosition_ByTime(float time)
	{
	    floatX += velocityX * time;      // Apply horizontal velocity to X position
	    floatY += velocityY * time;      // Apply vertical velocity to X position
	    velocityY += gravity * time;        // Apply gravity to vertical velocity
	    
	    if(floatY > 175.0)
	    {
	    	floatY = 175;
	        velocityY = 0;
	        onGround = true;
	    }
	    
	    if(floatX < 10 || floatX > 190)
	        velocityX *= -1;
	}
	
	public void updatePositionY(int mode)
	{
		switch (mode) {
		case 0: //Bay thẳng
			floatY--;
			break;
		case 1: //Bay xiên
			floatY = floatX * (velocityY / velocityX) - 
				(1/2) * gravity * floatX * floatX / 
				(velocityX * velocityX / (velocityX * velocityX + velocityY * velocityY));  
			break;
		default:
			break;
		}		
	}
	
		

}