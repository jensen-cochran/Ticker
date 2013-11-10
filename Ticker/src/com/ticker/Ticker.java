package com.ticker;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ticker extends Activity {
	
	private Handler mHandler;
	
	private Tick ticker;
	
	private boolean startFlag;
	private Button startButton;
	private TextView moneyEarned;
	
	private int deltaTime = 100;

    private Runnable mStatusChecker = new Runnable() {
    	@Override
    	public void run() {
    		updateStatus(deltaTime);
    		mHandler.postDelayed(mStatusChecker, deltaTime);
    	}
    };
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticker);
        
        ticker = new Tick(7.25);
        
        startFlag = false;
        
        startButton = (Button) findViewById(R.id.buttonStart);
        moneyEarned = (TextView) findViewById(R.id.moneyView);
        
        startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startFlag = startFlag ? false : true;
			}
		});
        
        mHandler = new Handler();
        
        mStatusChecker.run();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ticker, menu);
        return true;    	
    }
    
    private void updateStatus(int _deltaTime) {
    	if (startFlag) {
    		ticker.update(_deltaTime);
    		moneyEarned.setText(String.valueOf(ticker.getCash()));
    	}
    		
    }
}
