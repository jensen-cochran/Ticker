package com.ticker;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;
import android.widget.TextView;
import android.widget.EditText;

public class Ticker extends Activity {
	
	private Handler mHandler;
	
	// ticker function is handled in this Tick object
	private Tick ticker;
	
	// starts/stops ticker on button press
	private boolean startFlag;
	
	// button which turns on and off ticker
	private ToggleButton switchOn;
	
	// displayed gui ticker
	private TextView moneyEarned;
	
	// how often to update the ticker in milliseconds
	private int deltaTime = 100;

	
    private Runnable mStatusChecker = new Runnable() {
    	@Override
    	public void run() {
    		// updates the status of the ticker (if button is toggled on)
    		updateStatus(deltaTime);
    		mHandler.postDelayed(mStatusChecker, deltaTime);
    	}
    };
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticker);
        
        // initial button to off
        startFlag = false;
        
        // initialize button and ticker
        switchOn = (ToggleButton) findViewById(R.id.switchOn);
        moneyEarned = (TextView) findViewById(R.id.moneyView);
        
        // creates the ticker object and sets the display to the ticker TextView
        ticker = new Tick(9000.00);
        ticker.setDisplay(moneyEarned);
        
        
        switchOn.setOnClickListener(new View.OnClickListener() {
			
        	// toggle the start flag if the button is pressed
			@Override
			public void onClick(View v) {
				startFlag = startFlag ? false : true;
			}
		});
        
        mHandler = new Handler();
        
        mStatusChecker.run();
    }

	// Creates the main menu to hold settings and possibly other options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ticker, menu);
        
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
        	// starts the settings activity if "Settings" is pressed
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				setContentView(R.layout.activity_settings);
				return false;
			}
		});
        
        return true;
    }
    
    // updates the ticker if the button is toggled on
    private void updateStatus(int _deltaTime) {
    	if (startFlag) {
    		ticker.update(_deltaTime);
    	}
    		
    }
}
