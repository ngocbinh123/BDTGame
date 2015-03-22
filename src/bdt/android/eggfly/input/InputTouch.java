package bdt.android.eggfly.input;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.input.touch.TouchEvent;

import bdt.android.eggfly.MainGame;
import bdt.android.eggfly.background.AutoVerticalParallaxBackground;
import bdt.android.eggfly.character.Eggs;

// handle input user
public class InputTouch implements IOnSceneTouchListener {
	private String TAG = "EGG FLY";
	public float mTouchX = 0, mTouchOffsetX = 0;
	public Camera mCamera = MainGame.getInstance().mCamera;
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// handle background 
		AutoVerticalParallaxBackground.mParallaxValueY -= AutoVerticalParallaxBackground.changePerSecond * 100;
		
		// handle egg
		Eggs.INSTANCE.isJump = true;
		Eggs.INSTANCE.isOnGround = false;
		Eggs.INSTANCE.isInBasket = false;
		if (Eggs.INSTANCE.velocityY > 0)
			Eggs.INSTANCE.velocityY *= -1;

        return true;
	}

}
