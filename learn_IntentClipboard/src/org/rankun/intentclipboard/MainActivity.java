package org.rankun.intentclipboard;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void btnClick (View view) {
		EditText txtEditText = (EditText)findViewById(R.id.mainEditText);
		String msg = txtEditText.getText().toString();
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			setTextToClipBod("msg", msg);
		} else {
			setTextToClipBod2(msg);
		}

		Intent intent = new Intent(this, OtherActivity.class);
		startActivity(intent);
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setTextToClipBod (String tag, String textString) {
		ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
		clipboardManager.setPrimaryClip(ClipData.newPlainText(tag, textString));
	}
	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.ECLAIR_MR1)
	private void setTextToClipBod2 (String textString) {
		android.text.ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		clipboardManager.setText(textString);
	}


}
