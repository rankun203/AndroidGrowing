package org.rankun.intentclipboard;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		TextView msgTextView = (TextView)findViewById(R.id.otherTextView);
		String str = null;
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			str = getTextFromClipBod();
		} else {
			str = getTextFromClipBod2();
		}
		msgTextView.setText(str);
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private String getTextFromClipBod () {
		ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		String str = clipboardManager.getPrimaryClip().getItemAt(0).coerceToText(this).toString();
		return str;
	}
	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.ECLAIR_MR1)
	private String getTextFromClipBod2 () {
		android.text.ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		String str = clipboardManager.getText().toString();
		return str;
	}

}
