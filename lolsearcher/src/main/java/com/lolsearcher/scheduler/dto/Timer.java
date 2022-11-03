package com.lolsearcher.scheduler.dto;

import java.io.Serializable;

public class Timer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int totalFireCount;
	private boolean runForever;
	private long repeatIntervalMs;
	private long initialOffsetMs;
	private String callbackData;
	
	public Timer() {
		//default
		totalFireCount = 1;
		runForever = false;
		repeatIntervalMs = 1000;
		initialOffsetMs = 0;
		callbackData = null;
	}
	
	public int getTotalFireCount() {
		return totalFireCount;
	}
	public void setTotalFireCount(int totalFireCount) {
		this.totalFireCount = totalFireCount;
	}
	public boolean isRunForever() {
		return runForever;
	}
	public void setRunForever(boolean runForever) {
		this.runForever = runForever;
	}
	public long getRepeatIntervalMs() {
		return repeatIntervalMs;
	}
	public void setRepeatIntervalMs(long repeatIntervalMs) {
		this.repeatIntervalMs = repeatIntervalMs;
	}
	public long getInitialOffsetMs() {
		return initialOffsetMs;
	}
	public void setInitialOffsetMs(long initialOffsetMs) {
		this.initialOffsetMs = initialOffsetMs;
	}
	public String getCallbackData() {
		return callbackData;
	}
	public void setCallbackData(String callbackData) {
		this.callbackData = callbackData;
	}
}
