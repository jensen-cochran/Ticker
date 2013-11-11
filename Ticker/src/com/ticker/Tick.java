package com.ticker;

import android.widget.TextView;

// Allows the creation of the ticker
public class Tick {

	private static int millisecondsPerHour = 3600000;

	// holds the amount of cash made so far (the ticker value)
	private double cash;
	
	// holds hourly wage
	private double wage;
	
	// holds the amount the ticker should change per update
	private double rate;
	
	// holds the change in time between updates
	private int deltaTime;
	
	// actual displayed ticker
	private TextView display;

	// default constructor
	public Tick() {
		cash = 0;
		deltaTime = 0;
		wage = 0;
		rate = 0;
	}

	// sets the wage to the passed value
	// rate will always be zero since deltaTime is 0
	public Tick(double _wage) {
		cash = 0;
		deltaTime = 0;
		setWage(_wage);
		setRate();
	}

	// sets wage to the passed value
	// also sets rate
	public void setWage(double _wage) {
		wage = _wage;
		setRate();
	}
	
	// sets the ticker gui value
	public void setDisplay(TextView _display) {
		display = _display;
		update(0);
	}

	// returns the cash made so far
	public double getCash() {
		return cash;
	}

	// sets the amount per tick for the ticker to add
	private void setRate() {
		rate = (deltaTime * wage) / (double)millisecondsPerHour;
	}

	// updates the display of the ticker with a new cash value
	public void update(int _deltaTime) {
		deltaTime = _deltaTime;
		setRate();
		cash += rate;
		display.setText(String.format("$%.2f", getCash()));
	}
}