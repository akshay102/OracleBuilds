package com.valueobject;

/**
 * Utility class for calculating average value of build duration
 * @author Akshay Singh
 *
 */
public class Pair {
	
	private int frequency;
	private int total;
	
	public Pair(int total) {
		super();
		this.frequency = 1;
		this.total = total;
	}
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void increaseFrequency() {
		this.frequency++;
	}
	public void increaseTotal(int duration) {
		this.total = this.total + duration;
	}
	public double getAverage() {
		return total/frequency;
	}

}
