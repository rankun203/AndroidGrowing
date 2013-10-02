package org.rankun.learnforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

	public void queryRes(View view) {
		EditText et1 = (EditText) findViewById(R.id.et1);
		String qesString = et1.getText().toString();
		Intent other = new Intent(this, OtherActivity.class);
		other.putExtra("qes", qesString);
		startActivityForResult(other, 5);
	}

	@Override
	//5, 6, data
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
Toast.makeText(this, "requestCode:" + requestCode + "-resultCode:" + resultCode, Toast.LENGTH_SHORT).show();
		if (resultCode == 6) {
			String ans = data.getStringExtra("ans");
			TextView tv = (TextView)findViewById(R.id.main_activity_ans_tv);
			tv.setText(ans);
		}
	}

}
