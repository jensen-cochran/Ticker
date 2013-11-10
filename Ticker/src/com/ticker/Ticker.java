package com.ticker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ticker extends Activity {
	
	float money;
	boolean startFlag;
	Button startButton;
	TextView moneyEarned;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticker);
        
        money = 0;
        startFlag = false;
        
        startButton = (Button) findViewById(R.id.buttonStart);
        moneyEarned = (TextView) findViewById(R.id.moneyView);
        
        startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startFlag = startFlag ? false : true;
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ticker, menu);
        return true;
    }
    
}
