package bdt.android.eggfly.character;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

import bdt.android.eggfly.data.ConstValiable;

/*
 * Manage Eggs
 */
public class Eggs implements IUpdateHandler {
	Sprite mEgg;
	static float MAX_WIDTH = 480;
	static float MAX_HEIGHT = 800;
	static float minY = 400;
	public ConstValiable constInstance = ConstValiable.INSTANCE;
	public static Eggs INSTANCE = new Eggs();

	//position Eggs
	public float floatX = 0;
	public float floatY = 0;
	
	public int mode = 0;
	public float velocityX = 0;
	public float velocityY = 0;
	public float gravity = 0.5f;
	public boolean isOnGround = false;
	public boolean isJump = false;
	public boolean isInBasket = false;
	
	public float diffFloatX = 0;
	public float diffFloatY = 0;
	
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
	public void move(float time) {
		switch (mode) {
		case 0: //Go up straight
			updatePosition_ByTime(time);
			break;
		case 1: //Go up oblique			
			//updatePositionY();
			break;
		default:
			break;
		}
	}

	// reset Position
	public void resetPosition() {
		floatX = constInstance.mCameraWidth/2;
		floatY = constInstance.mCameraHeight-100;
		gravity = 0.1f;
		velocityX = 0;
		velocityY = -12;
	}
	
	//For go up
	public void updatePosition_ByTime(float time)
	{
	    floatX += velocityX;      // Apply horizontal velocity to X position
	    floatY += velocityY;      // Apply vertical velocity to X position
	    velocityY += gravity;     // Apply gravity to vertical velocity
	    
	    //test collision
	    /*
	    if(floatY > MAX_HEIGHT || floatY < 0 || floatX < 0 || floatX > MAX_WIDTH)
	    {
	    	floatY = MAX_HEIGHT;
	        velocityY = 0;
	        isOnGround = true;
	        isJump = false;
	    }*/
	    
	    if(floatY < minY && velocityY <= 0) //When up to max height, it will go down
	        velocityY *= -1;
	}
	
	//For go up oblique
	public void updatePositionY()
	{
		floatX++;
		floatY = floatX * (velocityY / velocityX) - 
			(1/2) * gravity * floatX * floatX / 
			(velocityX * velocityX / (velocityX * velocityX + velocityY * velocityY));
	}
	
	
}