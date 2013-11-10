package com.ticker;

public class Tick {

	private static int millisecondsPerHour = 3600000;

	private double cash;
	private double wage;
	private double rate;
	private int deltaTime;

	public Tick() {
		cash = 0;
		deltaTime = 0;
		wage = 0;
		rate = 0;
	}

	public Tick(double _wage) {
		cash = 0;
		deltaTime = 0;
		setWage(_wage);
		setRate();
	}

	public void setWage(double _wage) {
		wage = _wage;
		setRate();
	}

	public double getCash() {
		return cash;
	}

	private void setRate() {
		rate = (deltaTime * wage) / (double)millisecondsPerHour;
	}

	public void update(int _deltaTime) {
		deltaTime = _deltaTime;
		setRate();
		cash += rate;
	}
}