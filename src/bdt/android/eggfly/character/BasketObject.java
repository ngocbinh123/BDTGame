package bdt.android.eggfly.character;

import java.util.LinkedList;
import java.util.Random;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

import android.provider.CalendarContract.Instances;
import bdt.android.eggfly.data.ConstValiable;

public class BasketObject  {
	public static BasketObject INSTANCE = new BasketObject();
	public float floatX = 0;
	public float floatY = 0;
	public float velocityX = 0;
	public float velocityY = 0;
	public float gravity = 0.5f;
	public int mode = -1;
	public Sprite mSpriteBasket;
	public LinkedList<BasketObject> mBasketObjList = new LinkedList<BasketObject>();
	ConstValiable mConsInstance = ConstValiable.INSTANCE;
	public ConstValiable constInstance = ConstValiable.INSTANCE;
	{
		// initial Sprite
		// initial position Basket
	}
	
	public static BasketObject getInstance()
	{
		return INSTANCE;
	}

	//Khởi tạo vị trí và mode
	//Có 3 rổ tương ứng với index={0,1,2}
	public void generatePosition(int index) {
		Random randomGenerator = new Random();
		if(index ==0)
			this.floatY = 100;
		else {
			this.floatY = index*100+300;	
			if (index % 2!=0){
				this.floatX = mConsInstance.mCameraWidth;
				this.mode=1;
			}		
		}

	}

	// move Basket
	/*
	 * -1: Đi ngang trái -> phải 1: Đi ngang phải -> trái 
	 * 1: Đi chéo trên -> dưới
	 * 3: Đi chéo dưới -> trên 4: Đi theo hình Sin 5: Đi theo hình Cos 
	 * 6: Đi theo hình Sin ngược 7: Đi theo hình Cos ngược ...
	 */
	public void move() {
		switch (mode) {
			case -1: //Đi ngang trái -> phải
				//y giữ nguyên, x tăng lên
				velocityX = 5;
				break;
			case 1: //Đi ngang phải -> trái
				//y giữ nguyên, x giảm xuống
				velocityX = -5;
				break;
		}
		floatX = floatX + velocityX;
		if (floatX > mConsInstance.mCameraWidth)
			floatX = -100;
		else if(floatX < -100)
			floatX = mConsInstance.mCameraWidth;
	}

	// Reset Position
	// set về vị trí ban đầu - có thể được dùng cho lần kế tiếp
	public void resetPosition() {
		
	}
	
	public void generatePosition() {		
		for (int i = 0; i < constInstance.mBasketsize; i++) {
			BasketObject obj = new BasketObject();
			mConsInstance.mBasketObjList.add(obj);
			mConsInstance.mBasketObjList.get(i).generatePosition(i);
		}
	}

	
	
}
