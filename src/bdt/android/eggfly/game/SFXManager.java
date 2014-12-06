package bdt.android.eggfly.game;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.sound.Sound;

/**
 * This class handles the playback of music and sounds as well as their muted
 * state
 */
public class SFXManager {

	private static final SFXManager INSTANCE = new SFXManager();

	private static Music mMusic;

	private static Sound mClick;
	private static Sound mBackground;
	private static Sound mEggExplosion;

	public static SFXManager getInstance() {
		return INSTANCE;
	}

	// ==========================================
	// VARIABLES
	// ==========================================
	public boolean mSoundsMuted;
	public boolean mMusicMuted;
	
	public SFXManager() {
		// TODO Auto-generated constructor stub
		//Load File sound, music (set looping)
	}
	
	private static void setVolumeForAllSounds(final float pVolume) {
		//set volume sound
	}
	
	public static boolean isSoundMuted() {
		return getInstance().mSoundsMuted;
	}
	
	public static void setSoundMuted(final boolean pMuted) {
		//Set volume, and store Preference
	}
	
	public static boolean toggleSoundMuted() {//toggle
		return getInstance().mMusicMuted;
		
	}
	
	public static void setMusicMuted(final boolean pMuted) {
		//play or stop Music
	}
	
	public static boolean toggleMusicMuted() {
		//toggle music: play --> stop; stop --> play
		return getInstance().mMusicMuted;
		
	}
	
	public static void playMusic() {
		//play Music
	}
	
	public static void pauseMusic() {
		//stop music
	}
	
	//complete
	public static void playClick(final float pRate, final float pVolume) {
		playSound(mClick, pRate, pVolume);
	}
	
	//complete
	public static void playBackground(final float pRate, final float pVolume) {
		playSound(mBackground, pRate, pVolume);
	}
	
	//complete
	public static void playEggExplosion(final float pRate, final float pVolume) {
		playSound(mEggExplosion, pRate, pVolume);
	}
	
	//complete
	private static void playSound(final Sound pSound, final float pRate, final float pVolume) {
		if(SFXManager.isSoundMuted())
			return;
		
		pSound.setRate(pRate);
		pSound.setVolume(pVolume);
		pSound.play();
	}

}
