package bdt.android.eggfly.background;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.scene.background.ParallaxBackground;


public class ScrollableParallaxBackground extends ParallaxBackground {
 
        private float cameraPreviousX;
        private float cameraOffsetX;
 
        private Camera camera;
 
        public ScrollableParallaxBackground(final float pRed, final float pGreen,
                        final float pBlue, Camera camera) {
                super(pRed, pGreen, pBlue);
 
                this.camera = camera;
                cameraPreviousX = camera.getMinX();
                this.mParallaxValue = -this.camera.getMinX();
        }
 
        @Override
        public void onUpdate(float pSecondsElapsed) {
          super.onUpdate(pSecondsElapsed);

          if (cameraPreviousX != this.camera.getMinX()) {
            cameraOffsetX = cameraPreviousX - this.camera.getMinX();
            cameraPreviousX = this.camera.getMinX();
            
            this.mParallaxValue += cameraOffsetX;
          }
          
        }
 
}
