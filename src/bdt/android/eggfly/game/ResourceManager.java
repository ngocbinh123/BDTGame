package bdt.android.eggfly.game;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

/**
 * This ResourceManager adds the ability to use a set of lower-quality textures
 * if desired. It also includes methods for determining an accurate Font texture
 * size to prevent wasting valuable texture memory.
 **/
public class ResourceManager extends Object {
	public static ResourceManager INSTANCE = new ResourceManager();

	public Texture mTextureBasket;
	public TiledTextureRegion mTextureRegionBasket;

	public Texture mTextureEgg;
	public TiledTextureRegion mTextureRegionEgg;
	
	public Texture mTextureBackground;
	public TiledTextureRegion mTextureRegionBackground;

	// Retrieves a global instance of the ResourceManager
	public static ResourceManager getInstance() {
		return INSTANCE;
	}
	
	public ResourceManager() {
		// TODO Auto-generated constructor stub
		onLoadGameTexture();
	}

	public void onLoadGameTexture() {
		

	}

}
