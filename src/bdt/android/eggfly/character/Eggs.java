package bdt.android.eggfly.character;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

/*
 * Manage Eggs
 */
public class Eggs implements IUpdateHandler {
	Sprite mEgg;
	static float MAX_WIDTH = 480;
	static float MAX_HEIGHT = 800;
	static float minY = 400;

	public static Eggs INSTANCE = new Eggs();

	// position Eggs
	public float floatX = 0;
	public float floatY = 0;
	
	public float velocityX = 0;
	public float velocityY = 0;
	public float gravity = 0.5f;
	public boolean isOnGround = false;
	public boolean isJump = false;
	
	
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
		floatX = 180;
		floatY = 600;
		gravity = 0.5f;
		velocityX = 0;
		velocityY = 1;
	}
	
	public void updatePosition_ByTime(float time)
	{
	    floatX += velocityX;      // Apply horizontal velocity to X position
	    floatY += velocityY;      // Apply vertical velocity to X position
	    velocityY += gravity;        // Apply gravity to vertical velocity
	    
	    //test collision
	    
	    if((velocityY < 0 && floatY > MAX_HEIGHT -200) || floatY < 0 || floatX < 0 || floatX > MAX_WIDTH)
	    {
	    	floatY = MAX_HEIGHT;
	        velocityY = 0;
	        isOnGround = true;
	        isJump = false;
	    }	    
	    
	    if(floatY < minY) //Nhảy đến 1 mức nào đó thì quay đầu
	        velocityY *= -1;
	}
	
	public void updatePositionY(int mode)
	{
		switch (mode) {
		case 0: //Bay thẳng
			floatY = floatY - velocityY;
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