package bdt.android.eggfly;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.AutoParallaxBackground;
import org.anddev.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.BuildableTexture;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.opengl.vertex.VertexBuffer;

import android.util.DisplayMetrics;
import bdt.android.eggfly.character.Basket;
import bdt.android.eggfly.character.Eggs;
import bdt.android.eggfly.game.GameManager;
import bdt.android.eggfly.input.InputTouch;

public class MainGame extends BaseGameActivity {
	private static int CAMERA_WIDTH;
	private static int CAMERA_HEIGHT;

	private Camera mCamera;
	private Scene scene;

	private Eggs mSpriteEggs;
	private Basket mSpriteBasket;

	private static MainGame INSTANCE = new MainGame();
	 
	private TextureRegion mTextureRegion;
	private BuildableTexture mBuildableTexture;
	private Texture mTexture;

	private TextureRegion mParallaxLayerBack;
    private TextureRegion mParallaxLayerMid;
    private TextureRegion mParallaxLayerFront;
    
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
		// TODO Auto-generated method stub
		// Load Hình ảnh, âm thanh
		
		// Load Background
		this.mTexture = new Texture(2048,2048,TextureOptions.BILINEAR_PREMULTIPLYALPHA); 
		this.mTextureRegion = TextureRegionFactory.createFromAsset(this.mTexture, this, "tmx/skybg04.png", 0, 0);
		this.mEngine.getTextureManager().loadTexture(this.mTexture);
		 
		// Load Character

		// Load Sound
	}

	@Override
	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		final Scene scene = new Scene();
	 	final float centerX = (CAMERA_WIDTH - this.mTextureRegion.getWidth())/2;
	    final float centerY = (CAMERA_HEIGHT - this.mTextureRegion.getHeight())/2;
	    
	    final AutoParallaxBackground autoParallaxBackground = new AutoParallaxBackground(0, 0, 0, 5);
        autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(0.0f, new Sprite(0, CAMERA_HEIGHT - this.mParallaxLayerBack.getHeight(), this.mParallaxLayerBack)));
        autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(-5.0f, new Sprite(0, 80, this.mParallaxLayerMid)));
        autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(-10.0f, new Sprite(0, CAMERA_HEIGHT - this.mParallaxLayerFront.getHeight(), this.mParallaxLayerFront)));
	    
        SpriteBackground bg = new SpriteBackground(new Sprite(0, 0,mTextureRegion));
	    scene.setBackground(bg);
		this.mEngine.registerUpdateHandler(new FPSLogger());

		// add background to scene

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
