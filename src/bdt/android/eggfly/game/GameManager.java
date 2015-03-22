package bdt.android.eggfly.game;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

import android.util.Log;
import bdt.android.eggfly.character.Basket;
import bdt.android.eggfly.character.BasketObject;
import bdt.android.eggfly.character.Eggs;
import bdt.android.eggfly.data.ConstValiable;

/*
 * Update entity enemy - basket
 */
public class GameManager implements IUpdateHandler{
	public static int intScore = 0;
	ConstValiable mConsInstance = ConstValiable.INSTANCE;
	/*
	 * (non-Javadoc)
	 * @see org.anddev.andengine.engine.handler.IUpdateHandler#onUpdate(float)
	 * test egg in 
	 * 	basket - load new basket
	 * 	floor - finish game
	 */
	private Object log;
	@Override
	public void onUpdate(float pSecondsElapsed) {
		
		//Cập nhật thông tin trứng
		if (Eggs.INSTANCE.isJump == true)
		{
//			switch (ResourceManager.INSTANCE.mMode) 
//			{
//				case 0:
//					//Eggs.INSTANCE.updatePositionY(0);
//					Eggs.INSTANCE.updatePosition_ByTime(pSecondsElapsed);
//					break;
//				case 1:
//					Eggs.INSTANCE.floatX++;
//					Eggs.INSTANCE.updatePositionY(1);
//					break;
//				default:
//					break;
//			}
//			
//			if (IsOut() == false)
//				ResourceManager.INSTANCE.mSpriteEgg.setPosition(Eggs.INSTANCE.floatX, Eggs.INSTANCE.floatY);				
//			else
//				Eggs.INSTANCE.isJump = false;
			//Then, code about collide, next basket, next mode of eggs
			if (Eggs.INSTANCE.isInBasket == false && isEggInBasket())
			{
				Eggs.INSTANCE.isInBasket = true;
				Eggs.INSTANCE.isJump = false;
				Eggs.INSTANCE.diffFloatX = Eggs.INSTANCE.floatX - Basket.INSTANCE.mBasketObjList.get(0).floatX;
				Eggs.INSTANCE.diffFloatY = Eggs.INSTANCE.floatY - Basket.INSTANCE.mBasketObjList.get(0).floatY;
			}
			
			if (Eggs.INSTANCE.isInBasket == true)
			{
				Eggs.INSTANCE.floatX = Basket.INSTANCE.mBasketObjList.get(0).floatX + Eggs.INSTANCE.diffFloatX;
				Eggs.INSTANCE.floatY = Basket.INSTANCE.mBasketObjList.get(0).floatY + Eggs.INSTANCE.diffFloatY;
				ResourceManager.INSTANCE.mSpriteEgg.setPosition(Eggs.INSTANCE.floatX, Eggs.INSTANCE.floatY);
			}
			
			if (isOut() == true)
			{
				Eggs.INSTANCE.isJump = false;
				Eggs.INSTANCE.resetPosition();
				ResourceManager.INSTANCE.mSpriteEgg.setPosition(Eggs.INSTANCE.floatX, Eggs.INSTANCE.floatY);
			}
		}

		//Cập nhật thông tin list rổ
		for(int i =0; i < mConsInstance.mBasketsize;i++)
		{
			
			Basket.INSTANCE.mBasketObjList.get(i).move();
			ResourceManager.INSTANCE.arrSprite.get(i).setPosition(Basket.INSTANCE.mBasketObjList.get(i).floatX, Basket.INSTANCE.mBasketObjList.get(i).floatY);
		} 
//		Basket.INSTANCE.mBasketObjList.get(0).move();
//		Basket.INSTANCE.mBasketObjList.get(1).move();
//		Basket.INSTANCE.mBasketObjList.get(2).move();
//		ResourceManager.INSTANCE.mSpriteBasket1.setPosition(Basket.INSTANCE.mBasketObjList.get(0).floatX, Basket.INSTANCE.mBasketObjList.get(0).floatY);
//		ResourceManager.INSTANCE.mSpriteBasket2.setPosition(Basket.INSTANCE.mBasketObjList.get(1).floatX, Basket.INSTANCE.mBasketObjList.get(1).floatY);
//		ResourceManager.INSTANCE.mSpriteBasket3.setPosition(Basket.INSTANCE.mBasketObjList.get(2).floatX, Basket.INSTANCE.mBasketObjList.get(2).floatY);
	
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	private boolean isOut()
	{
		if (Eggs.INSTANCE.isOnGround == true)
			return true;
		
		return false;
	}
	
	//Check eggs when down: being in basket or not
	//If yes: isJump = false, isInBasket = true, position of egg = position of basket
	public boolean isEggInBasket()
	{
		boolean result = false;
		
		if (Eggs.INSTANCE.velocityY > 0
				&& Eggs.INSTANCE.floatY < Basket.INSTANCE.mBasketObjList.get(0).floatY + 10
				&& Eggs.INSTANCE.floatY > Basket.INSTANCE.mBasketObjList.get(0).floatY - 10
				//&& Eggs.INSTANCE.floatX >= Basket.INSTANCE.mBasketObjList.get(0).floatX
				//&& Eggs.INSTANCE.floatX <= Basket.INSTANCE.mBasketObjList.get(0).floatX + 20
				)
		{
			result = true;
			Log.v("isEggInBasket", String.valueOf(result));
		}
		
		//Log.v("isEggInBasket", String.valueOf(result));
		return result;
	}
}
