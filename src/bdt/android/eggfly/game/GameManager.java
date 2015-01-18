package bdt.android.eggfly.game;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

import bdt.android.eggfly.character.Basket;
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
		
		//Cập nhật thông tin trứng
		if (Eggs.INSTANCE.isJump == true)
		{
			switch (ResourceManager.INSTANCE.mMode) 
			{
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
			else
				Eggs.INSTANCE.isJump = false;
		}
		
		//Cập nhật thông tin list rổ
		Basket.INSTANCE.mBasketObjList.get(0).move();
		Basket.INSTANCE.mBasketObjList.get(1).move();
		Basket.INSTANCE.mBasketObjList.get(2).move();
		ResourceManager.INSTANCE.mSpriteBasket1.setPosition(Basket.INSTANCE.mBasketObjList.get(0).floatX, Basket.INSTANCE.mBasketObjList.get(0).floatY);
		ResourceManager.INSTANCE.mSpriteBasket2.setPosition(Basket.INSTANCE.mBasketObjList.get(1).floatX, Basket.INSTANCE.mBasketObjList.get(1).floatY);
		ResourceManager.INSTANCE.mSpriteBasket3.setPosition(Basket.INSTANCE.mBasketObjList.get(2).floatX, Basket.INSTANCE.mBasketObjList.get(2).floatY);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	private boolean IsOut()
	{
		if (Eggs.INSTANCE.isOnGround == true || Eggs.INSTANCE.isJump == false)
			return true;
		
		return false;
	}
}
