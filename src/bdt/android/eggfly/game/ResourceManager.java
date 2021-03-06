package bdt.android.eggfly.game;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import bdt.android.eggfly.data.ConstValiable;
import android.content.Context;

/**
 * This ResourceManager adds the ability to use a set of lower-quality textures
 * if desired. It also includes methods for determining an accurate Font texture
 * size to prevent wasting valuable texture memory.
 **/
public class ResourceManager extends Object {
	public static ResourceManager INSTANCE = new ResourceManager();
	public ConstValiable constInstance = ConstValiable.INSTANCE;
	public Texture mTextureBasket;
	public TextureRegion mTextureRegionBasket;

	public Texture mTextureEgg;
	public TextureRegion mTextureRegionEgg;
	
	public Texture mTextureBackground;
	public TextureRegion mTextureRegionBackground;
	
	public Sprite mSpriteEgg;
	
	public List<Sprite> arrSprite; 
	
	public Texture mAutoParallaxBackgroundTexture;
	public TextureRegion mParallaxLayerBack;
	public TextureRegion mParallaxLayerMid;
	public TextureRegion mParallaxLayerFront;
	
	public int mMode = 0;
	//public Context pContext;
	ConstValiable mConsInstance = ConstValiable.INSTANCE;

	// Retrieves a global instance of the ResourceManager
	public static ResourceManager getInstance() {
		return INSTANCE;
	}
	
	public ResourceManager() {
		
		// TODO Auto-generated constructor stub
		//onLoadGameTexture(pContext);
		
	}

	public void onLoadGameTexture(Context pContext) {
		this.arrSprite = new ArrayList<Sprite>();
		TextureRegionFactory.setAssetBasePath("tmx/");
		
		this.mTextureBasket = new Texture(constInstance.mBasketWidth,constInstance.mBasketHeigth,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mTextureRegionBasket = TextureRegionFactory.createFromAsset(mTextureBasket, 
				pContext, "basket.png", 0, 0);
		
		
		this.mTextureEgg = new Texture(constInstance.mEggWidth, constInstance.mEggHeigth,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mTextureRegionEgg = TextureRegionFactory.createFromAsset(mTextureEgg, 
				pContext, "egg.png", 0, 0);

		this.mSpriteEgg = new Sprite(0, 0, ResourceManager.INSTANCE.mTextureRegionEgg);
		
//		this.mSpriteBasket1 = new Sprite(0, 0, ResourceManager.INSTANCE.mTextureRegionBasket);
//		this.mSpriteBasket2 = new Sprite(0, 0, ResourceManager.INSTANCE.mTextureRegionBasket);
//		this.mSpriteBasket3 = new Sprite(0, 0, ResourceManager.INSTANCE.mTextureRegionBasket);
		for(int i=0;i<mConsInstance.mBasketsize;i++)
		{
			Sprite item =new Sprite(0, 0, ResourceManager.INSTANCE.mTextureRegionBasket);
			arrSprite.add(item);
		}
		this.mAutoParallaxBackgroundTexture = new Texture(constInstance.mBGWidth,constInstance.mBGHeight,TextureOptions.DEFAULT);
		this.mParallaxLayerFront =TextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture, pContext, "skybg04.png", 0,0);
	    this.mParallaxLayerBack = TextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture,  pContext, "skybg04.png", 0,188);
	    this.mParallaxLayerMid = TextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture, pContext, "skybg04.png", 0,669);
	
	}
	
	public void onLoadBackgroundTexture(Context pContext) {
		TextureRegionFactory.setAssetBasePath("tmx/");
				
		this.mTextureBackground = new Texture(constInstance.mBGWidth,constInstance.mBGHeight,TextureOptions.BILINEAR_PREMULTIPLYALPHA);			
		
		this.mTextureRegionBackground = TextureRegionFactory.createFromAsset(mTextureBackground, 
				pContext, "skybg04.png", 0, 0);
		
	}

	
}
