package org.rankun.learnforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);

		//设置传来的问题
		Intent requestIntent = getIntent();
		String qes = requestIntent.getStringExtra("qes");
		((TextView)findViewById(R.id.qes)).setText(qes);
	}

	public void procAndRtn(View view) {
		String ansString = ((EditText)findViewById(R.id.otheractivity_et_1)).getText().toString();
		Intent rtnIntent = new Intent(this, MainActivity.class);
		rtnIntent.putExtra("ans", ansString);
		setResult(6, rtnIntent);
		finish();
	}

}
