package bdt.android.eggfly;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.AutoParallaxBackground;
import org.anddev.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.sprite.TiledSprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;


import android.util.DisplayMetrics;
import bdt.android.eggfly.character.Basket;
import bdt.android.eggfly.character.Eggs;
import bdt.android.eggfly.game.GameManager;
import bdt.android.eggfly.game.ResourceManager;
import bdt.android.eggfly.input.InputTouch;
import bdt.android.eggfly.background.ParallaxBackground2d;
import bdt.android.eggfly.background.AutoVerticalParallaxBackground;
public class MainGame extends BaseGameActivity {
	private static int CAMERA_WIDTH;
	private static int CAMERA_HEIGHT;

	private Camera mCamera;
	private Scene scene;
	

	private Eggs mSpriteEggs;
	private Basket mSpriteBasket;
	
    
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
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		CAMERA_WIDTH = width;
		CAMERA_HEIGHT = height;
		// /////////////////////////////////////
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		final Engine engine = new Engine(new EngineOptions(true,
				ScreenOrientation.PORTRAIT, new RatioResolutionPolicy(
						CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera)
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

		final AutoVerticalParallaxBackground autoParallaxBackground = new AutoVerticalParallaxBackground(0, 0, 0, 200);
        autoParallaxBackground.addParallaxEntity(new ParallaxBackground2d.ParallaxBackground2dEntity(-0.2f,-0.2f, new Sprite(0, 0, ResourceManager.INSTANCE.mParallaxLayerMid)));
        scene.setBackground(autoParallaxBackground);
		
		final float centerX = (CAMERA_WIDTH - ResourceManager.INSTANCE.mTextureBackground.getWidth())/2;
	    final float centerY = (CAMERA_HEIGHT - ResourceManager.INSTANCE.mTextureBackground.getHeight())/2;

		//scene.attachChild(sprite);
		
		// initial Character
		// add character to scene

		// register character

		// set move enemy - basket
		
		// update cycle game
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
