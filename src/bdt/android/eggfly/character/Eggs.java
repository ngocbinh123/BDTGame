package bdt.android.eggfly.character;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

/*
 * Manage Eggs
 */
public class Eggs implements IUpdateHandler {
	Sprite mEgg;
	public static Eggs INSTANCE = new Eggs();

	// position Eggs
	float floatX = 0;
	float floatY = 0;

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

	// generate random position
	public void generatePosition() {

	}

	// move Egg
	public void move(int mode) {

	}

	// reset Position
	public void resetPosition() {

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

}