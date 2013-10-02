package org.rankun.learn_intentapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	MyApp myApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myApp = (MyApp)getApplication();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void clickme(View view) {
		EditText eText = (EditText)findViewById(R.id.txt);
		String estr = eText.getText().toString();
		myApp.setName(estr);
		Intent intent = new Intent(this, org.rankun.learn_intentapplication.OtherActivity.class);
		startActivity(intent);
	}

}
