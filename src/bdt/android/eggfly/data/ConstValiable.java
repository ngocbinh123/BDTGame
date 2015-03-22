package bdt.android.eggfly.data;

import java.util.LinkedList;

import bdt.android.eggfly.character.BasketObject;

public class ConstValiable {
	public static ConstValiable INSTANCE = new ConstValiable();
	public static ConstValiable getInstance(){
		return INSTANCE;
	}

	// camera
	public int mCameraHeight;
	public int mCameraWidth;

	// basket size
	public int mBasketCount = mCameraHeight/300;

	// background
	public int mBGHeight = 2048;
	public int mBGWidth = 2048;

	// basket
	public int mBasketHeigth = 128;
	public int mBasketWidth = 128;
	public int mBasketsize=1;
	public LinkedList<BasketObject> mBasketObjList = new LinkedList<BasketObject>();
	// egg
	public int mEggHeigth = 64;
	public int mEggWidth = 64;
}
