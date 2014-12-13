package bdt.android.eggfly.game;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

import bdt.android.eggfly.character.Eggs;

/*
 * Update entity enemy - basket
 */
public class GameManager implements IUpdateHandler{
	public static int intScore = 0;

	/*
	 * (non-Javadoc)
	 * @see org.anddev.andengine.engine.handler.IUpdateHandler#onUpdate(float)
	 * test egg in 
	 * 	basket - load new basket
	 * 	floor - finish game
	 */
	@Override
	public void onUpdate(float pSecondsElapsed) {
		
		switch (ResourceManager.INSTANCE.mMode) {
		case 0:
			//Eggs.INSTANCE.updatePositionY(0);
			Eggs.INSTANCE.updatePosition_ByTime(pSecondsElapsed);
			break;
		case 1:
			Eggs.INSTANCE.floatX++;
			Eggs.INSTANCE.updatePositionY(1);
			break;
		default:
			break;
		}
		
		if (IsOut() == false)
			ResourceManager.INSTANCE.mSpriteEgg.setPosition(Eggs.INSTANCE.floatX, Eggs.INSTANCE.floatY);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	private boolean IsOut()
	{
		if (Eggs.INSTANCE.floatY > 800 || Eggs.INSTANCE.floatX < 0 
				|| Eggs.INSTANCE.floatX > 500)
			return true;
		
		return false;
	}
}
