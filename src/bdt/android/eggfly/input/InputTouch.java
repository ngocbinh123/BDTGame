package bdt.android.eggfly.input;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.input.touch.TouchEvent;

import bdt.android.eggfly.MainGame;
import bdt.android.eggfly.background.AutoVerticalParallaxBackground;

// handle input user
public class InputTouch implements IOnSceneTouchListener {
	private String TAG = "EGG FLY";
	public float mTouchX = 0, mTouchOffsetX = 0;
	public Camera mCamera = MainGame.getInstance().mCamera;
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub

		AutoVerticalParallaxBackground.mParallaxValueY -= AutoVerticalParallaxBackground.changePerSecond * 100;
        return true;
	}

}
