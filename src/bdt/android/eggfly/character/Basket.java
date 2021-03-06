package bdt.android.eggfly.character;

import java.util.LinkedList;
import java.util.Random;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

import android.util.Log;
import bdt.android.eggfly.data.ConstValiable;

/*
 * Manage Basket
 */

public class Basket implements IUpdateHandler {

	public static Basket INSTANCE = new Basket();
	public LinkedList<BasketObject> mBasketObjList = new LinkedList<BasketObject>();
	public ConstValiable constInstance = ConstValiable.INSTANCE;
	public Basket() {
	}

	//generate random position when initial basket
	public void generatePosition() {

		for (int i = 0; i < constInstance.mBasketsize; i++) {
			BasketObject obj = new BasketObject(); 
			mBasketObjList.add(obj);
			mBasketObjList.get(i).generatePosition(i);
		}
	}
	
	// Cuộn rổ và tạo mới rổ thứ 3
//	public void generateNextPosition() {
//		mBasketObjList.remove(0);
//		mBasketObjList.get(0).floatY += 200;
//		mBasketObjList.get(1).floatY += 200;
//		
//		BasketObject obj3 = new BasketObject();
//		mBasketObjList.add(obj3);
//	}

	// move Basket
	/*
	 * 0: Đi ngang trái -> phải 1: Đi ngang phải -> trái 2: Đi chéo trên -> dưới
	 * 3: Đi chéo dưới -> trên 4: Đi theo hình Sin 5: Đi theo hình Cos 
	 * 6: Đi theo hình Sin ngược 7: Đi theo hình Cos ngược ...
	 */
	public void move() {
		
	}

	// Reset Position
	// set về vị trí ban đầu - có thể được dùng cho lần kế tiếp
	public void resetPosition() {
		
	}

	@Override
	public void onUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}