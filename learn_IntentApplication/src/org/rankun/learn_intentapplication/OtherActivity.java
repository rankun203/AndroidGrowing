package org.rankun.learn_intentapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	private MyApp myApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		myApp = (MyApp)getApplication();
		TextView textView = (TextView)findViewById(R.id.textView);
		textView.setText(myApp.getName());
	}
	
}
