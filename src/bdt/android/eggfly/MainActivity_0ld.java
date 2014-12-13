package bdt.android.eggfly;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.BuildableTexture;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.buffer.*;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.Callback;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity_0ld extends BaseGameActivity {


	 private static final int CAMERA_WIDTH = 480;
	 private static final int CAMERA_HEIGHT = 800;
	 
	 private TextureRegion mTextureRegion;
	 private BuildableTexture mBuildableTexture;
	 private Texture mTexture;
	 @Override
	 public Engine onLoadEngine() {
	  
	  final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	  final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	  engineOptions.getTouchOptions().setRunOnUpdateThread(true);
	  return new Engine(engineOptions);
	 }

	 @Override
	 public void onLoadResources() {
		 //this.mTexture = new Texture(1024, 1024,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		 
		 //this.mTextureRegion = TextureRegionFactory.createFromAsset(this.mTexture, this, "tmx/skybg03.png", 0, 0);
		 this.mEngine.getTextureManager().loadTexture(this.mTexture);

		  
		  // load icon
//		    this.mTexture = new Texture(256, 256,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
//		    mTextureRegion = TextureRegionFactory.createFromSource(this.mTexture, this, "backgroundgid.png", 0, 0);
//		    this.mEngine.getTextureManager().loadTexture(this.mTexture);
	 }

	 @Override
	 public Scene onLoadScene() {
		 	final Scene scene = new Scene();
		 	final float centerX = (CAMERA_WIDTH - this.mTextureRegion.getWidth()) / 2;
		    final float centerY = (CAMERA_HEIGHT - this.mTextureRegion.getHeight()) / 2;
		    SpriteBackground bg = new SpriteBackground(new Sprite(centerX, centerY,mTextureRegion));
		    
		    scene.setBackground(bg);
			this.mEngine.registerUpdateHandler(new FPSLogger());
			return scene;
	 }

	 @Override
	 public void onLoadComplete() {
	  // TODO Auto-generated method stub
	  
	 }

	 

	
}
