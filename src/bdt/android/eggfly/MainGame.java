package bdt.android.eggfly;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;





import android.util.DisplayMetrics;
import android.util.Log;
import bdt.android.eggfly.character.Basket;
import bdt.android.eggfly.character.Eggs;
import bdt.android.eggfly.data.ConstValiable;
import bdt.android.eggfly.game.GameManager;
import bdt.android.eggfly.game.ResourceManager;
import bdt.android.eggfly.input.InputTouch;
import bdt.android.eggfly.background.ParallaxBackground2d;
import bdt.android.eggfly.background.AutoVerticalParallaxBackground;
import bdt.android.eggfly.background.ScrollableParallaxBackground;
public class MainGame extends BaseGameActivity {
	ConstValiable mConsInstance = ConstValiable.INSTANCE;

	public Camera mCamera;
	
	public ScrollableParallaxBackground backgroundParallax;
    
	private static MainGame INSTANCE = new MainGame();
	
	public static MainGame getInstance() {
		return INSTANCE;
	}

	@Override
	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		// load thông số màn hình của thiết bị
		// load thông số màn hình của thiết bị
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		mConsInstance.mCameraWidth =dm.widthPixels;
		mConsInstance.mCameraHeight = dm.heightPixels;
		mConsInstance.mBasketsize = dm.heightPixels / 300;

		// /////////////////////////////////////
		this.mCamera = new Camera(0, 0, mConsInstance.mCameraWidth, mConsInstance.mCameraHeight);
		final Engine engine = new Engine(new EngineOptions(true,
				ScreenOrientation.PORTRAIT, new RatioResolutionPolicy(
						mConsInstance.mCameraWidth, mConsInstance.mCameraHeight), this.mCamera)
				.setNeedsMusic(true).setNeedsSound(true));
		return engine;
	}

	@Override
	public void onLoadResources() {

		// Load hình ảnh, âm thanh		
		ResourceManager.INSTANCE.onLoadGameTexture(this);
		this.mEngine.getTextureManager().loadTexture(ResourceManager.INSTANCE.mTextureBasket);
		this.mEngine.getTextureManager().loadTexture(ResourceManager.INSTANCE.mTextureEgg);
		
		ResourceManager.INSTANCE.onLoadBackgroundTexture(this);

		this.mEngine.getTextureManager().loadTexture(ResourceManager.INSTANCE.mAutoParallaxBackgroundTexture);

	}

	@Override
	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		this.mEngine.registerUpdateHandler(new FPSLogger());
		final Scene scene = new Scene();
		
		backgroundParallax = new ScrollableParallaxBackground(0, 0, 0, mCamera);
		final AutoVerticalParallaxBackground autoParallaxBackground = new AutoVerticalParallaxBackground(0, 0, 0, 1);
		
		autoParallaxBackground.addParallaxEntity(new ParallaxBackground2d.ParallaxBackground2dEntity(-0.2f,-0.2f, new Sprite(0, 0, ResourceManager.INSTANCE.mParallaxLayerMid)));
        scene.setBackground(autoParallaxBackground);

		//scene.attachChild(sprite);
		
		// initial Character
		// add character to scene

		// register character
//		Eggs.INSTANCE = new Eggs();
//		Eggs.INSTANCE.floatX = 150;
//		Eggs.INSTANCE.floatY = 350;
//		Eggs.INSTANCE.gravity = -0.5f;
//		Eggs.INSTANCE.velocityX = 0;
//		Eggs.INSTANCE.velocityY = -12;
//		
        Eggs.INSTANCE = new Eggs();
		Eggs.INSTANCE.resetPosition();
		ResourceManager.INSTANCE.mSpriteEgg.setPosition(Eggs.INSTANCE.floatX, Eggs.INSTANCE.floatY);
		
		scene.attachChild(ResourceManager.INSTANCE.mSpriteEgg);
		// set move enemy - basket
		Basket.INSTANCE = new Basket();
		Basket.INSTANCE.generatePosition();
		
		for(int i =0; i <ResourceManager.INSTANCE.arrSprite.size();i++)
		{
			scene.attachChild(ResourceManager.INSTANCE.arrSprite.get(i));
		}
//		scene.attachChild(ResourceManager.INSTANCE.mSpriteBasket2);
//		scene.attachChild(ResourceManager.INSTANCE.mSpriteBasket3);
		
		// updante cycle game
		GameManager update = new GameManager();
		InputTouch input = new InputTouch();
		
		scene.registerUpdateHandler(update);
		scene.setOnSceneTouchListener(input);
		

		return scene;
	}

	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub

	}

}
