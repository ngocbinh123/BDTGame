package bdt.android.eggfly.game;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.content.Context;

/**
 * This ResourceManager adds the ability to use a set of lower-quality textures
 * if desired. It also includes methods for determining an accurate Font texture
 * size to prevent wasting valuable texture memory.
 **/
public class ResourceManager extends Object {
	public static ResourceManager INSTANCE = new ResourceManager();

	public Texture mTextureBasket;
	public TextureRegion mTextureRegionBasket;
	public TextureRegion mTextureRegionBasket2;

	public Texture mTextureEgg;
	public TextureRegion mTextureRegionEgg;
	
	public Texture mTextureBackground;
	public TextureRegion mTextureRegionBackground;
	
	public Texture mAutoParallaxBackgroundTexture;

	public TextureRegion mParallaxLayerBack;
	public TextureRegion mParallaxLayerMid;
	public TextureRegion mParallaxLayerFront;
	
	//public Context pContext;
	

	// Retrieves a global instance of the ResourceManager
	public static ResourceManager getInstance() {
		return INSTANCE;
	}
	
	public ResourceManager() {
		// TODO Auto-generated constructor stub
		//onLoadGameTexture(pContext);
	}

	public void onLoadGameTexture(Context pContext) {
		TextureRegionFactory.setAssetBasePath("tmx/");
		
		this.mTextureBasket = new Texture(512, 512,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mTextureRegionBasket = TextureRegionFactory.createFromAsset(mTextureBasket, 
				pContext, "basket02.png", 0, 0);
		
		
		this.mTextureEgg = new Texture(256, 256,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mTextureRegionEgg = TextureRegionFactory.createFromAsset(mTextureEgg, 
				pContext, "egg.png", 0, 0);
		this.mAutoParallaxBackgroundTexture = new Texture(2048, 2048,TextureOptions.DEFAULT);
		this.mParallaxLayerFront =TextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture, pContext, "skybg04.png", 0,0);
	    this.mParallaxLayerBack = TextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture,  pContext, "skybg04.png", 0,188);
	    this.mParallaxLayerMid = TextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture, pContext, "skybg04.png", 0,669);
	}
	
	public void onLoadBackgroundTexture(Context pContext) {
		TextureRegionFactory.setAssetBasePath("tmx/");
				
		this.mTextureBackground = new Texture(2048, 2048,TextureOptions.BILINEAR_PREMULTIPLYALPHA);			
		
		this.mTextureRegionBackground = TextureRegionFactory.createFromAsset(mTextureBackground, 
				pContext, "skybg04.png", 0, 0);
		
	}

	
}
