package bdt.android.eggfly.data;

import bdt.android.eggfly.game.GameManager;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/*
 * Store data game - mark
 */
public class DBGame {
	public static final String MyPREFERENCES = "MyPrefs";
	public static final String MaximaxMark = "mark";
	SharedPreferences sharedpreferences;
	Activity mActivity;
	public int intMark = 0;

	public DBGame(Activity para) {
		// TODO Auto-generated constructor stub
		mActivity = para;
		sharedpreferences = mActivity.getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		if (sharedpreferences.contains(MaximaxMark)) {
			intMark = sharedpreferences.getInt(MaximaxMark, 0);

		}
	}

	public void saveMaxMark(int mark) {
		if (GameManager.intScore > intMark) {
			Editor editor = sharedpreferences.edit();
			editor.putInt(MaximaxMark, GameManager.intScore);
			editor.commit();
		}
	}

	public int getMaxMark() {
		int intResult = -1;
		if (sharedpreferences.contains(MaximaxMark)) {
			intResult = sharedpreferences.getInt(MaximaxMark, 0);
		}
		return intResult;
	}

}
