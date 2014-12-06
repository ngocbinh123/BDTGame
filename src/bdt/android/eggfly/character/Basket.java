package bdt.android.eggfly.character;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.sprite.Sprite;

/*
 * Manage Basket
 */
public class Basket implements IUpdateHandler {
	float floatX = 0;
	float floatY = 0;

	public static Basket INSTANCE = new Basket();
	Sprite mBasket;

	public Basket() {
		// TODO Auto-generated constructor stub
		// initial Sprite
		// initial position Basket
	}

	// generate random position when initial basket
	// y - Fixed (khoãng cách giữa các basket)
	// x - vị trí ngẫu nhiên
	public void generatePosition() {

	}

	// move Basket
	/*
	 * 0: đi ngang trái -> phải 1: đi ngang phải -> trái 2: đi tréo trên -> dưới
	 * 3: đi tréo dưới -> trên 4: đi theo hình Sin 5: đi theo hình Cos 6: đi
	 * theo hình Sin ngược 7: đi theo hình Cos ngược ...
	 */
	public void move(int mode) {

	}

	// reset Position
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