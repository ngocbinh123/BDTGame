package bdt.android.eggfly;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btnPlay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		
		/*
		btnPlay = (Button)findViewById(R.id.btnPlay);
		
		btnPlay.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplication(),MainGame.class);
				startActivity(i);
				return false;
			}
		});*/
		
		Intent i = new Intent(getApplication(),MainGame.class);
		startActivity(i);
	}
}
