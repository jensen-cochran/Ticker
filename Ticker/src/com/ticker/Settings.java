package com.ticker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Settings extends Activity {

	private EditText wageBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
	}
}
