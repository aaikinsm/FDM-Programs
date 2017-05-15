package com.fdmgroup;

public class FilingCabinet {
	private static FilingCabinet fc;
	
	private static String name;
	private static int count;
	
	

	private FilingCabinet(){
		
	}
	
	private static void init(){
		name = "My Filing Cabinet";
		count++;
	}
	
	public static FilingCabinet getInstance(){
		if (fc==null)
			fc = new FilingCabinet();
		init();
		return fc;		
	}
	
	public static int getCount() {
		return count;
	}
}
