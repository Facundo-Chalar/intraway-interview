package com.intraway.fchalar;

import java.sql.Timestamp;
import java.util.ArrayList;

public class FizzBuzz {
	private final Timestamp timeStamp;
	private final long code;
	private final ArrayList<String> list;
	private final String description;
	
	public FizzBuzz(long code, ArrayList<String> list, Timestamp timeStamp, String description) {
		this.code = code;
		this.list = list;
		this.timeStamp = timeStamp;
		this.description = description;
	}
	
	public long getCode() {
		return code;
	}
	public ArrayList<String> getFizzBuzzResult() {
		return list;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public String getDescription() {
		return description;
	}
}
